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
    private Computational computational;
    private Back loops ;
    private Output output;
    private Commandes incr = Commandes.INCR;
    private Commandes decr = Commandes.DECR;
    private Commandes left = Commandes.LEFT;
    private Commandes right = Commandes.RIGHT;
    private Commandes in = Commandes.IN;
    private Commandes out = Commandes.OUT;
    //private Commandes jump = Commandes.JUMP;
    //private Commandes back = Commandes.Back;

    public Interpreter(Computational computational,Back loops, Output output,Memory memory){
        this.computational=computational;
        this.loops=loops;
        this.output=output;
        this.memory = memory;
    }
    private Map<Commandes,Computational> interprete = new HashMap<>();
    public void fillHashmap(Map<Commandes,Computational> hashmap) {
        interprete.put(incr,new Incr(memory));
        interprete.put(decr ,new Decr(memory));
        interprete.put(left,new Left(memory));
        interprete.put(right,new Right(memory));
        interprete.put(in,new In(memory));
        interprete.put(out,new Out(memory));
        //interprete.put(jump,new Jump(memory));
        //interprete.put(back,new Back(memory));
    }

    public void interprete(String line,BufferedReader fichierIn,BufferedWriter fichierOut) throws IOException{
        fillHashmap(interprete);
        if (interprete.get(line) != null){
            interprete.get(line).execute();
        }
        else {
            int size=line.length();
            for(int i=0;i<size;i++) {
                char c = line.charAt(i);
                interprete.get(c).execute();
            }
        }
    }

    public void intertpreteImg(String picturefile, String fichierIn,String fichierOut) throws IOException{

    }

}







