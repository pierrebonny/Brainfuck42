
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.*;
/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */


public class Computational {

    public static final int MAX_POSITION=29999;
    public static final int MIN_POSITION=0;
    public static final int MAX_VALUE=255;
    public static final int MIN_VALUE=0;
    private  Scanner sc = new Scanner(System.in);
    private Memory memory;


    public Computational(Memory memory){

        this.memory=memory;
    }

    /*
    Incremente la valeur en cours de lecture
     */
    public void incr(){
        if(memory.getMemory()==MAX_VALUE){
            System.out.println("Error 1");
            System.exit(1);
        }
        else{
            memory.setMemory(memory.getMemory()+1);
        }
    }

    /*
    Decremente la valeur en cours de lecture
     */

    public void decr(){
        if(memory.getMemory()==MIN_VALUE){
            System.out.println("Error 1");
            System.exit(1);
        }
        else{
            memory.setMemory(memory.getMemory()-1);
        }
    }

    /*
    Incremente l'indice du tableau correspondant a la position memoire
     */
    public void right(){
        if(memory.getPosition()==MAX_POSITION){
            System.out.println("Error 2");
            System.exit(2);
        }
        else{
            memory.setPosition(memory.getPosition()+1);

            if(memory.getPosition()>memory.getMax()) memory.setMax(memory.getPosition());
        }
    }

    /*
    Decremente l'indice du tableau correspondant a la position memoire
     */

    public void left(){
        if(memory.getPosition()==MIN_POSITION){
            System.out.println("Error 2");
            System.exit(2);
        }
        else{
            memory.setPosition(memory.getPosition()-1);
        }
    }

    public void out(BufferedWriter fichierOut) throws IOException{
        if(fichierOut!=null){
            fichierOut.write(memory.getStringMemory());
        }
        else
            System.out.println(memory);
    }

    public void in(BufferedReader fichierIn) throws IOException{
        int val;
        if(fichierIn!=null){
            val=fichierIn.read();
            if(val==-1)
                val=sc.nextLine().charAt(0);
            memory.setMemory(val);
        }
        else{
        val=sc.nextLine().charAt(0);
            memory.setMemory(val);
        }
 
    }
    
    public Memory getObjectMemory(){ return memory;}
}