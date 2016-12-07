package BrainFuck.Instructions;
import BrainFuck.Check;
import BrainFuck.Memory;


import java.awt.Color;

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


    public void setFichier(String s){}
    public void closeFichier(){}


        
    public void execute(){
        if (memory.getMemory() != 0)
            locationExcecutionPointer = Check.getJumpBackMap().get(locationExcecutionPointer);
        super.execute();
    }
    



}

    


