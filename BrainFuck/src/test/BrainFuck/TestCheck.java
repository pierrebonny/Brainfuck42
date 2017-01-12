package BrainFuck;
import BrainFuck.Exception.CheckException;
import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import java.io.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertTrue;

/**
 * Created by Campo on 06/12/2016.
 */

public class TestCheck {
    Check check;
    CheckException checkException;
    Memory memory;
    Output output;
    Interpreter interpreter;
    BFReader bfReader;

    @Before
    public void init() throws IOException {

        memory = new Memory();
        output = new Output(memory);
        interpreter = new Interpreter(output, memory);
        bfReader = new BFReader(interpreter);
        check = new Check(bfReader);
    }


            @Test(expected = CheckException.class)
            public void testCheck1 () throws IOException, CheckException {
            String toto = "[[]";
            char buffer[] = new char[toto.length()];
            toto.getChars(0, toto.length(), buffer, 0);
            FileWriter titi = new FileWriter("function.txt");
            for (int i = 0; i < buffer.length; i += 1) {
                titi.write(buffer[i]);
            }
            titi.close();
            check.check("function.txt");
            Computational.getProgramm().clear();

        }


    @Test//(expected = CheckException.class)
    public void testCheck2 () throws IOException{
        String toto = "[]]";
        FileWriter titi = new FileWriter("Hello2.txt");
        titi.write(toto);
        titi.close();
        try{
            check.check("Hello2.txt");
        }catch(CheckException e){
        }
        Computational.getProgramm().clear();
    }

    @Test
    public void testCheck3 () throws IOException, CheckException{
        String toto = "[[]][]";
        char buffer[] = new char[toto.length()];
        toto.getChars(0, toto.length(), buffer, 0);
        FileWriter titi = new FileWriter("Hello3.txt");
        for (int i = 0 ; i < buffer.length; i++){
            titi.write(buffer[i]);
        }
        titi.close();
        check.check("Hello3.txt");
        Computational.getProgramm().clear();
    }
}