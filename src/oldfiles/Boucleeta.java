<<<<<<< HEAD:src/oldFile/Boucleeta.java
=======


import main.Computational;

>>>>>>> 5d7d5924b154f9440a011ddf357d10970f28e9e8:src/oldfiles/Boucleeta.java
import java.util.ArrayList;
import java.util.List;

public class Loops {
    


    protected static  boolean read=true;
    protected static boolean loops=false;
    protected static  boolean stock=false;
    protected static List<Character> instructions=new ArrayList<>();
    protected static int globalPositionJump;
    protected Computational computational;
    
    
    public Loops(Computational computational){ this.computational=computational; }
    
    
    public boolean getRead(){ return read; }
    public boolean getLoops(){ return loops; }
    public boolean getStock(){ return stock; }
    public int getGlobalPositionJump(){ return globalPositionJump; }
    public List<Character> getInstructions(){ return instructions; }

    public int backAssociated(int positionJump){
        int compteur=1;
        int positionBack=0;
        for(int i=positionJump+1; i<instructions.size();i++){
            if(instructions.get(i)=='['){
                compteur++;
            } else if(instructions.get(i)==']'){
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
            if(instructions.get(i)=='['){
                compteur--;
                if(compteur==0){
                    positionJump=i;
                    return positionJump;
                }
            } else if(instructions.get(i)==']'){
                compteur++;
            }
        }
        return -1;
    }   
    
    
}



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



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Back extends Loops {
    
    
    private main.Jump jump;
    
    
    public Back(Computational computational, main.Jump jump){
        super(computational);
        this.jump=jump;
    }
    
    public main.Jump getJump(){ return jump;}
    
    public void back(){
        try{
            back(instructions.size()-1);
        }
        catch(IOException e){
        }
    }
    
    public void back(int positionBack) throws IOException{ // back de cloture entre le tout premier [ et le dernier ]
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
