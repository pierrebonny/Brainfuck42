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
    public static boolean b = false;

    public GenerateCode(BFReader bfReader){
        this.bfReader = bfReader;
    }

    protected void generateCode(String namefile) throws IOException {

        namef = namefile.split("\\.")[0];
        generatedFile = new File(namef + ".java");
        generatedFile.createNewFile();
        FileWriter writer = new FileWriter(generatedFile);
        init(writer);
        programm = Computational.getProgramm();
        decode(writer,programm,true);
        writer.write("   }\n}");
        writer.close();
    }

    private void initProcedures(FileWriter writer) throws IOException {
        List <Procedure> proced = new ArrayList<Procedure>(Interpreter.procedures.values());
        int k = proced.size();
        for (int l = 0; l <k;l++){
            writer.write("   private static void " + proced.get(l).name + "(int p){\n");
            decode(writer,proced.get(l).instructions,false);
            writer.write("   }\n\n");
        }
    }
    private void initFunctions(FileWriter writer) throws IOException {
        List <Function> functions = new ArrayList<Function>(Interpreter.functions.values());
        int k = functions.size();
        for (int l = 0; l <k;l++){
            writer.write("   private static int " + functions.get(l).name + "(int p){\n");
            decode(writer,functions.get(l).instructions,false);
            writer.write("       return tab[pointeur];\n   }\n\n");
        }
    }

    private void init(FileWriter writer) throws IOException {
        generatedFile.createNewFile();
        writer.write("import java.io.IOException;\nimport java.io.BufferedWriter;\n" +"import java.io.File;\n" +"import java.io.FileWriter;\npublic class "+namef+"{\n\n   private static int[] tab = new int[30000];\n   private static int pointeur = 0;\n   private static File fileIn;\n   private static BufferedWriter fileOut;\n\n");
        initProcedures(writer);
        initFunctions(writer);
        writer.write("   public static void main(String[] args) throws IOException{\n       int nbArgs = args.length;\n       int i = 0;\n");
        writer.write("       while (i <= nbArgs - 1) {\n            if (args[i].equals(\"-i\")) {\n                fileIn = new File(args[i+1]);\n            }\n");
        writer.write("            else if (args[i].equals(\"-o\")){\n                fileOut = new BufferedWriter(new FileWriter(args[i+1]));\n            }\n            i++;\n       }\n");
    }

    private void decode(FileWriter writer,List<Computational> programim,Boolean meth) throws IOException {
        int counter = 0;
        int loop = 0;
        int p = 0;
        if (meth){
            p = Methode.nbreTotalInstructionsProceduresFonctions;
        }
        for (int i = p; i < programim.size(); i++){
            if (programim.get(i) instanceof Procedure){
                programim.get(i).generateCode(counter,writer,false,loop,((Procedure) programim.get(i)).name,((Procedure) programim.get(i)).pointeurMemoire);
            }
            if (programim.get(i) instanceof Function){
                programim.get(i).generateCode(counter,writer,false,loop,((Function) programim.get(i)).name,((Function) programim.get(i)).pointeurMemoire);
            }

            if ("+".equals(((Instruction)programim.get(i)).getCourteSyntaxe())||"-".equals(((Instruction)programim.get(i)).getCourteSyntaxe())||"<".equals(((Instruction)programim.get(i)).getCourteSyntaxe())||">".equals(((Instruction)programim.get(i)).getCourteSyntaxe())||",".equals(((Instruction)programim.get(i)).getCourteSyntaxe())||".".equals(((Instruction)programim.get(i)).getCourteSyntaxe())){
                if (i == programim.size() - 1 || ((Instruction)programim.get(i)).getCourteSyntaxe() != ((Instruction)programim.get(i+1)).getCourteSyntaxe()){
                    counter = programim.get(i).generateCode(counter,writer,true,loop);
                }
                else{
                    counter = programim.get(i).generateCode(counter,writer,false,loop);
                }
            }
            else if(((Instruction)programim.get(i)).getCourteSyntaxe() == "["){
                programim.get(i).generateCode(counter,writer,false,loop);
                loop++;
            }
            else if(((Instruction)programim.get(i)).getCourteSyntaxe() == "]"){
                programim.get(i).generateCode(counter,writer,false,loop);
                loop--;
            }

        }
    }

}