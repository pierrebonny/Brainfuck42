package BrainFuck.Instructions;

import BrainFuck.Exception.OutofBoundException;
import BrainFuck.Memory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Pierre on 23/12/2016.
 */
public class TestRight {
    private Memory memory;
    private Right right;

    @Before
    public void init(){
        memory = new Memory();
        right = new Right(memory);
    }

    @Test(expected = OutofBoundException.class)
    public void testExecuteFullMemory(){
        memory.setPosition(29999);
        assertEquals(memory.getPosition(),29999);
        right.execute();
    }

    @Test
    public void testExecute(){
        assertEquals(memory.getPosition(),0);
        right.execute();
        assertEquals(memory.getPosition(),1);
    }
}
