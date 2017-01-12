package BrainFuck.Instructions;
import BrainFuck.Instruction;
import BrainFuck.Memory;
import BrainFuck.Metrics;
import BrainFuck.Exception.OverFlowException;


import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Incr extends Instruction {


    public static final int MAX_VALUE=255;

    public Incr(Memory memory){
        super(memory);
        courteSyntaxe="+";
        couleur=Color.white;
    }

    public void execute() throws OverFlowException {
        if(memory.getMemory()==MAX_VALUE){
            throw new OverFlowException("Error 1 : OverFlowException",1);
        }
        else{
            memory.setMemory(memory.getMemory()+1);
            //if(memory.getPosition()>memory.getMax()) memory.setMax(memory.getPosition());
            memory.updateMax();
            Metrics.incrDataWrite();
            super.execute();
        }
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public int generateCode(int counter,FileWriter writer,Boolean finish,int loop) throws IOException {
        counter ++;
        if (finish){
            for(int i = 0;i<loop;i++){
                writer.write("    ");
            }
            writer.write("       tab[pointeur] += " + counter + ";\n");
            counter = 0;
        }
        return counter;
    }


    public void setFichier(String s){}
    public  void closeFichier(){}
}

