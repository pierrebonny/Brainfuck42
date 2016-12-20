package BrainFuck;

import BrainFuck.Instructions.Incr;
import BrainFuck.Instructions.Out;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Pierre on 12/12/2016.
 */
public class Procedure extends Computational{

    //Attribut propre à la à l'objet :
    public int nbRepetition;
    public String chaineInstructions;

    //Position/Indice du début des instructions de la procédure dans la liste des Instructions du programme
    public int positionDebListeProg;

    //Position/Indice de fin des instructions de la procédure dans la liste des Instructions du programme
    public int positionFinListeProg;

    //Nombre de fois que la procédure est utilisée
    public int nbUtilisation=0;
    //Nombre d'instructions de la procédure
    public int nbreInstrProc;

    //Pointeur sur la cellule mémoire parametre, -1 si cellule mémoire par défaut
    public int pointeurMemoire=-1;


    //Attributs global :

    //Nombre total de procédure utilisée dans le programme
    public static int nbreTotalProcUtilise=0;

    //Nombre total d'instructions DEFINISANT  toutes les procédures : variable servant à initialiser le pointeur d'execution lors de l'execution de la liste d'intruction du programme
    public static int nbreTotalInstructionsProcedures;



    //Liste d'instructions de la procédure
    public ArrayList<Instruction> instructions=new ArrayList<>();



    public Procedure(Memory memory,int nbRepetition,String chaine){
        super(memory);
        this.nbRepetition=nbRepetition;
        this.chaineInstructions=chaine;

        ArrayList<Instruction> premieres=new ArrayList<>();


        if (Interpreter.procedures.get(chaine) != null) {
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


    public Procedure(Memory memory,Procedure procedure,int pointeurMémoire){
        super(memory);
        this.nbRepetition=procedure.nbRepetition;
        this.chaineInstructions=procedure.chaineInstructions;
        this.positionDebListeProg=procedure.positionDebListeProg;
        this.positionFinListeProg=procedure.positionFinListeProg;
        this.nbreInstrProc=procedure.nbreInstrProc;
        this.pointeurMemoire=pointeurMémoire;
        this.instructions=procedure.instructions;
        procedure.nbUtilisation++;
        nbreTotalProcUtilise++;
    }

    public int nbreInstrInProg(){
        return nbreInstrProc*nbUtilisation;
    }


    public  void execute(){
        int tmp=locationExcecutionPointer;
        int currentMemory=memory.getPosition();
        if(pointeurMemoire!=-1){
            memory.setPosition(pointeurMemoire-1);
        }
        for(locationExcecutionPointer=positionDebListeProg;locationExcecutionPointer<=positionFinListeProg;locationExcecutionPointer++){
            getProgramm().get(locationExcecutionPointer).execute();
        }
        locationExcecutionPointer=tmp;
        if(pointeurMemoire!=-1)
            memory.setPosition(currentMemory);
        memory.updateMax();
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
    public String getCourteSyntaxe(){return("");}
    public int generateCode(int counter, FileWriter writer, Boolean finish, Boolean loop){
        return 0;
    }


}
