package BrainFuck.Instructions;

import BrainFuck.Commandes;
import BrainFuck.Memory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Thibault on 23/12/2016.
 */
public class TestIn {
    private Memory memory;
    private In in;

    @Before
    public void init() throws IOException {
        memory = new Memory();
        File file = new File("testIn.txt");
        FileWriter writer = new FileWriter(file);
        writer.write("2");
        writer.close();
        file.createNewFile();
        in = new In(memory,"testIn.txt");
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
