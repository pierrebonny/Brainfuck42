package BrainFuck.Instructions;

import BrainFuck.Exception.OutofBoundException;
import BrainFuck.Memory;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Thibault on 23/12/2016.
 */
public class TestJump {
    private Memory memory;
    private Jump jump;

    @Before
    public void init(){
        memory = new Memory();
        jump = new Jump(memory);
    }


    @Test
    public void testColor(){
        assertEquals(jump.translate(),new Color(255, 127, 0));
    }
}
