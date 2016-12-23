package BrainFuck;

import BrainFuck.Exception.UnderFlowException;
import BrainFuck.Instructions.Decr;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Pierre on 23/12/2016.
 */
public class TestDecr {
    private Memory memory;
    private Decr decr;

    @Before
    public void init(){
        memory = new Memory();
        decr = new Decr(memory);
    }

    @Test(expected = UnderFlowException.class)
    public void testExecuteFullMemory(){
        decr.execute();
    }

    @Test
    public void testExecute(){
        memory.setMemory(255);
        assertEquals(memory.getMemory(),255);
        decr.execute();
        assertEquals(memory.getMemory(),254);
    }
}
