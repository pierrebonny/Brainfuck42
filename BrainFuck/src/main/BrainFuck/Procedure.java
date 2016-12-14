package BrainFuck;

import BrainFuck.Instructions.Incr;
import BrainFuck.Instructions.Out;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Pierre on 12/12/2016.
 */
public class Procedure extends Computational{

    public static int nbreTotalProcUtilise=0;
    public static int nbreProcedures=Interpreter.procedures.size();
    public static int nbreTotalInstructionsProcedures;
    private int nbUtilisation=0;
    private int nbreInstrProc;

    public int positionDebListeProg;
    public int positionFinListeProg;

    private ArrayList<Instruction> instructions=new ArrayList<>();



    public Procedure(Memory memory,int nbRepetition,String chaine){
        super(memory);

        ArrayList<Instruction> premieres=new ArrayList<>();


        if (Interpreter.procedures.get(chaine) != null) {
            System.out.println(nbRepetition);
            System.out.println(chaine);
            Procedure procedure =Interpreter.procedures.get(chaine);
            premieres.addAll(procedure.getListeInst());
        }else{
            for(int y=0;y<chaine.length();y++){
                for(Commandes c : Commandes.values()){
                    if(c.getCourte()==chaine.charAt(y)) {
                        premieres.add(Interpreter.interprete.get(c));
                    }
                }
            }
        }

        for(int i=0;i<nbRepetition;i++){
            instructions.addAll(premieres);
        }

        this.positionDebListeProg=getProgramm().size();
        this.getProgramm().addAll(instructions);
        this.positionFinListeProg=getProgramm().size()-1;
        this.nbreTotalInstructionsProcedures+=instructions.size();
        this.nbreInstrProc=instructions.size();


    }

    public int nbreInstrInProg(){
        return nbreInstrProc*nbUtilisation;
    }


    public  void execute(){
        int tmp=locationExcecutionPointer;
        for(locationExcecutionPointer=positionDebListeProg;locationExcecutionPointer<=positionFinListeProg;locationExcecutionPointer++){
            getProgramm().get(locationExcecutionPointer).execute();
        }
        locationExcecutionPointer=tmp;

    }
    public  void rewrite() {
        int tmp=locationExcecutionPointer;
        for(locationExcecutionPointer=positionDebListeProg;locationExcecutionPointer<=positionFinListeProg;locationExcecutionPointer++){
            getProgramm().get(locationExcecutionPointer).rewrite();
        }
        locationExcecutionPointer=tmp;
    }

    public  Color translate() { /*//PB AVEC CETTE METHODE
        int tmp = locationExcecutionPointer;
        for (int locationExcecutionPointer = positionDebListeProg; locationExcecutionPointer <= positionFinListeProg; locationExcecutionPointer++)
            return getProgramm().get(locationExcecutionPointer).translate();
            */
    return new Color(4);
    }

    public  void setFichier(String s){}
    public  void closeFichier(){}

    public int getNbreInstrProc(){ return nbreInstrProc;}
    public int getNbUtilisation() { return nbUtilisation;}
    public void incrNbUtilisation(){ nbUtilisation++;}
    public ArrayList<Instruction> getListeInst(){
        return instructions;
    }



}
