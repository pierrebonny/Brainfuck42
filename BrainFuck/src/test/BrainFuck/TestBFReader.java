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
    BufferedImage image;

    @Before
    public void init()throws IOException{
        memory = new Memory();
        output =new Output(memory);
        interpreter = new Interpreter(output,memory);
        bfreader = new BFReader(interpreter);
        image = new BufferedImage(3,3,BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.getWidth();i++){
            for (int j = 0;j < image.getHeight();j++){
                image.setRGB(i,j,Color.WHITE.getRGB());
            }
        }
        image.setRGB(0,2,Color.BLUE.getRGB());
        file = new File("testBFReader.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("+-><[].,");
        writer.close();
    }

    @Test(expected = InvalidColorException.class)
    public void testInvalidPixelImage() throws IOException{
        ImageIO.write(image, "bmp", new File("testBFReader.bmp"));
        bfreader.readImage("testBFReader.bmp");
        Computational.getProgramm().clear();
    }

    @Test
    public void testReadNormalImage() throws IOException {
        image.setRGB(0,2,Color.WHITE.getRGB());
        ImageIO.write(image,"bmp",new File("testBFReader.bmp"));
        Computational.getProgramm().clear();
        bfreader.readImage("testBFReader.bmp");
        assertEquals(Computational.getProgramm().size(),1);
        Computational.getProgramm().clear();
    }

    @Test
    public void testReadEmptyImage() throws IOException {
        image = new BufferedImage(3,3,BufferedImage.TYPE_INT_RGB);
        ImageIO.write(image,"bmp",new File("testBFReader.bmp"));
        Computational.getProgramm().clear();
        bfreader.readImage("testBFReader.bmp");
        assertEquals(Computational.getProgramm().size(),0);
        Computational.getProgramm().clear();
    }

    @Test
    public void testReadNormalFile() throws IOException {
        Computational.getProgramm().clear();
        bfreader.readFile("testBFReader.txt");
        assertEquals(Computational.getProgramm().size(),8);
        Computational.getProgramm().clear();
    }

    @Test
    public void testReadEmptyFile() throws IOException {
        file = new File("testBFReader.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("");
        writer.close();
        Computational.getProgramm().clear();
        bfreader.readFile("testBFReader.txt");
        assertEquals(Computational.getProgramm().size(),0);

    }

    /*@Test
    public void testRewriteEmptyFile() throws IOException {
        file = new File("testBFReader.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("");
        writer.close();
        bfreader.rewrite("testBFReader.txt");
    }*/

}
