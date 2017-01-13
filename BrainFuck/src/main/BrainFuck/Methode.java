package BrainFuck;

import java.awt.*;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by thiba on 04/01/2017.
 */
public abstract class Methode extends Computational {

    //Nom de la méthode
    protected String name;

    //Nombre de fois que l'on repete la chaine répresntant la méthode lors de la definitions :
    protected int nbRepetition;

    //String representant les instructions passées lors de la création
    protected String chaineInstructions;

    //Position/Indice du début des instructions de la procédure dans la liste des BrainFuck.Instructions du programme
    protected int positionDebListeProg;

    //Position/Indice de fin des instructions de la procédure dans la liste des BrainFuck.Instructions du programme
    protected int positionFinListeProg;


    //Pointeur sur la cellule mémoire parametre, -1 si cellule mémoire par défaut
    protected int pointeurMemoire=-1;

    //Liste d'instructions de la procédure
    protected ArrayList<Computational> instructions=new ArrayList<>();


    //Attribut commun pour toutes les objets functions, procedures :

    //Nombre total d'instructions DEFINISANT  toutes les procédures  et fonctions: variable servant à initialiser le pointeur d'execution lors de l'execution de la liste d'intruction du programme
    protected static int nbreTotalInstructionsProceduresFonctions;




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

    }



    public Methode(Memory memory,Methode methode,int pointeurMémoire,String name){
        super(memory);
        this.nbRepetition = methode.nbRepetition;
        this.name = name;
        this.chaineInstructions = methode.chaineInstructions;
        this.positionDebListeProg = methode.positionDebListeProg;
        this.positionFinListeProg = methode.positionFinListeProg;
        this.pointeurMemoire = pointeurMémoire;
        this.instructions = methode.instructions;
    }



    public abstract void execute();

    public abstract void rewrite();



    public  void setFichier(String s){}
    public  void closeFichier(){}




    public ArrayList<Computational> getListeInst(){
        return instructions;
    }
    public String getCourteSyntaxe(){return("");}
    public int generateCode(int counter, FileWriter writer, Boolean finish, Boolean loop){
        return 0;
    }
}
