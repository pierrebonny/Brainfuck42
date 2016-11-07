import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Picture {
    
    private static final int L = 3;
    private static final int l = 3;    
    private List <Color> colors = new ArrayList <Color>();
    public void translate(FileReader file) throws IOException {
	
	BufferedReader buff = new BufferedReader(file);
			
	
	String ligne;
                
    	while ((ligne = buff.readLine()) != null) {

            switch (ligne) {
            
                case "INCR":
                    colors.add(Color.white);
                    break;

                case "DECR":                    
                    colors.add(new Color(75,0,130));
                    break;

                case "RIGHT":
                    colors.add(new Color(0,0,255));
                    break;

                case "LEFT":
                    colors.add(new Color(148,0,211));
                    break;
                case "OUT":
                    colors.add(new Color(0,255,0));
                    break;
                case "IN":
                    colors.add(new Color(255,255,0));
                    break;
                case "JUMP":
                    colors.add(new Color(255,127,0));
                    break;
                case "BACK":
                    colors.add(new Color(255,0,0));
                    break;
                default:{
                    int size=ligne.length();
                    for(int a=0;a<size;a++){
                    	char c=ligne.charAt(a);
                    	switch (c){
                    		case '+':
                    		    colors.add(Color.white);
                    		    break;
                    		case '-':
                    		    colors.add(new Color(75,0,130));
                    		    break;
                    		case '<':
                    		    colors.add(new Color(0,0,255));
                    		    break;
                    		case '>':
                    		    colors.add(new Color(148,0,211));
                    		    break;
                    		case '.':
                    		    colors.add(new Color(0,255,0));
                    		    break;
                    		case ',':
                    		    colors.add(new Color(255,255,0));
                    		    break;
                    		case '[':
                    		    colors.add(new Color(255,127,0));
                    		    break;
                    		case ']':
                    		    colors.add(new Color(255,0,0));
                    		    break;
                    		default :
                    		    break;
                    		}
                    	}
                    	break;
                   }
                
                    
            }
            
        }
            
    	
    	int taille = colors.size();
    	int x = 0;
    	int y = 0;
    	int n = (int) (3.0 * Math.ceil(Math.sqrt(taille)));
    	BufferedImage buffImg = new BufferedImage(n,n,BufferedImage.TYPE_INT_RGB);
    	Graphics2D g2d = (Graphics2D)buffImg.getGraphics();
    	for (int i = 0; i < taille;i++){
    	    g2d.setColor(colors.get(i));    	    
    	    g2d.fillRect(x, y, l, L);
    	    x += 3;
    	    if (x == n){
    		x = 0;
    		y += 3;
    	    }
    	
    	}
    	g2d.dispose();
    	ImageIO.write(buffImg, "bmp", new File("testimg.bmp"));
    }    	
}    
