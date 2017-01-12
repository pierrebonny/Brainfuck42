package BrainFuck;

/**
 * Created by Pierre on 15/12/2016.
 */
import org.junit.Test;
import org.junit.Before;
import java.io.*;

public class TestGenerateCode {
    private BFReader bfReader;
    private Interpreter interpreter;
    private Output output;
    private Memory memory;
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
        generateCode = new GenerateCode(bfReader);
    }

    @Test
    public void TestEmptyFileGenerate() throws IOException {
        bfReader.read("empty.txt");
        generateCode.generateCode("empty.txt");
        Computational.getProgramm().clear();
    }

    @Test
    public void TestHelloWordFileGenerate()throws IOException {
        bfReader.read("HelloWorld.txt");
        generateCode.generateCode("HelloWorld.txt");
        Computational.getProgramm().clear();
        Procedure.nbreTotalInstructionsProcedures = 0;
    }

}
