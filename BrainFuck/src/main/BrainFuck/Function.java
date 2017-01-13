package BrainFuck;

import BrainFuck.Exception.OutofBoundException;
import BrainFuck.Exception.SegmentationException;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 13/12/2016.
 */



public   class Function extends Methode {


    //Nombre total d'instructions DEFINISANT  toutes les  fonctions: variable servant à initialiser le pointeur d'execution lors de l'execution de la liste d'intruction du programme
    public static int nbreTotalInstructionsFonctions;


    public Function(Memory memory,int nbRepetition,String chaine,String name){
        super(memory,nbRepetition,chaine,name);
    }


    public Function(Memory memory,Function function,int pointeurMémoire,String name){
        super(memory,function,pointeurMémoire,name);
    }

    public  void execute(){
        int tmp= locationExcecutionPointer;

        int savePositionMemory=memory.getPosition();
        int tmpMax=memory.getMax();


        memory.setPosition(tmpMax+1);

        try {
            for (locationExcecutionPointer = this.positionDebListeProg; locationExcecutionPointer <= this.positionFinListeProg; locationExcecutionPointer++) {
                getProgramm().get(locationExcecutionPointer).execute();
                memory.updateMax();
            }
        }catch (OutofBoundException e){
            throw new SegmentationException("Segmentation Error",10);
        }
        if(this.pointeurMemoire!=-1) {
            memory.setMemoryIndex(savePositionMemory, memory.getMemory() + memory.getMemoryIndex(pointeurMemoire));
        } else {
            memory.setMemoryIndex(savePositionMemory, memory.getMemory());
        }


        for(int i=tmpMax+1;i<=memory.getMax();i++)
            memory.setMemoryIndex(i,0);
        memory.setMax(tmpMax);
        locationExcecutionPointer =tmp;
        memory.setPosition(savePositionMemory);
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