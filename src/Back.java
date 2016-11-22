import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Back extends Loops implements Computational {
    
    private String courteSyntaxe="]";
    private Color couleur=new Color(255, 0, 0);
    private int posBackAssocie;
    private List<Computational> computationalContent= new ArrayList<Computational>();

    public Back(Memory memory){
        super(memory);

    }
    
    public void execute(){
        try{
            back(instructions.size()-1);
        }
        catch(IOException e){
        }
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public void Check(){}
    public void setFichier(String s){}



        
    public void back(int positionBack) throws IOException{ // back de cloture entre le tout premier [ et le dernier ]
        if(loops==false){ 
            stock=false;
            read=true;
            instructions.clear();

        } else if(loops==true) {
            stock=false;
            read=true;
            while(memory.getMemory()!=0){
                for(int i=(jumpAssociated(positionBack)+1);i<=positionBack-1;i++){ //utilise lautre back qui prend en parametre la position de la liste
                    if(read){
                        interpretec(instructions.get(i));
                        if(read==false){
                            globalPositionJump=i;
                        }
                    }
                    if(instructions.get(i)==']' && read==true ){
                        back(i);
                    }
                    if(instructions.get(i)==']' && i==backAssociated(globalPositionJump)){
                        read=true;
                    }
                }      

            }
            if(positionBack==instructions.size()-1){
                instructions.clear();
                loops=false;
            }


        }
    }
    
    
    
    
    public void interpretec(char c) throws IOException{
        switch (c){
             case '+':
                new Incr(memory).execute();
                break;
            case '-':
                new Decr(memory).execute();
                break;
            case '<':
                new Left(memory).execute();
                break;
            case '>':
                new Right(memory).execute();
                break;
            case '.':
                new Out(memory).execute();
                break;
            case ',':
                new In(memory).execute();
                break;
            case '[':
                new Jump(memory).execute();
                break;
            default :
                break;
        }
    }

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
