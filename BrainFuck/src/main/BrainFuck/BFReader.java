package BrainFuck;
import BrainFuck.Instructions.In;
import BrainFuck.Instructions.Out;


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

public class BFReader {
	private Interpreter interpreter;

	public BFReader(Interpreter interpreter){
		this.interpreter=interpreter;
	}

    public void read(String nameFile) throws IOException{
        if ((nameFile.contains(".BMP"))||(nameFile.contains(".bmp"))){
            readImage(nameFile);
        }
        else {
            readFile(nameFile);
        }

        if(In.getFichier()!=null)
            new In(interpreter.memory).closeFichier();

        if(Out.getFichier()!=null)
            new Out(interpreter.memory).closeFichier();
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
                for (Commandes com : Commandes.values()){
                    if(com.getHexa().equals(hexa)) {
                        Instruction.getProgramm().add(interpreter.interprete.get(com));
                    }
                }
                x += 3;
                if (x == largeurImage) {
                    x = 0;
                    y += 3;
                }
            }
	}


	public void readFile(String nameFile) throws IOException {
        BufferedReader lecteurAvecBuffer = null;
        String line;

        //On essaye de lire le fichier, si il n'y en a pas on renvoie une exception.
        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader(nameFile));
        } catch (FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
        }
        //On le lit le fichier ligne par ligne jusqu'a ce qu'il soit vide
        while ((line = lecteurAvecBuffer.readLine()) != null ) {
            if (line.equals("")) {
                continue;
            } else if (line.charAt(0) == '@') {
                interpreter.createMacro(line);

            } else if (line.charAt(0) == '$'){
                interpreter.createProcedure(line);

            }else {
                interpreter.saveInstructions(line);
            }

        }
            lecteurAvecBuffer.close();

    }


	public void readAndExecute(String fileName) throws IOException{
        this.read(fileName);
        interpreter.interprete();
    }

	public void rewrite(String file) throws IOException{

        if ((file.contains(".BMP"))||(file.contains(".bmp"))){
        	readImage(file);
        }
        else {
            readFile(file);
            }
        interpreter.rewrite();
        }	


}

