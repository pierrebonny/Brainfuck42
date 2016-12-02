package BrainFuck.Instructions;
import BrainFuck.*;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Back extends Loops {
    



    public Back(Memory memory){
        super(memory);
        courteSyntaxe="]";
        couleur=new Color(255, 0, 0);

    }
    

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public void Check(){}
    public void setFichier(String s){}
    public void closeFichier(){}


        
    public void execute(){
        if (memory.getMemory() != 0)
            Computational.locationExcecutionPointer = Check.getJumpBackMap().get(Computational.locationExcecutionPointer);
        super.execute();
    }
    



}

    


