package BrainFuck.Instructions;
import BrainFuck.Check;
import BrainFuck.Memory;


import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public int generateCode(int counter, FileWriter writer,Boolean finish,int loop) throws IOException {
        for(int i = 0;i<loop-1;i++){
            writer.write("    ");
        }
        writer.write("       }\n");
        return 0;
    }
}

    


