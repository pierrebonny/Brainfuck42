import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

 	public void read(String nameFile) throws IOException{
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
