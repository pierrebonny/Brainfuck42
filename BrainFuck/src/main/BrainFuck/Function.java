package BrainFuck;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 13/12/2016.
 */
public  abstract class Function extends Methode {

    public Function(Memory memory,int nbRepetition,String chaine,String name){
        super(memory,nbRepetition,chaine,name);
    }


    public Function(Memory memory,Procedure procedure,int pointeurMémoire,String name){
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
            writer.write("       tab[pointeur] = " + name + "("+ptr+");\n");
        return 0;
    }

}
