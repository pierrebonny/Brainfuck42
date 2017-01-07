package BrainFuck;


import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 12/12/2016.
 */

public class Procedure extends Methode{


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

    public String getName(){
        return name;
    }

    public int generateCode(int counter, FileWriter writer, Boolean finish, Boolean loop,String name,int ptr) throws IOException {
        if (loop){
            writer.write("           " + name + "("+ptr+");\n");
        }
        else {

            writer.write("       " + name + "("+ptr+");\n");
        }
        return 0;
    }
}
