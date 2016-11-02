import java.io.FileReader;
import java.io.IOException;

import Brainclass.Picture;


/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Classe excecutable.
 */

public class Bfck {

    public static void main(String[] args) throws IOException {
        
        //Initialisation des objets des autres classes
        


        Memory memory = new Memory();
        Computational computational = new Computational(memory);
        Output output = new Output(memory);
        Interpreter interpreter = new Interpreter(computational);
        Reader reader=new Reader(interpreter,output);
	if(args[1].equals("--rewrite")){
		reader.rewrite(args[0]);
	}
	else if (args[1].equals("-translate")){
            Picture picture = new Picture();
            FileReader file = new FileReader(args[0]);
            picture.translate(file);
        }
	else{    
        reader.read(args[0]);
        }
        
        
    }
        
}
