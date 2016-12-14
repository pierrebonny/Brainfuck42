package BrainFuck;


import sun.dc.pr.PRError;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;


public class Translatetoimage {
    
    private static final int L = 3;
    private static final int l = 3;



    public void translate() throws IOException {
		/*
		int s=0;
		Set<String> keys=Interpreter.procedures.keySet();
		for(String nameProcedure :keys){
			s+=Interpreter.procedures.get(nameProcedure).nbreInstrInProg();
		}
		s=s- Procedure.nbreTotalProcUtilise;
    	int taille = Computational.getProgramm().size()+s-Procedure.nbreTotalInstructionsProcedures;
    	*/
		int taille = Computational.getProgramm().size();
    	int x = 0;
    	int y = 0;
    	int n = (int) (3.0 * Math.ceil(Math.sqrt(taille)));
    	BufferedImage buffImg = new BufferedImage(n,n,BufferedImage.TYPE_INT_RGB);
    	Graphics2D g2d = (Graphics2D)buffImg.getGraphics();
    	for (int i = 0; i < taille;i++){

			//int j = Procedure.nbreTotalInstructionsProcedures;
			//Computational.getProgramm().get(j);
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

