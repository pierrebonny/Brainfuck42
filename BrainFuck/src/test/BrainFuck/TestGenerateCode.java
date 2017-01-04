package BrainFuck;

/**
 * Created by Pierre on 15/12/2016.
 */
import org.junit.Test;
import org.junit.Before;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class TestGenerateCode {
    private BFReader bfReader;
    private Interpreter interpreter;
    private Output output;
    private Memory memory;
    private List<Computational> programm;
    private File generatedFile;
    private File empty;
    private GenerateCode generateCode;

    @Before
    public void initialisation() throws IOException {
        empty = new File("empty.txt");
        empty.createNewFile();
        memory = new Memory();
        output = new Output(memory);
        interpreter = new Interpreter(output,memory);
        bfReader = new BFReader(interpreter);
        generatedFile = new File("generated.java");
        generateCode = new GenerateCode(bfReader);
    }

    @Test
    public void TestEmptyFileGenerate() throws IOException {
        generatedFile.createNewFile();
        FileWriter writer = new FileWriter(generatedFile);
        generateCode.generateCode("empty.txt");
        writer.close();
        Computational.getProgramm().clear();
        assertTrue(generatedFile.canExecute());
    }

    @Test
    public void TestHelloWordFileGenerate()throws IOException {
        generatedFile.createNewFile();
        FileWriter writer = new FileWriter(generatedFile);
        generateCode.generateCode("HelloWorld.txt");
        writer.close();
        Computational.getProgramm().clear();
    }

}
