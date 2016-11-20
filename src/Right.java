import java.awt.Color;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Right implements Computational {

    private Memory memory;
    public static final int MAX_POSITION=29999;
    private String courteSyntaxe=">";
    private Color couleur=new Color(0, 0, 255);

    public Right(Memory memory){
        this.memory = memory;
    }

    public void execute(){
        if(memory.getPosition()==MAX_POSITION){
            System.out.println("Error 2");
            System.exit(2);
        }
        else{
            memory.setPosition(memory.getPosition()+1);

            if(memory.getPosition()>memory.getMax()) memory.setMax(memory.getPosition());
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
}