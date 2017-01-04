package BrainFuck;

import BrainFuck.Instructions.Incr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Pierre on 14/12/2016.
 */
public class GenerateCode {

    private BFReader bfReader;
    private List<Computational> programm;
    private File generatedFile = new File("generated.java");
    public GenerateCode(BFReader bfReader){
        this.bfReader = bfReader;
    }

    public void generateCode(String namefile) throws IOException {
        bfReader.read(namefile);
        generatedFile.createNewFile();
        FileWriter writer = new FileWriter(generatedFile);
        init(writer);
        decode(writer);
        writer.write("   }\n}");
        writer.close();
    }

    public void init(FileWriter writer) throws IOException {
        generatedFile.createNewFile();
        writer.write("import java.io.IOException;\nimport java.io.BufferedWriter;\n" +"import java.io.File;\n" +"import java.io.FileWriter;\npublic class Main{\n\n   private static int[] tab = new int[30000];\n   private static int pointeur = 0;\n   private static File fileIn;\n   private static BufferedWriter fileOut;\n\n");
        writer.write("   public static void main(String[] args) throws IOException{\n       int nbArgs = args.length;\n       int i = 0;\n");
        writer.write("       while (i <= nbArgs - 1) {\n            if (args[i].equals(\"-i\")) {\n                fileIn = new File(args[i+1]);\n            }\n");
        writer.write("            else if (args[i].equals(\"-o\")){\n                fileOut = new BufferedWriter(new FileWriter(args[i+1]));\n            }\n            i++;\n       }\n");
    }

    public void decode(FileWriter writer) throws IOException {
        programm = Computational.getProgramm();
        int counter = 0;
        Boolean finish = false;
        Boolean loop = false;
        for (int i = 0; i < programm.size(); i++){
                if (programm.get(i).getCourteSyntaxe().equals("+")||programm.get(i).getCourteSyntaxe().equals("-")||programm.get(i).getCourteSyntaxe().equals("<")||programm.get(i).getCourteSyntaxe().equals(">")||programm.get(i).getCourteSyntaxe().equals(",")||programm.get(i).getCourteSyntaxe().equals(".")){
                    if (i == programm.size() - 1 || programm.get(i).getCourteSyntaxe() != programm.get(i+1).getCourteSyntaxe()){
                        finish = true;
                        counter = programm.get(i).generateCode(counter,writer,finish,loop);
                        finish = false;
                    }
                    else{
                        counter = programm.get(i).generateCode(counter,writer,finish,loop);
                    }

                }
                else if(programm.get(i).getCourteSyntaxe() == "["){
                    programm.get(i).generateCode(counter,writer,finish,loop);
                    loop = true;
                }
                else if(programm.get(i).getCourteSyntaxe() == "]"){
                    programm.get(i).generateCode(counter,writer,finish,loop);
                    loop = false;
                }

        }
    }

}
