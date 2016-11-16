import java.awt.Color;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Incr implements Computational {

    private Memory memory;
    public static final int MAX_VALUE=255;

    public Incr(Memory memory){
        this.memory = memory;
    }

    public void execute(){
        if(memory.getMemory()==MAX_VALUE){
            System.out.println("Error 1");
            System.exit(1);
        }
        else{
            memory.setMemory(memory.getMemory()+1);
        }
    }

    public void rewrite(){
        System.out.print("+");
    }

    public Color translate(){
        return Color.white;
    }

    public void Check(){}

    public int hexadecimal (String hexa){
        
    }

}
