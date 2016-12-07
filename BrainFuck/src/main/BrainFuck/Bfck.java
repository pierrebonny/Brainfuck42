package BrainFuck;

import BrainFuck.Exception.CheckException;
import BrainFuck.Exception.OutofBoundException;
import BrainFuck.Exception.OverFlowException;
import BrainFuck.Exception.UnderFlowException;

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


        Metrics.setExecTime(System.currentTimeMillis());


        //Initialisation des objets des autres classes

        int nbArgs = args.length;
        int i = 0;

        Memory memory = new Memory();

        Output output = new Output(memory);
        Interpreter interpreter = new Interpreter(output, memory);
        Trace trace=new Trace(memory);
        BFReader reader = new BFReader(interpreter);
        Check check = new Check(reader);
        Translatetoimage translatetoimage = new Translatetoimage();



        //La méthode check va etre la seule méthode qui va lire le programme (image ou fichier texte) elle va enregistré égalemen

        try{
            check.check(args[nbArgs - 1]);
        }catch(CheckException e){
            e.erreur();
        }

            while (i != nbArgs - 1) {
                if(args[i].equals("--trace")){
                    trace.setFile(args[nbArgs-1]);
                }
                if (args[i].equals("--check")) {
                    System.exit(0);
                }
                if (args[i].equals("--rewrite")) {
                    interpreter.rewrite();
                    System.exit(0);

                } else if (args[i].equals("--translate")) {
                    translatetoimage.translate();
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

            try {
                interpreter.interprete();
            }
            catch(OutofBoundException e){e.erreur();}
            catch(OverFlowException e){e.erreur();}
            catch(UnderFlowException e){e.erreur();}

    }

}






