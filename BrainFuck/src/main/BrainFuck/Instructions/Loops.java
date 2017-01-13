package BrainFuck.Instructions;
import BrainFuck.Instruction;
import BrainFuck.Memory;
import BrainFuck.Metrics;

public abstract class Loops extends Instruction {
    
    public Loops(Memory memory){ super(memory); }

    public void execute(){
        Metrics.incrDataRead();
        super.execute();
    }
    
    
}
