package BrainFuck.Instructions;

import BrainFuck.Exception.OverFlowException;
import BrainFuck.Memory;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Pierre on 23/12/2016.
 */
public class TestIncr {
    private Memory memory;
    private Incr incr;

    @Before
    public void init(){
        memory = new Memory();
        incr = new Incr(memory);
    }

    @Test(expected = OverFlowException.class)
    public void testExecuteFullMemory(){
        memory.setMemory(255);
        incr.execute();
    }

    @Test
    public void testExecute(){
        assertEquals(memory.getMemory(),0);
        incr.execute();
        assertEquals(memory.getMemory(),1);
    }

    @Test
    public void testColor(){
        assertEquals(incr.translate(),new Color(255,255,255));
    }
}
