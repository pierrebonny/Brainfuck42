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
public class TestBack {
    private Memory memory;
    private Back back;

    @Before
    public void init(){
        memory = new Memory();
        back = new Back(memory);
    }


    @Test
    public void testColor(){
        assertEquals(back.translate(),new Color(255, 0, 0));
    }
}
