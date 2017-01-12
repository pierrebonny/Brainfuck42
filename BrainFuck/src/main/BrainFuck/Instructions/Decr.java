package BrainFuck.Instructions;
import BrainFuck.Instruction;
import BrainFuck.Exception.UnderFlowException;
import BrainFuck.Memory;
import BrainFuck.Metrics;


import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Decr extends Instruction {


    public static final int MIN_VALUE=0;

    public Decr(Memory memory){
        super(memory);
        courteSyntaxe="-";
        couleur=new Color(75, 0, 130);
    }

    public void execute() throws UnderFlowException {
        if(memory.getMemory()==MIN_VALUE){
            throw  new UnderFlowException("Error 1 : UnderFlowException",1);
        }
        else{
            memory.setMemory(memory.getMemory()-1);
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

    public int generateCode(int counter, FileWriter writer, Boolean finish,int loop) throws IOException {
        counter ++;
        if (finish){
            for(int i = 0;i<loop;i++){
                writer.write("    ");
            }
            writer.write("       tab[pointeur] -= " + counter + ";\n");
            counter = 0;
            finish = false;
        }
        return counter;
    }


    public void setFichier(String s){}
    public  void closeFichier(){}

}

