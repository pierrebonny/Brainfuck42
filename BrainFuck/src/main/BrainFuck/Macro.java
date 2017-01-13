package BrainFuck;

import java.util.ArrayList;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Macro{

    private ArrayList<Instruction> instructions=new ArrayList<>();


    public Macro(int nbInst,String chaine){

        ArrayList<Instruction> premieres=contenuMacro(chaine);
        for(int i=0;i<nbInst;i++){
            instructions.addAll(premieres);
        }
    }


    public ArrayList<Instruction> contenuMacro(String chaine){
        ArrayList<Instruction> list=new ArrayList<>();
        if (Interpreter.macros.get(chaine) != null) {
            list.addAll(Interpreter.macros.get(chaine).getListeInst());
        }else{

            for(int y=0;y<chaine.length();y++){
                for(Commandes c : Commandes.values()){
                    if(c.getCourte()==chaine.charAt(y)) {
                        list.add(Interpreter.interprete.get(c));
                    }
                }
            }
        }
        return list;
    }

    public void addInstructions(int number){
        for(int i=0;i<number;i++){
            Computational.getProgramm().addAll(this.instructions);
        }
    }

    public ArrayList<Instruction> getListeInst(){
        return instructions;
    }

}
