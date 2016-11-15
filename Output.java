/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe s'occupe des affichages ecran pour l'utilisateur.
 */

public class Output {
    private Memory memory;

    public Output (Memory memory){
        this.memory = memory;
    }

    
    /*
    Affiche les cellules non nulles
     */

    public void afficher(){

        for(int i = 0 ; i <= memory.getMax() ; i++){
            if(memory.getMemoryIndex(i)!= 0)
                System.out.println(memory.toString(i));
        }
    }
}