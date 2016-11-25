

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */


public abstract class Computational {

	private static List<Computational> programm= new ArrayList<>();
	private static  long EXEC_TIME;
	private static  int PROG_SIZE;
	private static int EXEC_MOVE;
	private  static int DATA_MOVE;
	private static int DATA_READ;
	private static int DATA_WRITE;
	protected Memory memory;
	protected String courteSyntaxe;
	protected Color couleur;

	public Computational(Memory memory){ this.memory=memory;}

    public void execute() { EXEC_MOVE++;}

    public abstract void rewrite();

    public abstract Color translate();

    public abstract void Check();

	public abstract void setFichier(String s);

    public abstract void closeFichier();

	public static int getProgSize(){ return  PROG_SIZE;}
	public static long getExecMove(){ return  EXEC_MOVE;}
	public static int getDataMove(){ return  DATA_MOVE;}
	public static int getDataRead(){ return DATA_READ;}
	public static int getDataWrite() {return DATA_WRITE;}
	public static List<Computational> getProgramm(){ return programm;}
	public static long getExecTime(){return EXEC_TIME;}

	public static void incrProgSize(){ PROG_SIZE++;}
	public static void incrExecMove(){ EXEC_MOVE++;}
	public static void incrDataMove(){DATA_MOVE++;}
	public static void incrDataRead(){DATA_READ++;}
	public static void incrDataWrite(){ DATA_WRITE++;}
	public static void setProgSize(int progSize){ PROG_SIZE=progSize;}
	public static void setExecTime(long execTime){ EXEC_TIME=execTime;}




}

