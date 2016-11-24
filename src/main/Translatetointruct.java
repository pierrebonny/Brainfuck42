import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 09/11/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 */
public class Translatetointruct {
    /* this methode takes the input filename into argument and using an InputStream it creates a bufferedimage which
       contains the input picture information and which will be used to print the good information
     */
    public static void rewriteImage(String picturefile) throws IOException{
        InputStream is = new BufferedInputStream(new FileInputStream(picturefile));
        BufferedImage image;
        image = ImageIO.read(is);	
        int largeurImage = image.getWidth();
        int hauteurImage = image.getHeight();
        int x = 0;
        int y = 0;
        int couleur;
        while((x < largeurImage) &&(y < hauteurImage)){		
                couleur = image.getRGB(x, y);
           if (couleur == Color.white.getRGB()){
               System.out.println("+");
            }
            else if (couleur == new Color(75, 0, 130).getRGB()){
               System.out.println("-");
           }
           else if (couleur == new Color(0, 0, 255).getRGB()){
               System.out.println("-");
           }
           else if (couleur == new Color(148, 0, 211).getRGB()){
               System.out.println(">");
           }
           else if (couleur == new Color(0, 255, 0).getRGB()){
               System.out.println(".");
           }
           else if (couleur == new Color(255, 255, 0).getRGB()){
               System.out.println(",");
           }
           else if (couleur == new Color(255, 127, 0).getRGB()){
               System.out.println("[");
           }
           else if (couleur == new Color(255, 0, 0).getRGB()){
               System.out.println("]");
           }
           else {
               break;
           }

            x +=3;
            if (x == largeurImage){
                x = 0;
                y += 3;
            }

        }

    }


}


