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
/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */

public class Interpretereta{
    private Computationaleta computational;
    private Back loops ;
    private Output output;

    public Interpretereta(Computationaleta computational,Back loops, Output output){
        this.computational=computational;
        this.loops=loops;
        this.output=output;
    }

    public void interprete(String line,BufferedReader fichierIn,BufferedWriter fichierOut) throws IOException{
        switch (line) {
            case "INCR":{
                if(loops.getStock())
                    loops.getInstructions().add('+');
                if(loops.getRead())
                    computational.incr();
            }
            break;

            case "DECR":{
                if(loops.getStock())
                    loops.getInstructions().add('-');
                if(loops.getRead())
                    computational.decr();
            }
            break;

            case "RIGHT":{
                if(loops.getStock())
                    loops.getInstructions().add('>');
                if (loops.getRead())
                    computational.right();
            }
            break;

            case "LEFT":{
                if(loops.getStock())
                    loops.getInstructions().add('<');
                if(loops.getRead())
                    computational.left();
            }
            break;
            case "IN":{
                if(loops.getStock())
                    loops.getInstructions().add(',');
                if(loops.getRead())
                    computational.in(fichierIn);
            }
            break;
            case "OUT":{
                if(loops.getStock())
                    loops.getInstructions().add('.');
                if(loops.getRead())
                    computational.out(fichierOut);
            }
            break;
            case "JUMP":{
                if(loops.getRead())
                    loops.getJump().jump();
                if(loops.getStock())
                    loops.getInstructions().add('[');
            }
            break;
            case "loops":{
                if(loops.getStock())
                    loops.getInstructions().add(']');
                if(loops.jumpAssociated(loops.getInstructions().size()-1)==0)
                    loops.back();
            }
            break;
            default:{
                int size=line.length();
                for(int i=0;i<size;i++){
                    char c=line.charAt(i);
                    if(loops.getRead()){
                        switch (c){
                            case '+':
                                computational.incr();
                                break;
                            case '-':
                                computational.decr();
                                break;
                            case '<':
                                computational.left();
                                break;
                            case '>':
                                computational.right();
                                break;
                            case '.':
                                computational.out(fichierOut);
                                break;
                            case ',':
                                computational.in(fichierIn);
                                break;
                            case '[':
                                loops.getJump().jump();
                                break;
                            default :
                                break;
                        }
                    }
                    if(loops.getStock())
                        loops.getInstructions().add(c);
                    if(c==']' && loops.getJump().jumpAssociated(loops.getInstructions().size()-1)==0){
                        loops.back(loops.getInstructions().size()-1);
                    }

                }
            }
            break;
        }
    }



    public void interpreteImage(String picturefile, String fichierIn,String fichierOut) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(picturefile));
        BufferedImage image;
        image = ImageIO.read(is);
        int largeurImage = image.getWidth();
        int hauteurImage = image.getHeight();
        int x = 0;
        int y = 0;
        int couleur;
        BufferedReader bufferFichierIn = null;
        BufferedWriter bufferFichierOut = null;
        if(fichierIn!=null){
            try{
                bufferFichierIn = new BufferedReader(new FileReader(fichierIn));
            }
            catch(FileNotFoundException exc){
                System.out.println("Erreur d'ouverture");
            }
        }

        if(fichierOut!=null){
            try{
                bufferFichierOut = new BufferedWriter(new FileWriter(fichierOut));
            }
            catch(FileNotFoundException exc){
                System.out.println("Erreur d'ouverture");
            }
        }

        while((x < largeurImage) &&(y < hauteurImage)){
            couleur = image.getRGB(x, y);
            if (couleur == Color.white.getRGB()){
                computational.incr();
            }
            else if (couleur == new Color(75, 0, 130).getRGB()){
                computational.decr();
            }
            else if (couleur == new Color(0, 0, 255).getRGB()){
                computational.left();
            }
            else if (couleur == new Color(148, 0, 211).getRGB()){
                computational.right();
            }
            else if (couleur == new Color(0, 255, 0).getRGB()){
                computational.in(bufferFichierIn);
            }
            else if (couleur == new Color(255, 255, 0).getRGB()){
                computational.out(bufferFichierOut);
            }
            /*else if (couleur == new Color(255, 127, 0).getRGB()){ // A ajouter quand on gèrera les boucles
                computational.jump();
            }
            else if (couleur == new Color(255, 0, 0).getRGB()){
                computational.back();
            }*/
            else {
                break;
            }

            x +=3;
            if (x == largeurImage){
                x = 0;
                y += 3;
            }


        }
        if(bufferFichierIn!=null)
            bufferFichierIn.close();
        if(bufferFichierOut!=null)
            bufferFichierOut.close();

        output.afficher();
    }



}
