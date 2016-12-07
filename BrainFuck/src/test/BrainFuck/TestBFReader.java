package BrainFuck;

/**
 * Created by Pierre on 07/12/2016.
 */
import BrainFuck.Exception.InvalidColorException;
import org.junit.Test;
import org.junit.Before;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class TestBFReader {
    private BFReader bfreader;
    Interpreter interpreter;
    Memory memory;
    Output output;
    File file;
    FileWriter writer;
    FileReader reader;

    @Before
    public void init()throws IOException{
        memory = new Memory();
        output =new Output(memory);
        interpreter = new Interpreter(output,memory);
        bfreader = new BFReader(interpreter);
        InputStream is = new BufferedInputStream(new FileInputStream("testimg.bmp"));
        BufferedImage image;
        image = ImageIO.read(is);
        image.setRGB(1,0,Color.MAGENTA.getRGB());
        ImageIO.write(image, "bmp", new File("testimg.bmp"));

    }

    @Test(expected = InvalidColorException.class)
    public void testInvalidPixels() throws IOException{
        bfreader.readImage("testimg.bmp");
    }

}
