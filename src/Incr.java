


import java.io.*;


import java.awt.Color;
import java.io.IOException;

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

    public void execute() throws OverFlowException{
        if(memory.getMemory()==MAX_VALUE){
            throw new OverFlowException("Error 1 : OverFlowException",1);
        }
        else{
            Computational.incrDataWrite();
            memory.setMemory(memory.getMemory()+1);
            super.execute();
        }
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }



    public void Check(){}
    public void setFichier(String s){}
    public  void closeFichier(){}
}

