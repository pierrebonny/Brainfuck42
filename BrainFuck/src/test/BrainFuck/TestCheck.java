package BrainFuck;
import BrainFuck.Exception.CheckException;
import org.junit.Test;
import org.junit.Before;
import java.io.*;

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
    File file;
    FileWriter writer;
    FileReader reader;
    BufferedReader buff;
    BufferedWriter buffw;

    @Before
    public void init()throws IOException{
        memory = new Memory();
        output = new Output(memory);
        interpreter = new Interpreter(output,memory);
        bfReader = new BFReader(interpreter);
        check = new Check(bfReader);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //File inputFile = new File("bip.txt");
    }




    @Test (expected = IOException.class)
    public void testCheck() throws IOException, CheckException {
        file.createNewFile();
        writer.write("[[]");
        String str = writer.toString();
        System.out.println(str);
        check.check("Hello1.txt");
    }
}
