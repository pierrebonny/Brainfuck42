package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise la lecture du fichier BrainFuck
 */

public class Reader {
	private Interpreter interpreter;
	private Output output;

	public Reader(Interpreter interpreter,Output output){
		this.interpreter=interpreter;
		this.output=output;
	}

	public void read(String nameFile) throws IOException{
        if ((nameFile.contains("BMP"))||(nameFile.contains("bmp"))){
        	readImage(nameFile);
        }
        else {
        	readFile(nameFile);
		}

	}

	public void readImage(String nameFile) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(nameFile));
        BufferedImage image;
        image = ImageIO.read(is);
        int largeurImage = image.getWidth();
        int hauteurImage = image.getHeight();
        int x = 0;
        int y = 0;
        int couleur;
        String hexa;
            while((x < largeurImage) &&(y < hauteurImage)) {
                couleur = image.getRGB(x, y);
                hexa =String.format("%06X", couleur);
                interpreter.intertpreteImg(hexa);
                x += 3;
                if (x == largeurImage) {
                    x = 0;
                    y += 3;
                }
            }
            output.afficher();
	}

	public void readFile(String nameFile) throws IOException{
		BufferedReader lecteurAvecBuffer = null;
		String line;

		//On essaye de lire le fichier, si il n'y en a pas on renvoie une exception.
		try{
			lecteurAvecBuffer = new BufferedReader(new FileReader(nameFile));
		}
		catch(FileNotFoundException exc){
			System.out.println("Erreur d'ouverture");
		}
					//On le lit le fichier ligne par ligne jusqu'a ce qu'il soit vide
			while ((line = lecteurAvecBuffer.readLine()) != null) {
				interpreter.interprete(line);
			}
			output.afficher();
			lecteurAvecBuffer.close();
	}

	public void rewrite(String file) throws IOException{

        if ((file.contains("BMP"))||(file.contains("bmp"))){
        	rewriteImage(file);
        }
        else {
            rewriteFile(file);
            }
        }	

	public void rewriteImage(String file) throws IOException{
		    InputStream is = new BufferedInputStream(new FileInputStream(file));
            BufferedImage image;
            image = ImageIO.read(is);
            int largeurImage = image.getWidth();
            int hauteurImage = image.getHeight();
            int x = 0;
            int y = 0;
            int couleur;
            String hexa;
            while((x < largeurImage) &&(y < hauteurImage)) {
                couleur = image.getRGB(x, y);
                hexa = String.format("%06X", couleur);
                interpreter.rewriteImg(hexa);
                x += 3;
                if (x == largeurImage) {
                    x = 0;
                    y += 3;
                }
            }
	}

	public void rewriteFile(String file) throws IOException{
		BufferedReader lecteurAvecBuffer=null;
		try{
			lecteurAvecBuffer = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException exc){
			System.out.println("Erreur d'ouverture");
		}
		String ligne;
        while ((ligne = lecteurAvecBuffer.readLine()) != null) {
            interpreter.rewriteFile(ligne);
		}

	}
}