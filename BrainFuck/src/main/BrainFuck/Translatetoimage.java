package BrainFuck;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Translatetoimage {
    
    private static final int L = 3;
    private static final int l = 3;


    public void translate() throws IOException {
    	int taille = Computational.getProgramm().size();
    	int x = 0;
    	int y = 0;
    	int n = (int) (3.0 * Math.ceil(Math.sqrt(taille)));
    	BufferedImage buffImg = new BufferedImage(n,n,BufferedImage.TYPE_INT_RGB);
    	Graphics2D g2d = (Graphics2D)buffImg.getGraphics();
    	for (int i = 0; i < taille;i++){
    	    g2d.setColor(Computational.getProgramm().get(i).translate());
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

