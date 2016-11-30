package BrainFuck;
import BrainFuck.Instructions.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    protected Map<Commandes,Computational> interprete = new HashMap<>();
    private Commandes commandes;


    public Interpreter(Output output,Memory memory){
        this.output=output;
        this.memory = memory;
        loops =new Back(memory);
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
        for (Commandes com : Commandes.values()) {
            if (com.getLongue().equals(line)) {
                Computational.getProgramm().add(interprete.get(com));
                return ;
            }
        }
        int size = line.length();
        for (int i = 0; i < size; i++) {
            char c = line.charAt(i);
            for (Commandes com : Commandes.values()) {
                if(c=='#')
                    return ;
                if (com.getCourte() == c)
                    Computational.getProgramm().add(interprete.get(com));
            }
        }
    }

    public void interprete() {
        for (Computational.locationExcecutionPointer = 0; Computational.locationExcecutionPointer < Computational.getProgramm().size(); Computational.locationExcecutionPointer++)
            Computational.getProgramm().get(Computational.locationExcecutionPointer).execute();
    }


    public void rewriteFile(String line) {
        boolean exe=false;
        for(Commandes com : Commandes.values()){

            if(com.getLongue().equals(line)){
                interprete.get(com).rewrite();
                exe=true;
            }
        }
        if(!exe)
            System.out.print(line);
    }

    public void rewriteImg(String hexa){
        //System.out.println(hexa);
        for(Commandes com: Commandes.values())
            if(com.getHexa().equals(hexa))
                interprete.get(com).rewrite();
    }


    public void setFichierIn(String file){
        interprete.get(Commandes.IN).setFichier(file);
    }

    public void setFichierOut(String file){
        interprete.get(Commandes.OUT).setFichier(file);
    }

}








