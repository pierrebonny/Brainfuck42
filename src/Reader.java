
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Array;

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

	public void read(String nameFile, String fichierIn, String fichierOut) throws IOException{
		BufferedReader lecteurAvecBuffer = null;
		BufferedReader bufferFichierIn = null;
		BufferedWriter bufferFichierOut = null;
		String line;

		//On essaye de lire le fichier, si il n'y en a pas on renvoie une exception.
		try{
			lecteurAvecBuffer = new BufferedReader(new FileReader(nameFile));
		}
		catch(FileNotFoundException exc){
			System.out.println("Erreur d'ouverture");
		}

		if(fichierIn!=null){
			try{
				bufferFichierIn = new BufferedReader(new FileReader(fichierIn));
			}
			catch(FileNotFoundException exc){
				System.out.println("Erreur d'ouverture");
			}
		}

		if(fichierOut!=null){
			try{
				bufferFichierOut = new BufferedWriter(new FileWriter(fichierOut));
			}
			catch(FileNotFoundException exc){
				System.out.println("Erreur d'ouverture");
			}
		}
        if ((nameFile.contains("BMP"))||(nameFile.contains("bmp"))){
            InputStream is = new BufferedInputStream(new FileInputStream(nameFile));
            BufferedImage image;
            image = ImageIO.read(is);
            int largeurImage = image.getWidth();
            int hauteurImage = image.getHeight();
            int x = 0;
            int y = 0;
            Color couleur;
            while((x < largeurImage) &&(y < hauteurImage)) {
                couleur = new Color(image.getRGB(x, y));
                interpreter.intertpreteImg(couleur);
                x += 3;
                if (x == largeurImage) {
                    x = 0;
                    y += 3;
                }
            }
        }
		//On le lit le fichier ligne par ligne jusqu'a ce qu'il soit vide
		while ((line = lecteurAvecBuffer.readLine()) != null) {
			interpreter.interprete(line);
		}
		if(bufferFichierIn!=null)
			bufferFichierIn.close();
		if(bufferFichierOut!=null)
			bufferFichierOut.close();
		output.afficher();
		lecteurAvecBuffer.close();

	}

	public void rewrite(String file) throws IOException{
		BufferedReader lecteurAvecBuffer=null;
		try{
			lecteurAvecBuffer = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException exc){
			System.out.println("Erreur d'ouverture");
		}
        if ((file.contains("BMP"))||(file.contains("bmp"))){
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            BufferedImage image;
            image = ImageIO.read(is);
            int largeurImage = image.getWidth();
            int hauteurImage = image.getHeight();
            int x = 0;
            int y = 0;
            Color couleur;
            while((x < largeurImage) &&(y < hauteurImage)) {
                couleur = new Color(image.getRGB(x, y));
                interpreter.rewriteImg(couleur);
                x += 3;
                if (x == largeurImage) {
                    x = 0;
                    y += 3;
                }
            }
        }
		String ligne;
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
            interpreter.rewrite(ligne);
        }
	}
}