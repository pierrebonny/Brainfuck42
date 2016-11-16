import java.awt.Color;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Left implements Computational {

    private Memory memory;
    public static final int MIN_POSITION=0;
    private String courteSyntaxe="<";
    private Color couleur=new Color(148, 0, 211);

    public Left(Memory memory){
        this.memory = memory;
    }

    public void execute(){
        if(memory.getPosition()==MIN_POSITION){
            System.out.println("Error 2");
            System.exit(2);
        }
        else{
            memory.setPosition(memory.getPosition()-1);
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