package BrainFuck.Instructions;
import BrainFuck.Instruction;
import BrainFuck.Memory;
import BrainFuck.Metrics;


import java.awt.Color;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by Pierre on 16/11/2016.
 */

/**
 * Created by Pierre on 16/11/2016.
 */
public class Out extends Instruction {

    protected static BufferedWriter fichierOut=null;
    public String fichierOu;

    public Out(Memory memory){
        super(memory);
        courteSyntaxe=".";
        couleur=new Color(0, 255, 0);
    }

    public Out(Memory memory, String fichier){
        //fichierOu=fichier;
        this(memory);
        try{
            fichierOut = new BufferedWriter(new FileWriter(fichier));
        }
        catch(FileNotFoundException exc){
            System.out.println("Erreur d'ouverture");
        }
        catch(IOException e){
            System.out.println("Erreur d'ouverture");
        }
    }

    public void setFichier(String file){
        //System.out.println("Creation du fichier");
        try{
            fichierOut = new BufferedWriter(new FileWriter(file));
        }
        catch(FileNotFoundException exc){
            System.out.println("Erreur d'ouverture");
        }
        catch(IOException e){
            System.out.println("Erreur d'ouverture");
            System.exit(3);
        }
    }

    public static BufferedWriter getFichier(){
        return fichierOut;
    }

    public void closeFichier(){
        //System.out.println("Fermeture du fichier");
        try{
            fichierOut.close();
        }
        catch(IOException e){

        }

    }

    public void execute(){
        try{
            if(fichierOut!=null){
                fichierOut.write(String.valueOf(memory));
            }
            else{
                System.out.print(memory);
            }
        }
        catch(IOException e){
            System.out.println("Erreur fichier Out");
        }
        Metrics.incrDataRead();
        super.execute();
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public int generateCode(int counter,FileWriter writer,Boolean finish,int loop) throws IOException {
        for(int i = 0;i<loop;i++){
            writer.write("    ");
        }
        writer.write("       if (fileOut == null){\n" +
                    "           System.out.print((char)tab[pointeur]);\n       }\n" +
                    "       else{\n           fileOut.write((char)tab[pointeur]);\n       }\n");
        return 0;
    }


}

