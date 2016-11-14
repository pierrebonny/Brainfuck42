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
        int i=0;

        Memory memory = new Memory();
        Computational computational = new Computational(memory);
        Output output = new Output(memory);
        Interpreter interpreter = new Interpreter(computational);
        Reader reader=new Reader(interpreter,output);
        Translatetoimage translatetoimage = new Translatetoimage();
        Translatetointruct translatetointruct = new Translatetointruct();

        while(i!=nbArgs-1){
        	if(args[i].equals("--rewrite")){
                if (args[nbArgs -1].contains("BMP")||args[nbArgs -1].contains("bmp")){
                    translatetointruct.rewriteImage(args[nbArgs - 1]);
                }
                else{
                    reader.rewrite(args[nbArgs-1]);
                }

        	}
        	else if (args[i].equals("-translate")){

                    FileReader file = new FileReader(args[nbArgs-1]);
                    translatetoimage.translate(file);
                }
        	else if (args[i].equals("-p")){
                if (args[nbArgs -1].contains("BMP")||args[nbArgs -1].contains("bmp")){
                    interpreter.interpreteImage(args[nbArgs - 1]);
                }
                else {
                    reader.read(args[nbArgs-1]);
                }
                }
            i++;
        }       
    }       
}
