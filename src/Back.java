

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Back extends Loops {
    
    
    private Jump jump;
    
    
    public Back(Computational computational,Jump jump){
        super(computational);
        this.jump=jump;
    }
    
    public Jump getJump(){ return jump;}
    
    
    public void back(int positionBack,BufferedReader fichierIn,BufferedWriter fichierOut) throws IOException{ // back de cloture entre le tout premier [ et le dernier ]
        if(loops==false){ 
            stock=false;
            read=true;
            instructions.clear();

        } else if(loops==true) {
            stock=false;
            read=true;
            while(this.computational.getObjectMemory().getMemory()!=0){
                for(int i=(jumpAssociated(positionBack)+1);i<=positionBack-1;i++){ //utilise lautre back qui prend en parametre la position de la liste
                    if(read){
                        interpretec(instructions.get(i) , fichierIn , fichierOut);
                        if(read==false){
                            globalPositionJump=i;
                        }
                    }
                    if(instructions.get(i)==']' && read==true ){
                        back(i,fichierIn,fichierOut);
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
    
    
    
    
    public void interpretec(char c,BufferedReader fichierIn,BufferedWriter fichierOut) throws IOException{
        switch (c){
             case '+':
                computational.incr();
                break;
            case '-':
                computational.decr();
                break;
            case '<':
                computational.left();
                break;
            case '>':
                computational.right();
                break;
            case '.':
                computational.out(fichierOut);
                break;
            case ',':
                computational.in(fichierIn);
                break;
            case '[':
                jump.jump();
                break;
            default :
                break;
        }
    }



}
