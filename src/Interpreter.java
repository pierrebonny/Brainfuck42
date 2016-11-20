import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */

public class Interpreter{
    private Memory memory;
    private Output output;
    private Map<Commandes,Computational> interprete = new HashMap<>();
    private Commandes commandes;
    private boolean boucle=false;

    public Interpreter(Output output,Memory memory){
        this.output=output;
        this.memory = memory;
        fillHashmap(interprete);
    }

    private void fillHashmap(Map<Commandes,Computational> hashmap) {
        interprete.put(Commandes.INCR,new Incr(memory));
        interprete.put(Commandes.DECR ,new Decr(memory));
        interprete.put(Commandes.LEFT,new Left(memory));
        interprete.put(Commandes.RIGHT,new Right(memory));
        interprete.put(Commandes.IN,new In(memory));
        interprete.put(Commandes.OUT,new Out(memory));
        interprete.put(Commandes.JUMP,new Jump(memory));
        interprete.put(Commandes.BACK,new Back(memory));
    }

    public void interprete(String line){
        boolean exec=false;
        for(Commandes com : Commandes.values()){
            if (com.getLongue().equals(line)){
            /*    if(boucle){

                }
                else{
                    if(interprete.get(line)==JUMP)
                        boucle=true;
            */        interprete.get(com).execute();
                        exec=true;
                }
        }          
            if(!exec) {
                int size=line.length();
                for(int i=0;i<size;i++) {
                    char c = line.charAt(i);
                    for (Commandes com : Commandes.values()){
                        if(com.getCourte()==c)
                        interprete.get(com).execute();
                    }
                }
            }
        
    }

    public void intertpreteImg(String  hexa){
        //System.out.println(hexa);
        for(Commandes com : Commandes.values())
            if(com.getHexa().equals(hexa))
                interprete.get(com).execute();
    }
    public void rewriteFile(String line) {
        boolean exe=false;
        for(Commandes com : Commandes.values()){

            if(com.getLongue().equals(line)){
                interprete.get(com).rewrite();
                exe=true;
            }
        }
        if(!exe)
            System.out.print(line);
    }

    public void rewriteImg(String hexa){
        //System.out.println(hexa);
        for(Commandes com: Commandes.values())
            if(com.getHexa().equals(hexa))
                interprete.get(com).rewrite();
    }


    public void setFichierIn(String file){
        interprete.get("IN").setFichier(file);
    }

    public void setFichierOut(String file){
        interprete.get("OUT").setFichier(file);
    }
}







