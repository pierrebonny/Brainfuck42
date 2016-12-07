package BrainFuck;

/**
 * Created by Pierre on 20/11/2016.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestInterpreter {
    Output output;
    Interpreter interpreter;
    Memory memory;
    BFReader bfReader;
    Map<Commandes,Computational> hashMap = new HashMap<>();

    @Before
    public void init(){
        memory = new Memory();
        output = new Output(memory);
        bfReader = new BFReader(interpreter);
        interpreter = new Interpreter(output,memory);
    }

    @Test
    public void TestFillHashmapIncr() throws IOException{
        /*String toto = "+";
        char buffer[] = new char[toto.length()];
        toto.getChars(0, toto.length(), buffer, 0);
        FileWriter titi = new FileWriter("Incr.txt");
        for (int i = 0 ; i < buffer.length; i++){
            titi.write(buffer[i]);
        }
        titi.close();
        */
    }
}
