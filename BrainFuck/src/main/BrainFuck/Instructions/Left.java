package BrainFuck.Instructions;
import BrainFuck.Instruction;
import BrainFuck.Exception.OutofBoundException;
import BrainFuck.Memory;
import BrainFuck.Metrics;


import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Left extends Instruction {


    public static final int MIN_POSITION=0;


    public Left(Memory memory){
        super(memory);
        courteSyntaxe="<";
        couleur=new Color(148, 0, 211);
    }

    public void execute() throws OutofBoundException {
        if(memory.getPosition()==MIN_POSITION){
            throw new OutofBoundException("Error 2 : OutofBoundException",2);
        }
        else{
            memory.setPosition(memory.getPosition()-1);
            Metrics.incrDataMove();
            super.execute();
        }
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public int generateCode(int counter, FileWriter writer, Boolean finish,Boolean loop) throws IOException {
        counter ++;
        if (finish){
            if (loop){
                writer.write("           pointeur -= " + counter + ";\n");
            }
            else {
                writer.write("       pointeur -= " + counter + ";\n");
            }
            counter = 0;
        }
        return counter;
    }
    public void setFichier(String s){}
    public  void closeFichier(){}
}

