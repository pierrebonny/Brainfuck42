package BrainFuck;

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



    public void metrics(){
        Metrics.setProgSize(Instruction.getProgramm().size());
        System.out.println("\nMetrics :");
        System.out.println("PROG_SIZE : " + Metrics.getProgSize());
        System.out.println("EXEC_MOVE : " + Metrics.getExecMove());
        System.out.println("DATA_READ : " + Metrics.getDataRead());
        System.out.println("DATA_WRITE : " + Metrics.getDataWrite());
        System.out.println("DATA_MOVE : " + Metrics.getDataMove());
        System.out.println("EXEC_TIME : " + Metrics.getExecTime() +" milliseconds");
    }

    /*
Affiche les cellules non nulles
 */
    public void afficher(){
        System.out.println("------------------------------Fin execution du fichier--------------------------------------------------------\n");
        System.out.println("Mémoire : ");
        for(int i = 0 ; i <= memory.getMax() ; i++){
            if(memory.getMemoryIndex(i)!= 0)
                System.out.println(memory.toString(i));
        }
    }
  
        
}

