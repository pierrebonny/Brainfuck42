package BrainFuck.Instructions;
import BrainFuck.Computational;
import BrainFuck.Memory;
import BrainFuck.Metrics;
import BrainFuck.Exception.OverFlowException;


import java.awt.Color;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Incr extends Computational {


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




    public void setFichier(String s){}
    public  void closeFichier(){}
}

