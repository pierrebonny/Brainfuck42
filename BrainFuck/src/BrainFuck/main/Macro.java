package BrainFuck;
import BrainFuck.Commandes;
import BrainFuck.Instructions.Computational;
import BrainFuck.Interpreter;

import java.util.ArrayList;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Macro{

    private ArrayList<Computational> instructions=new ArrayList<>();


    public Macro(int nbInst,String chaine){

        ArrayList<Computational> premieres=new ArrayList<>();


        if (Interpreter.macros.get(chaine) != null) {
                premieres.addAll(Interpreter.macros.get(chaine).getListeInst());
        }else{

            for(int y=0;y<chaine.length();y++){
                for(Commandes c : Commandes.values()){
                    if(c.getCourte()==chaine.charAt(y)) {
                        premieres.add(Interpreter.interprete.get(c));
                    }
                }
            }
        }
        
        for(int i=0;i<nbInst;i++){
            instructions.addAll(premieres);
        }
    }


    public ArrayList<Computational> getListeInst(){
        return instructions;
    }
}
