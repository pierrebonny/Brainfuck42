package BrainFuck;

/**
 * Created by Pierre on 12/01/2017.
 */
import org.junit.Test;
import org.junit.Before;
import java.io.*;
import static org.junit.Assert.*;

public class TestTrace {
    private Memory memory;
    private Trace trace;

    @Before
    public void init(){
        memory = new Memory();
        trace = new Trace(memory);
        trace.setFile("hello1.txt");
    }

    @Test
    public void testTrace(){
        assertNotEquals(Trace.file,null);
        trace.trace();
        assertEquals(Trace.contenuFichierLog,trace.);

    }
}
