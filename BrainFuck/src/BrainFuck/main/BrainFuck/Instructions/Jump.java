package BrainFuck.Instructions;
import BrainFuck.Check;
import BrainFuck.Computational;
import BrainFuck.Memory;


import java.awt.Color;

public class Jump extends Loops {
    


    public Jump(Memory memory){
        super(memory);
        courteSyntaxe="[";
        couleur=new Color(255, 127, 0);
    }
    
    public void execute(){
        if(memory.getMemory()==0)
            Computational.locationExcecutionPointer = Check.getJumpBackMap().get(Computational.locationExcecutionPointer);
        super.execute();
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

