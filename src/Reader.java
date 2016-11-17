
import javax.imageio.ImageIO;
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
		/*if (nameFile.contains("BMP")||nameFile.contains("bmp")){
			InputStream is = new BufferedInputStream(new FileInputStream(nameFile));
			BufferedImage image;
			image = ImageIO.read(is);
			int largeurImage = image.getWidth();
			int hauteurImage = image.getHeight();
			int x = 0;
			int y = 0;
			int couleur;
			BufferedReader bufferFichierIn = null;
			BufferedWriter bufferFichierOut = null;
			//interpreter.interpreteImg(nameFile,bufferFichierIn,bufferFichierOut);
		}*/
		//On le lit le fichier ligne par ligne jusqu'a ce qu'il soit vide
		while ((line = lecteurAvecBuffer.readLine()) != null) {
			interpreter.interprete(line,bufferFichierIn,bufferFichierOut);
		}
		if(bufferFichierIn!=null)
			bufferFichierIn.close();
		if(bufferFichierOut!=null)
			bufferFichierOut.close();
		output.afficher();
		lecteurAvecBuffer.close();

	}

	/*
	readcheck c'est la même chose que read, sauf qu'il n'y a pas le output afficher 
	 */
	public void readcheck(String nameFile, String fichierIn, String fichierOut) throws IOException{
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

		//On le lit le fichier ligne par ligne jusqu'a ce qu'il soit vide
		while ((line = lecteurAvecBuffer.readLine()) != null) {
			interpreter.interprete(line,bufferFichierIn,bufferFichierOut);
		}
		if(bufferFichierIn!=null)
			bufferFichierIn.close();
		if(bufferFichierOut!=null)
			bufferFichierOut.close();
		lecteurAvecBuffer.close();

	}

	public static void rewrite(String file) throws IOException{
		BufferedReader buffer=null;
		try{
			buffer = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException exc){
			System.out.println("Erreur d'ouverture");
		}
		String ligne;
		while ((ligne = buffer.readLine()) != null) {
			switch (ligne){
				case "INCR":
					System.out.print("+");
					break;
				case "DECR":
					System.out.print("-");
					break;
				case "RIGHT":
					System.out.print(">");
					break;
				case "LEFT":
					System.out.print("<");
					break;
				default:
					System.out.print(ligne);
					break;
			}
			//System.out.println();
		}
		System.out.println();
	}
}