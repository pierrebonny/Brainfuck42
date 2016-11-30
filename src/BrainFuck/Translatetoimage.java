package BrainFuck;
import BrainFuck.Instructions.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Translatetoimage {
    
    private static final int L = 3;
    private static final int l = 3;    
    private List <Color> colors = new ArrayList <Color>();
    private Map<Commandes,Computational> interprete = new HashMap<>();
    private Memory memory;
    private Commandes commandes;
    private Reader reader;

    public Translatetoimage(Memory memory, Reader reader){
    	fillHashmap(interprete);
        this.memory=memory;
        this.reader=reader;
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

    public void translate(String file) throws IOException {

        reader.readFile(file);

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

