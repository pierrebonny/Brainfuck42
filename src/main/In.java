


import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Pierre on 16/11/2016.
 */
public class In extends Computational{


    private static  BufferedReader fichierIn=null;
    private  Scanner sc = new Scanner(System.in);

    public In(Memory memory){
        super(memory);
        courteSyntaxe=",";
        couleur=new Color(255, 255, 0);
    }

    public In(Memory memory, String fichier){
        super(memory);
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
                if(val==-1){
                    System.out.println("Please enter any value : ");
                    val=sc.nextLine().charAt(0);
                }
                memory.setMemory(val);
            }
            else{
                System.out.println("Please enter any value : ");
                val=sc.nextLine().charAt(0);
                memory.setMemory(val);
            }
        }
        catch(IOException e){
            System.out.println("Erreur fichier In");
        }
        Computational.incrDataWrite();
        super.execute();
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public void Check(){}

}

