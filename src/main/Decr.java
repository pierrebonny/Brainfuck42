import java.awt.Color;

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

    public void execute(){
        super.execute();
        if(memory.getMemory()==MIN_VALUE){
            System.out.println("Error 1");
            System.exit(1);
        }
        else{
            DATA_WRITE++;
            memory.setMemory(memory.getMemory()-1);
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

