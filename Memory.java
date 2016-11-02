
/**
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe gere la memoire sous forme d'un tableau d'entiers, representant les bytes, de taille 30 000.
 */



public class Memory {

    public static final int SIZE_MEMORY=30000;
    private int memoryCells[];
    private int position;//position de la case memoire en cours de lecture.
    private int max; //position maximale qui a été lue.

    public Memory(){
        memoryCells = new int[SIZE_MEMORY];
        position = 0;
        max = 0;
    }

    //methodes pour obtenir, changer via indice la cellule memoire actuellement pointee (valeur de l'indice du tableau)

    public int getMemory(){

        return memoryCells[position];
    }

    public int getMemoryIndex(int index){

        return memoryCells[index];
    }

    public void setMemory(int newMemory){

        memoryCells[position] = newMemory;
    }

    // methodes pour obtenir, changer la position du pointeur (indice du tableau)

    public int getPosition(){

        return position;
    }

    public void setPosition(int newPosition){

        position = newPosition;
    }

    //methodes pour obtenir, changer le max

    public int getMax(){

        return max;
    }

    public void setMax(int newMax){

        max = newMax;
    }

    public String toString(int index){
        return "C"+index+": "+getMemoryIndex(index);
    }
    
    public String toString(){
        return "C"+getPosition()+": "+getMemory();
    }
    
   

}

