import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by Campo on 16/11/2016.
 */
public class Check {
    private int count = 0;
    private Map<Commandes,Computational> interprete = new HashMap<>();
    private Memory memory = new Memory();
    public Check() {
        this.count = count;
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

    public void check (String nameFile) throws IOException {
        if(nameFile.contains("BMP")||nameFile.contains("bmp")){
            checkImage(nameFile);
        }
        else{
            checkText(nameFile);
        }
    }

    public void checkText(String nameFile) throws IOException {
        BufferedReader lecteurAvecBuffer = null;
        String line;

        //On essaye de lire le fichier, si il n'y en a pas on renvoie une exception.
        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader(nameFile));
        } catch (FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
        }

        while ((line = lecteurAvecBuffer.readLine()) != null) {



                if(line.equals("JUMP")){
                   count ++;
                }        
                else if(line.equals("BACK")){
                    if(count==0){
                        System.exit(4);
                    }
                    count--;
                }
                else{
                    int size=line.length();
                    for(int i=0;i<size;i++) {
                        char c = line.charAt(i);
                        if(c=='[')
                            count++;
                        else if (c==']'){
                            if(count==0){
                                    System.exit(4);
                            }
                            count--;
                        }
                    }
            }
        }
    }


    public void checkImage(String picturefile) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(picturefile));
        BufferedImage image;
        image = ImageIO.read(is);
        int largeurImage = image.getWidth();
        int hauteurImage = image.getHeight();
        int x = 0;
        int y = 0;
        int couleur;
        while ((x < largeurImage) && (y < hauteurImage)) {
            couleur = image.getRGB(x, y);
            if (couleur == new Color(255, 127, 0).getRGB()) {
                count++;
            }
            else if (couleur == new Color(255, 0, 0).getRGB()) {
                count--;
                if(count < 0){
                    System.exit(4);
                }
            }
            else {
                break;
            }

            x += 3;
            if (x == largeurImage) {
                x = 0;
                y += 3;
            }

        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
