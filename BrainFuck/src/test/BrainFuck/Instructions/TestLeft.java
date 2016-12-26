package BrainFuck.Instructions;

import BrainFuck.Exception.OutofBoundException;
import BrainFuck.Memory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Pierre on 23/12/2016.
 */
public class TestLeft {
    private Memory memory;
    private Left left;

    @Before
    public void init(){
        memory = new Memory();
        left = new Left(memory);
    }


    @Test(expected = OutofBoundException.class)
    public void testExtremePosition(){
        assertEquals(memory.getPosition(),0);
        left.execute();
    }

    @Test
    public void testExecute(){
        memory.setPosition(29999);
        assertEquals(memory.getPosition(),29999);
        left.execute();
        assertEquals(memory.getPosition(),29998);
    }
}

