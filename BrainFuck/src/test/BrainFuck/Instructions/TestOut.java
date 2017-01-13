package BrainFuck.Instructions;

import BrainFuck.Commandes;
import BrainFuck.Memory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Thibault on 23/12/2016.
 */
public class TestOut {
    private Memory memory;
    private Out out;
    private Incr incr;

    @Before
    public void init(){
        memory = new Memory();
        incr= new Incr(memory);
        out = new Out(memory,"tests/testOut.txt");
    }

    @After
    public  void after(){
        out.closeFichier();
    }

    @Test
    public void testExecute() throws IOException {
        int i=0;
        while(i!=97){
            incr.execute();
            i++;
        }
        System.out.println(memory.getMemory());
        //System.out.println(out.fichierOu);
        out.execute();
        out.closeFichier();
        FileReader f= new FileReader(new File("tests/testOut.txt"));
        try {
            assertEquals(f.read(), 'a');
            f.close();
        }catch (IOException e) {
        }
    }


    @Test
    public void testColor(){
        assertEquals(out.translate(),new Color(0,255,0));
    }

}
