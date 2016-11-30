


import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Decr extends Computational {


    public static final int MIN_VALUE=0;

    public Decr(Memory memory){
        super(memory);
        courteSyntaxe="-";
        couleur=new Color(75, 0, 130);
    }

    public void execute() throws UnderFlowException{
        if(memory.getMemory()==MIN_VALUE){
            throw  new UnderFlowException("Error 1 : UnderFlowException",1);
        }
        else{
            Computational.incrDataWrite();
            memory.setMemory(memory.getMemory()-1);
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

