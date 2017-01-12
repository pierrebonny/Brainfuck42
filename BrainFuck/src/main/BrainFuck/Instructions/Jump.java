package BrainFuck.Instructions;
import BrainFuck.Check;
import BrainFuck.Instruction;
import BrainFuck.Memory;


import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

public class Jump extends Loops {
    


    public Jump(Memory memory){
        super(memory);
        courteSyntaxe="[";
        couleur=new Color(255, 127, 0);
    }
    
    public void execute(){
        if(memory.getMemory()==0)
            Instruction.locationExcecutionPointer = Check.getJumpBackMap().get(Instruction.locationExcecutionPointer);
        super.execute();
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public int generateCode(int counter, FileWriter writer,Boolean finish,int loop) throws IOException {
        for(int i = 0;i<loop;i++){
            writer.write("    ");
        }
        writer.write("       while(tab[pointeur] != 0){\n");
        return 0;
    }


    public void setFichier(String s){}
    public  void closeFichier(){}

}

