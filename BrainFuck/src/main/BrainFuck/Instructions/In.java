package BrainFuck.Instructions;
import BrainFuck.Instruction;
import BrainFuck.Memory;
import BrainFuck.Metrics;


import java.awt.Color;
import java.io.*;
import java.util.*;

/**
 * Created by Pierre on 16/11/2016.
 */
public class In extends Instruction {

    public static long timeAllIn;
    public static long timeOneIN;
    private static  BufferedReader fichierIn=null;
    private  Scanner sc = new Scanner(System.in);
    private  Scanner sc1 = new Scanner(System.in);

    public In(Memory memory){
        super(memory);
        courteSyntaxe=",";
        couleur=new Color(255, 255, 0);
    }

    public In(Memory memory, String fichier){
        this(memory);
        try{
            fichierIn = new BufferedReader(new FileReader(fichier));
        }
        catch(FileNotFoundException exc){
                System.out.println("Erreur d'ouverture");
        }
    }

    public void setFichier(String file){
        try{
            fichierIn = new BufferedReader(new FileReader(file));
        }
        catch(FileNotFoundException exc){

                System.out.println("Erreur d'ouverture");
                System.exit(3);
        }
    }

    public static BufferedReader getFichier(){
        return fichierIn;
    }

    public void closeFichier(){
        try{
            fichierIn.close();
        }
        catch(IOException e){

        }
    }
    
    public void execute(){
        int val;
        try{
            if(fichierIn!=null){

                val=fichierIn.read();
                if(val==-1) {
                    timeOneIN=System.currentTimeMillis();
                    val = sc.nextLine().charAt(0);
                    timeOneIN=System.currentTimeMillis()-timeOneIN;
                    timeAllIn+=timeOneIN;

                }
                memory.setMemory(val);
            }
            else{
                timeOneIN=System.currentTimeMillis();
                val = sc.nextLine().charAt(0);
                timeOneIN=System.currentTimeMillis()-timeOneIN;
                timeAllIn+=timeOneIN;
                memory.setMemory(val);
            }
        }
        catch(IOException e){
            System.out.println("Erreur fichier In");
        }
        Metrics.incrDataWrite();
        super.execute();
    }

    public int generateCode(int counter, FileWriter writer,Boolean finish,int loop) throws IOException {
        for(int i = 0;i<loop;i++){
            writer.write("    ");
        }
        writer.write("       if (fileIn == null || val = fileIn.read() == -1){\n" +
                    "           val = sc.nextLine().charAt(0);\n       }\n" +
                    "       tab[pointeur] = val;\n");
        return 0;
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }
}

