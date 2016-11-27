package BrainFuck.Instructions;
import BrainFuck.*;


import java.awt.Color;

public class Jump extends Loops {
    


    public Jump(Memory memory){
        super(memory);
        courteSyntaxe="[";
        couleur=new Color(255, 127, 0);
    }
    
    public void execute(){
        if(loops==false){ //on lit la premiere fois quon lit le fichier
            if(this.memory.getMemory()==0){
                read=false;
                stock=true;
            }else{
                loops=true;
                stock=true;
                read=false;
            }
        }    
        else { //loops==true , on lit ça lorsque quon le lit dans la liste
            if(this.memory.getMemory()==0)
                read=false;
            else{
                read=true; //ce qui est deja le cas normalement
            }

        }
        super.execute();
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public void Check(){}
    public void setFichier(String s){}
    public  void closeFichier(){}

}

