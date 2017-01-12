package BrainFuck;

import java.awt.*;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by thiba on 04/01/2017.
 */
public abstract class Methode extends Computational {


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

    //Nombre total d'instructions DEFINISANT  toutes les procédures  et fonctions: variable servant à initialiser le pointeur d'execution lors de l'execution de la liste d'intruction du programme
    public static int nbreTotalInstructionsProceduresFonctions;



    //Liste d'instructions de la procédure
    public ArrayList<Computational> instructions=new ArrayList<>();

    public String name;

    public Methode(Memory memory,int nbRepetition,String chaine,String name) {
        super(memory);
        this.nbRepetition=nbRepetition;
        this.name = name;
        this.chaineInstructions=chaine;

        ArrayList<Computational> premieres=new ArrayList<>();


        if (Interpreter.procedures.get(chaine) != null) {
            Procedure procedure =Interpreter.procedures.get(chaine);
            premieres.addAll(( procedure.getListeInst()));
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
        this.nbreTotalInstructionsProceduresFonctions+=instructions.size();
        this.nbreInstrProc=instructions.size();
    }



    public Methode(Memory memory,Methode methode,int pointeurMémoire,String name){
        super(memory);
        this.nbRepetition = methode.nbRepetition;
        this.name = name;
        this.chaineInstructions = methode.chaineInstructions;
        this.positionDebListeProg = methode.positionDebListeProg;
        this.positionFinListeProg = methode.positionFinListeProg;
        this.nbreInstrProc = methode.nbreInstrProc;
        this.pointeurMemoire = pointeurMémoire;
        this.instructions = methode.instructions;
        methode.nbUtilisation++;
        nbreTotalProcUtilise++;
    }



    public abstract void execute();

    public abstract void rewrite();

    public  Color translate() { /*//PB AVEC CETTE METHODE
        int tmp = locationExcecutionPointer;
        for (int locationExcecutionPointer = positionDebListeProg; locationExcecutionPointer <= positionFinListeProg; locationExcecutionPointer++)
            return getProgramm().get(locationExcecutionPointer).translate();
            */
        return new Color(4);
    }

    public  void setFichier(String s){}
    public  void closeFichier(){}

    public int nbreInstrInProg(){
        return nbreInstrProc*nbUtilisation;
    }
    public int getNbreInstrProc(){ return nbreInstrProc;}
    public int getNbUtilisation() { return nbUtilisation;}
    public void incrNbUtilisation(){ nbUtilisation++;}
    public ArrayList<Computational> getListeInst(){
        return instructions;
    }
    public String getCourteSyntaxe(){return("");}
    public int generateCode(int counter, FileWriter writer, Boolean finish, Boolean loop){
        return 0;
    }
}
