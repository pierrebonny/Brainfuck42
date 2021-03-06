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
        boolean execute=false;


        //La méthode check va etre la seule méthode qui va lire le programme (image ou fichier texte) elle va enregistrer égalemen

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
                    translatetoimage.translate(args[nbArgs - 1]);
                    System.exit(0);
                } else if (args[i].equals("-i")) {
                    i++;
                    interpreter.setFichierIn(args[i]);
                } else if (args[i].equals("-o")) {
                    i++;
                    interpreter.setFichierOut(args[i]);
                }else if(args[i].equals("-p")){
                    execute=true;
                }else if(args[i].equals("--generateJava")){
                    GenerateCode generateur= new GenerateCode(reader);
                    generateur.generateCode(args[nbArgs-1]);
                }

                i++;
            }

            if(execute) {
                try {
                    interpreter.interprete();
                } catch (OutofBoundException e) {
                    Trace t = new Trace(memory);
                    t.updateFichierLogException(e.getMessage());
                    t.trace();
                    e.erreur();
                } catch (OverFlowException e) {
                    Trace t = new Trace(memory);
                    t.updateFichierLogException(e.getMessage());
                    t.trace();
                    e.erreur();
                } catch (UnderFlowException e) {
                    Trace t = new Trace(memory);
                    t.updateFichierLogException(e.getMessage());
                    t.trace();
                    e.erreur();
                }
            }

    }

}






