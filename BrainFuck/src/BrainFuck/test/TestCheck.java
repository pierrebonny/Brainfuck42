import BrainFuck.Check;
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
    File inputFile = new File("bip.txt");



    @Test (expected = CheckException.class)
    public void testCheck() throws IOException, CheckException {
        File file = new File("Hello1.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("[[]");
        check.check(String.valueOf(writer));
    }
}
