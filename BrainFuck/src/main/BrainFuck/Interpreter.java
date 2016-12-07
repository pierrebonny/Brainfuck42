package BrainFuck;
import BrainFuck.Exception.OutofBoundException;
import BrainFuck.Exception.OverFlowException;
import BrainFuck.Exception.UnderFlowException;
import BrainFuck.Instructions.*;


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
    private Back loops;
    protected static Map<Commandes,Computational> interprete = new HashMap<>();
    protected static Map<String,Macro> macros= new HashMap<>();
    private Commandes commandes;


    public Interpreter(Output output,Memory memory){
        this.output = output;
        this.memory = memory;
        loops = new Back(memory);
        fillHashmap(interprete);
    }

    private void fillHashmap(Map<Commandes,Computational> hashmap) {
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
                if (com.getLongue().equals(syntlong.toString())) {
                    Computational.getProgramm().add(interprete.get(com));
                }
            }
            if (macros.get(line) != null) {
                Computational.getProgramm().addAll(macros.get(line).getListeInst());
            }
        }
    }

    public void createMacro(String line){
        String [] macroDef=line.split(" ");
        macros.put(macroDef[1],new Macro(Integer.parseInt(macroDef[2]),macroDef[3]));
    }

    public void interprete() throws OutofBoundException,OverFlowException,UnderFlowException{
        for (Computational.locationExcecutionPointer = 0; Computational.locationExcecutionPointer < Computational.getProgramm().size(); Computational.locationExcecutionPointer++)
            Computational.getProgramm().get(Computational.locationExcecutionPointer).execute();
        output.afficher();
        output.metrics();
    }

    public void rewrite(){
        for(int i=0;i<Computational.getProgramm().size();i++)
            Computational.getProgramm().get(i).rewrite();
    }




    public void setFichierIn(String file){
        interprete.get(Commandes.IN).setFichier(file);
    }

    public void setFichierOut(String file){
        interprete.get(Commandes.OUT).setFichier(file);
    }

}








