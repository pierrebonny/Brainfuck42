package BrainFuck;

import BrainFuck.Instructions.Back;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 12/12/2016.
 */
public abstract class Computational {


    protected static int locationExcecutionPointer;
    protected Memory memory;
    protected Trace trace;
    protected String courteSyntaxe;
    private static List<Computational> programm= new ArrayList<>();


    public Computational(Memory memory){
        this.memory=memory;
    }


    public abstract void execute();
    public abstract void rewrite();




    public int generateCode(int counter,FileWriter writer,Boolean finish,int loop)throws IOException{
        return 0;
    };

    public int generateCode(int counter, FileWriter writer, Boolean finish, int loop,String name,int pt)throws IOException{
        return 0;
    };

    public static List<Computational> getProgramm(){ return programm;}



}
