import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Pierre on 16/11/2016.
 */
public class In implements Computational {

    private Memory memory;
    private String courteSyntaxe=",";
    private Color couleur=new Color(255, 255, 0);
    private BufferedReader fichierIn=null;
    private  Scanner sc = new Scanner(System.in);

    public In(Memory memory){
        this.memory = memory;
    }

    public In(Memory memory, String fichier){
        this.memory = memory;
        try{
            fichierIn = new BufferedReader(new FileReader(fichier));
        }
        catch(FileNotFoundException exc){
                System.out.println("Erreur d'ouverture");
        }
    }

    public void execute(){
        int val;
        try{
            if(fichierIn!=null){
                val=fichierIn.read();
                if(val==-1)
                    val=sc.nextLine().charAt(0);
                memory.setMemory(val);
            }
            else{
                val=sc.nextLine().charAt(0);
                memory.setMemory(val);
            }
        }
        catch(IOException e){
            System.out.println("Erreur fichier In");
        }
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public void Check(){}

}
