package BrainFuck;

import java.awt.*;

/**
 * Created by Pierre on 13/12/2016.
 */
public  abstract class Function extends Computational {

    public Function(Memory memory){
        super(memory);
    }


    public  void execute(){}
    public  void rewrite(){}


    public  void setFichier(String s){}
    public  void closeFichier(){}
}
