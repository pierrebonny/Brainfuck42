package BrainFuck.Instructions;
import BrainFuck.*;



import java.util.ArrayList;
import java.util.List;

public abstract class Loops extends Computational {
    



    
    
    public Loops(Memory memory){ super(memory); }

    public void execute(){
        Metrics.incrDataRead();
        super.execute();
    }
    





    public int backAssociated(int positionJump){
        int compteur=1;
        int positionBack=0;
        for(int i=positionJump+1; i<Computational.getProgramm().size();i++){
            if(Computational.getProgramm().get(i) instanceof  Jump){
                compteur++;
            } else if(Computational.getProgramm().get(i) instanceof  Back){
                compteur--;
                if(compteur==0){
                    positionBack=i;
                    return positionBack;
                }
            }
        }
        return -1;
    }
    
    public int jumpAssociated(int positionBack){ 
        int compteur=1;
        int positionJump=0;
        for(int i=(positionBack-1); i>=0;i--){
            if(Computational.getProgramm().get(i) instanceof Jump){
                compteur--;
                if(compteur==0){
                    positionJump=i;
                    return positionJump;
                }
            } else if(Computational.getProgramm().get(i) instanceof  Back){
                compteur++;
            }
        }
        return -1;
    }   
    
    
}
