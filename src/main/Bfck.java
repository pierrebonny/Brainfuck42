


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


        Computational.setExecTime(System.currentTimeMillis());


        //Initialisation des objets des autres classes

        int nbArgs = args.length;
        int i = 0;

        Memory memory = new Memory();
        Check check = new Check();
        Output output = new Output(memory);
        Interpreter interpreter = new Interpreter(output, memory);

        Reader reader = new Reader(interpreter, output);
        Translatetoimage translatetoimage = new Translatetoimage();




            check.check(args[nbArgs - 1]);
            if (check.getCount() != 0) {
                System.exit(4);
            }

            while (i != nbArgs - 1) {
                if(args[i].equals("--trace")){
                    String file=args[nbArgs-1];
                    int position=file.lastIndexOf('.');
                    file=file.substring(0,position)+".log";
                    Computational.setFile(file);
                    Computational.createFichierLog(file);
                }

                if (args[i].equals("--check")) {
                    System.exit(0);
                }
                if (args[i].equals("--rewrite")) {
                    reader.rewrite(args[nbArgs - 1]);
                    System.exit(0);

                } else if (args[i].equals("--translate")) {
                    translatetoimage.translate(args[nbArgs - 1]);
                    System.exit(0);
                } else if (args[i].equals("-i")) {
                    i++;
                    interpreter.setFichierIn(args[i]);
                } else if (args[i].equals("-o")) {
                    i++;
                    interpreter.setFichierOut(args[i]);
                }

                i++;
            }
            reader.read(args[nbArgs - 1]);



        output.metrics();

    }

}






