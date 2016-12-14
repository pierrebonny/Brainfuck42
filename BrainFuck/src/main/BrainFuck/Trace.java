package BrainFuck;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Pierre on 01/12/2016.
 */
public class Trace {

    private Memory memory;
    public static String contenuFichierLog="";
    public static String file=null;

    public Trace(Memory memory){
        this.memory=memory;
    }

    public  void trace() {
        BufferedWriter ecrireFichier;
        try {
            ecrireFichier = new BufferedWriter(new FileWriter(new File(file)));
            ecrireFichier.write(contenuFichierLog);
            ecrireFichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateFichierLog(){
        contenuFichierLog+="Exec pointer :" + Metrics.getExecMove() + "		Location exec  "+(Instruction.locationExcecutionPointer+1)+	"	Position M:" + memory.getPosition() + "		Value M :" + memory.getMemory()+"\n";
    }

    public String getFile(){ return file;}
    public String getContenuFichierLog(){ return contenuFichierLog;}
    public static void setFile(String newfile){
        int position=newfile.lastIndexOf('.');
        file=newfile.substring(0,position)+".log";
    }
}
