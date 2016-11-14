import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */

public class Interpreter{
	private Computational computational;


	public Interpreter(Computational computational){
		this.computational=computational;
	}

	public void interprete(String line){
            switch (line) {
                case "INCR":
                    computational.incr();
                    break;

                case "DECR":
                    computational.decr();
                    break;

                case "RIGHT":
                    computational.right();
                    break;

                case "LEFT":
                    computational.left();
                    break;

                case "IN":
                    computational.in();
                    break;

                case "OUT":
                    computational.out();
                    break;

                default:{
                	int size=line.length();
                	for(int i=0;i<size;i++){
                		char c=line.charAt(i);
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
                            case ',':
                                computational.in();
                                break;
                            case'.':
                                computational.out();
                                break;
                			default :
                				break;
                		}
                	}
                	break;
               }
            }
	}
    public void interpreteImage(String picturefile) throws IOException {
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
                computational.in();
            }
            else if (couleur == new Color(255, 255, 0).getRGB()){
                computational.out();
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
    }
	
}
