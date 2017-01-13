package BrainFuck;


import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 12/12/2016.
 *
 */

public class Procedure extends Methode{

    //Nombre total d'instructions DEFINISANT  toutes les procédures  : variable servant à initialiser le pointeur d'execution lors de l'execution de la liste d'intruction du programme
    public static int nbreTotalInstructionsProcedures;


    public Procedure(Memory memory,int nbRepetition,String chaine,String name){
        super(memory,nbRepetition,chaine,name);
    }


    public Procedure(Memory memory,Procedure procedure,int pointeurMémoire,String name){
        super(memory,procedure,pointeurMémoire,name);
    }

    public  void execute(){
        int tmp=locationExcecutionPointer;
        int currentMemory=memory.getPosition();
        if(pointeurMemoire!=-1){
            memory.setPosition(pointeurMemoire-1);
        }
        for(locationExcecutionPointer=positionDebListeProg;locationExcecutionPointer<=positionFinListeProg;locationExcecutionPointer++){
            getProgramm().get(locationExcecutionPointer).execute();
        }
        locationExcecutionPointer=tmp;
        if(pointeurMemoire!=-1)
            memory.setPosition(currentMemory);
        memory.updateMax();
    }
    public  void rewrite() {
        int tmp=locationExcecutionPointer;
        for(locationExcecutionPointer=positionDebListeProg;locationExcecutionPointer<=positionFinListeProg;locationExcecutionPointer++){
            getProgramm().get(locationExcecutionPointer).rewrite();
        }
        locationExcecutionPointer=tmp;
    }


    public int generateCode(int counter, FileWriter writer, Boolean finish, int loop, String name, int ptr) throws IOException {
        for(int i = 0;i<loop;i++){
            writer.write("    ");
        }
        writer.write("       " + name + "("+ptr+");\n");
        return 0;
    }
}