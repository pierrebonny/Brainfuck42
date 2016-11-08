import java.io.FileReader;
import java.io.IOException;


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
        int nbArgs=args.length;


        Memory memory = new Memory();
        Computational computational = new Computational(memory);
        Output output = new Output(memory);
        Interpreter interpreter = new Interpreter(computational);
        Reader reader=new Reader(interpreter,output);

	if(args[0].equals("--rewrite")){
		reader.rewrite(args[nbArgs-1]);
	}
	else if (args[0].equals("-translate")){
            Picture picture = new Picture();
            FileReader file = new FileReader(args[nbArgs-1]);
            picture.translate(file);
        }
	else{    
        reader.read(args[nbArgs-1]);
        }
        
        
    }
        
}
