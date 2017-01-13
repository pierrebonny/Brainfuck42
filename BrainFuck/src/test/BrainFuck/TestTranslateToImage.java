package BrainFuck;

/**
 * Created by Pierre on 07/12/2016.
 */
import org.junit.Test;
import org.junit.Before;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import static org.junit.Assert.*;

public class TestTranslateToImage {

    private Translatetoimage translatetoimage;
    private BufferedImage bufferedImage;
    private Color color;
    BFReader bfreader;
    Interpreter interpreter;
    Memory memory;
    Output output;

    @Before
    public void init(){
        memory = new Memory();
        output = new Output(memory);
        translatetoimage = new Translatetoimage();
        interpreter = new Interpreter(output,memory);
        bfreader = new BFReader(interpreter);

    }

    @Test
    public void TestTranslateEmptyFile()throws IOException {
        translatetoimage.translate("empty.txt");
        InputStream is = new BufferedInputStream(new FileInputStream("empty.bmp"));
        BufferedImage image;
        image = ImageIO.read(is);
        assertTrue(image.getHeight() == 1); //On teste le cas limite du programme vide
        assertTrue(image.getWidth() == 1);
        color = new Color(image.getRGB(0, 0));
        assertTrue(color.equals(Color.black));
        is.close();
        Computational.getProgramm().clear();
    }
    @Test
    public void TestTranslateNormalFile()throws IOException{
        File file = new File("testTranslateToImage.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("+-><[].,");
        writer.close();
        bfreader.readFile("testTranslateToImage.txt");
        translatetoimage.translate("testTranslateToImage.txt");
        InputStream is = new BufferedInputStream(new FileInputStream("testTranslateToImage.bmp"));
        BufferedImage image;
        image = ImageIO.read(is);
        color = new Color(image.getRGB(0, 0));
        assertTrue(color.equals(new Color(255,255,255)));
        color = new Color(image.getRGB(3, 0));
        assertTrue(color.equals(new Color(75,0,130)));
        color = new Color(image.getRGB(6,0));
        assertTrue(color.equals(new Color(0, 0, 255)));
        color = new Color(image.getRGB(0,3));
        assertTrue(color.equals(new Color(148, 0, 211)));
        color = new Color(image.getRGB(3,3));
        assertTrue(color.equals(new Color(255, 127, 0)));
        color = new Color(image.getRGB(6,3));
        assertTrue(color.equals(new Color(255, 0, 0)));
        color = new Color(image.getRGB(0,6));
        assertTrue(color.equals(new Color(0, 255, 0)));
        color = new Color(image.getRGB(3,6));
        assertTrue(color.equals(new Color(255, 255, 0)));
        is.close();
        Computational.getProgramm().clear();
    }
}
