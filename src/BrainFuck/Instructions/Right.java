package BrainFuck.Instructions;
import BrainFuck.*;
import BrainFuck.Exception.OutofBoundException;


import java.awt.Color;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Right extends Computational {


    public static final int MAX_POSITION=29999;

    public Right(Memory memory){
        super(memory);
        courteSyntaxe=">";
        couleur=new Color(0, 0, 255);
    }

    public void execute() throws OutofBoundException {
        if(memory.getPosition()==MAX_POSITION){
            throw new OutofBoundException("Error 2 : OutofBoundException",2);
        }
        else{
            memory.setPosition(memory.getPosition()+1);
            if(memory.getPosition()>memory.getMax()) memory.setMax(memory.getPosition());
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

    public void Check(){}
    public void setFichier(String s){}
    public  void closeFichier(){}

}

