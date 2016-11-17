/**
 * Created by Campo on 16/11/2016.
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by Campo on 16/11/2016.
 */
public class Check {
    private int count = 0;

    public Check() {
        this.count = count;
    }

    public void read (String nameFile) throws IOException {
        if(nameFile.contains("BMP")||nameFile.contains("bmp")){
            readImage(nameFile);
        }
        else{
            readText(nameFile);
        }
    }

    public void readText(String nameFile) throws IOException {
        BufferedReader lecteurAvecBuffer = null;
        String line;

        //On essaye de lire le fichier, si il n'y en a pas on renvoie une exception.
        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader(nameFile));
        } catch (FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
        }

        while ((line = lecteurAvecBuffer.readLine()) != null) {
            switch (line) {
                case "JUMP" :
                    count++;
                    break;
                case"BACK" :
                    if(count==0){
                        System.exit(4);
                    }
                    count--;
                    break;

                default:
                    int size=line.length();
                    for(int i=0;i<size;i++){
                        char c=line.charAt(i);
                        switch (c){
                            case '[':
                                count++;
                                break;
                            case ']':
                                if(count==0){
                                    System.exit(4);
                                }
                                count--;
                                break;
                            default :
                                break;
                        }
                    }
            }

        }
    }


    public void readImage(String picturefile) throws IOException {
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