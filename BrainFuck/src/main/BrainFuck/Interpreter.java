package BrainFuck;



import BrainFuck.Instructions.*;
import BrainFuck.Exception.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */

public class Interpreter{

    protected Memory memory;
    private Output output;

    protected static Map<Commandes, Instruction> interprete = new HashMap<>();
    protected static Map<String,Macro> macros= new HashMap<>();
    protected  static Map<String,Procedure> procedures= new HashMap<>();


    public Interpreter(Output output,Memory memory){
        this.output = output;
        this.memory = memory;
        fillHashmap(interprete);
    }

    private void fillHashmap(Map<Commandes, Instruction> hashmap) {
        interprete.put(Commandes.INCR,new Incr(memory));
        interprete.put(Commandes.DECR ,new Decr(memory));
        interprete.put(Commandes.LEFT,new Left(memory));
        interprete.put(Commandes.RIGHT,new Right(memory));
        interprete.put(Commandes.IN,new In(memory));
        interprete.put(Commandes.OUT,new Out(memory));
        interprete.put(Commandes.JUMP,new Jump(memory));
        interprete.put(Commandes.BACK,new Back(memory));
    }


    public void saveInstructions(String line) {
        int size = line.length();
        int i = 0;
        char c = line.charAt(i);
        StringBuilder syntlong = new StringBuilder();

        while (c != '#' && i < size) {
            for (Commandes com : Commandes.values()) {
                if (com.getCourte() == c) {
                    Computational.getProgramm().add(interprete.get(com));
                }
            }
            if (c != ' ' || c != '\t') {
                syntlong.append(c);
            }

            i++;
            if (i != size) {
                c = line.charAt(i);
            }

        }
        if ((syntlong.length() != 0)) {
            for (Commandes com : Commandes.values()) {
                if (com.getLongue().equals(line)) {
                    Computational.getProgramm().add(interprete.get(com));
                    return;
                }
            }
            if (procedures.get(line)!=null){
                Procedure.nbreTotalProcUtilise++;
                procedures.get(line).incrNbUtilisation();
                Computational.getProgramm().add(procedures.get(line));
                return;
            }
            if (macros.get(line) != null) {
                Computational.getProgramm().addAll(macros.get(line).getListeInst());
                return;

            }
            String [] macro_procedure_Para=line.split(" ");
            if(macros.get(macro_procedure_Para[0]) != null){
                macros.get(macro_procedure_Para[0]).addInstructions(Integer.parseInt(macro_procedure_Para[1]));
                return;
            }
            if(procedures.get(macro_procedure_Para[0]) != null){
                Procedure procedure = procedures.get(macro_procedure_Para[0]);
                Computational.getProgramm().add(new Procedure(this.memory,procedure,Integer.parseInt(macro_procedure_Para[1]),procedure.getName()));

                return;
            }

            }
            String [] macro_procedure_Para=line.split(" ");
            if(macros.get(macro_procedure_Para[0]) != null){
                macros.get(macro_procedure_Para[0]).addInstructions(Integer.parseInt(macro_procedure_Para[1]));
                return;
            }
            if(procedures.get(macro_procedure_Para[0]) != null){
                Procedure procedure =procedures.get(macro_procedure_Para[0]);
                Computational.getProgramm().add(new Procedure(this.memory,procedure,Integer.parseInt(macro_procedure_Para[1]),procedure.getName()));
                return;
            }

        }

    public void createMacro(String line){
        String [] macroDef=line.split(" ");
        macros.put(macroDef[1],new Macro(Integer.parseInt(macroDef[2]),macroDef[3]));
    }
    public void createProcedure(String line){
        String [] procedureDef=line.split(" ");
        procedures.put(procedureDef[1],new Procedure(this.memory,Integer.parseInt(procedureDef[2]),procedureDef[3],procedureDef[1]));
    }


    public void interprete() throws OutofBoundException,OverFlowException,UnderFlowException{
        for (Computational.locationExcecutionPointer = Procedure.nbreTotalInstructionsProcedures; Computational.locationExcecutionPointer < Computational.getProgramm().size(); Computational.locationExcecutionPointer++) {
            Computational.getProgramm().get(Computational.locationExcecutionPointer).execute();
        }
        Metrics.setExecTime(System.currentTimeMillis()-Metrics.getExecTime());


        new Trace(memory).trace();
        output.afficher();
        output.metrics();
    }

    public void rewrite(){
        for(int i = Procedure.nbreTotalInstructionsProcedures; i< Computational.getProgramm().size(); i++)
            Computational.getProgramm().get(i).rewrite();
    }




    public void setFichierIn(String file){
        interprete.get(Commandes.IN).setFichier(file);
    }

    public void setFichierOut(String file){
        interprete.get(Commandes.OUT).setFichier(file);
    }

}
















