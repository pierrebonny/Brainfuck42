package BrainFuck;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertTrue;

/**
 * Created by Pierre on 13/01/2017.
 */
public class TestBfck {
    private String[] s = new String[2];
    private String[] s1 = new String[3];

    @Before
    public void init(){

    }

    @Test(expected = NullPointerException.class)
    public void TestMainNoFile() throws IOException {
        s[0] = "-p";
        Bfck.main(s);
    }




}
