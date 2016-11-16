import java.awt.Color;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Decr implements Computational {

    private Memory memory;
    public static final int MIN_VALUE=0;
    private String courteSyntaxe="-";
    private Color couleur=new Color(75, 0, 130);

    public Decr(Memory memory){
        this.memory = memory;
    }

    public void execute(){
        if(memory.getMemory()==MIN_VALUE){
            System.out.println("Error 1");
            System.exit(1);
        }
        else{
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

}
