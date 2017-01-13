package BrainFuck.Instructions;

import BrainFuck.Commandes;
import BrainFuck.Memory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Thibault on 23/12/2016.
 */
public class TestIn {
    private Memory memory;
    private In in;

    @Before
    public void init(){
        memory = new Memory();
        in = new In(memory,"tests/testIn.txt");
    }
    @After
    public  void after(){
        in.closeFichier();
    }


    @Test
    public void testExecute(){
        in.execute();
        assertEquals(memory.getMemory(),'2');
    }


    @Test
    public void testColor(){
        assertEquals(in.translate(),new Color(255,255,0));
    }


}
