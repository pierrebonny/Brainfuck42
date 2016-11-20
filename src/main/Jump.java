package main;

import java.awt.Color;

public class Jump implements Computational {
    
    
    private Memory memory;
    private String courteSyntaxe="[";
    private Color couleur=new Color(255, 127, 0);
    private int posBackAssocie;
    private int nbBoucleInterne=0;

    public Jump(Memory memory){
        this.memory = memory;
    }
    
    public void execute(){
    //#CestLaMerde
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public void Check(){}
    public void setFichier(String s){}
}

    
   /* 
    public void jump(){
        if(loops==false){ //on lit la premiere fois quon lit le fichier
            if(memory.getMemory()==0){
                read=false;
                stock=true;
            }else{
                loops=true;
                stock=true;
                read=false;
            }
        }    
        else { //loops==true , on lit ça lorsque quon le lit dans la liste
            if(memory.getMemory()==0)
                read=false;
            else{
                read=true; //ce qui est deja le cas normalement
            }

        }
    }
}*/
