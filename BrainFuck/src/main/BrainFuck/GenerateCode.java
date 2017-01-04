package BrainFuck;

import BrainFuck.Instructions.Incr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Pierre on 14/12/2016.
 */
public class GenerateCode {

    private BFReader bfReader;
    private List<Computational> programm;
    private File generatedFile;
    private String namef;
    public GenerateCode(BFReader bfReader){
        this.bfReader = bfReader;
    }

    public void generateCode(String namefile) throws IOException {

        namef = namefile.split("\\.")[0];
        generatedFile = new File(namef + ".java");
        bfReader.read(namefile);
        generatedFile.createNewFile();
        FileWriter writer = new FileWriter(generatedFile);
        init(writer);
        programm = Computational.getProgramm();
        decode(writer,programm,true);
        writer.write("   }\n}");
        writer.close();
    }

    public void initProcedures(FileWriter writer) throws IOException {
        List <Procedure> proced = new ArrayList<Procedure>(Interpreter.procedures.values());
        int k = proced.size();
        for (int l = 0; l <k;l++){
            writer.write("   private static void " + proced.get(l).getName() + "(int p){\n");
            decode(writer,proced.get(l).instructions,false);
            writer.write("   }\n\n");
        }
    }

    public void init(FileWriter writer) throws IOException {
        generatedFile.createNewFile();
        writer.write("import java.io.IOException;\nimport java.io.BufferedWriter;\n" +"import java.io.File;\n" +"import java.io.FileWriter;\npublic class "+namef+"{\n\n   private static int[] tab = new int[30000];\n   private static int pointeur = 0;\n   private static File fileIn;\n   private static BufferedWriter fileOut;\n\n");
        initProcedures(writer);
        writer.write("   public static void main(String[] args) throws IOException{\n       int nbArgs = args.length;\n       int i = 0;\n");
        writer.write("       while (i <= nbArgs - 1) {\n            if (args[i].equals(\"-i\")) {\n                fileIn = new File(args[i+1]);\n            }\n");
        writer.write("            else if (args[i].equals(\"-o\")){\n                fileOut = new BufferedWriter(new FileWriter(args[i+1]));\n            }\n            i++;\n       }\n");
    }

    public void decode(FileWriter writer,List<Computational> programim,Boolean proc) throws IOException {
        int counter = 0;
        Boolean loop = false;
        int p = 0;
        if (proc){
            p = Procedure.nbreTotalInstructionsProcedures;
        }
        for (int i = p; i < programim.size(); i++){
            if (programim.get(i) instanceof Procedure){
                programim.get(i).generateCode(counter,writer,false,loop,((Procedure) programim.get(i)).getName(),((Procedure) programim.get(i)).pointeurMemoire);
            }
            if ("+".equals(programim.get(i).getCourteSyntaxe())||"-".equals(programim.get(i).getCourteSyntaxe())||"<".equals(programim.get(i).getCourteSyntaxe())||">".equals(programim.get(i).getCourteSyntaxe())||",".equals(programim.get(i).getCourteSyntaxe())||".".equals(programim.get(i).getCourteSyntaxe())){
                if (i == programim.size() - 1 || programim.get(i).getCourteSyntaxe() != programim.get(i+1).getCourteSyntaxe()){
                    counter = programim.get(i).generateCode(counter,writer,true,loop);
                }
                else{
                    counter = programim.get(i).generateCode(counter,writer,false,loop);
                }
            }
            else if(programim.get(i).getCourteSyntaxe() == "["){
                programim.get(i).generateCode(counter,writer,false,loop);
                loop = true;
            }
            else if(programim.get(i).getCourteSyntaxe() == "]"){
                programim.get(i).generateCode(counter,writer,false,loop);
                loop = false;
            }

        }
    }

}
