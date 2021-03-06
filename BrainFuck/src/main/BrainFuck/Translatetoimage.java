package BrainFuck;


import sun.dc.pr.PRError;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


public class Translatetoimage {

	private static final int L = 3;
	private static final int l = 3;


	public void translate(String namefile) throws IOException {
		String namef;
		ArrayList<Instruction> programm = this.createListeOfInstructions();
		int taille = programm.size();
		BufferedImage buffImg;
		if (taille != 0) {
			int x = 0;
			int y = 0;
			int n = (int) (3.0 * Math.ceil(Math.sqrt(taille)));
			buffImg = new BufferedImage(n, n, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = (Graphics2D) buffImg.getGraphics();
			for (int i = 0; i < taille; i++) {
				g2d.setColor(programm.get(i).translate());
				g2d.fillRect(x, y, l, L);
				x += 3;
				if (x == n) {
					x = 0;
					y += 3;
				}
			}
			g2d.dispose();
		} else {
			buffImg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		}
		namef = namefile.split("\\.")[0];
		ImageIO.write(buffImg, "bmp", new File(namef +".bmp"));
	}

	public ArrayList<Instruction> createListeOfInstructions() {
		ArrayList<Instruction> programmInstructions = new ArrayList<>();
		for (int i = Procedure.nbreTotalInstructionsProcedures; i < Computational.getProgramm().size(); i++) {
			if (Computational.getProgramm().get(i) instanceof Instruction){
				programmInstructions.add((Instruction) Computational.getProgramm().get(i));
			}
			if (Computational.getProgramm().get(i) instanceof Procedure) {
				System.out.println("procedure");
				for (int j = ((Procedure) Computational.getProgramm().get(i)).positionDebListeProg; j <= ((Procedure) Computational.getProgramm().get(i)).positionFinListeProg; j++) {
					programmInstructions.add((Instruction) Computational.getProgramm().get(j));
				}
			}
		}
		return programmInstructions;
	}
}

