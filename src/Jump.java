

public class Jump extends Loops {
    
    

    
    public Jump(Computational computational){
        super(computational);
    }
    
    
    
    public void jump(){
        if(loops==false){ //on lit la premiere fois quon lit le fichier
            if(this.computational.getObjectMemory().getMemory()==0){
                read=false;
                stock=true;
            }else{
                loops=true;
                stock=true;
                read=false;
            }
        }    
        else { //loops==true , on lit ça lorsque quon le lit dans la liste
            if(this.computational.getObjectMemory().getMemory()==0)
                read=false;
            else{
                read=true; //ce qui est deja le cas normalement
            }

        }
    }
}
