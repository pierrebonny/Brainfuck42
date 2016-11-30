package BrainFuck.Instructions;
import BrainFuck.*;
import BrainFuck.Exception.OutofBoundException;


import java.awt.Color;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Left extends Computational {


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
            Computational.incrDataMove();
            memory.setPosition(memory.getPosition()-1);
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

