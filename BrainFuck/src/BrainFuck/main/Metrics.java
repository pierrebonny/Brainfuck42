package BrainFuck;

/**
 * Created by Pierre on 01/12/2016.
 */
public  class Metrics {


    private static  long EXEC_TIME;
    private static  int PROG_SIZE;
    private static int EXEC_MOVE;
    private  static int DATA_MOVE;
    private static int DATA_READ;
    private static int DATA_WRITE;


    public static long getExecTime(){return EXEC_TIME;}
    public static int getProgSize(){ return  PROG_SIZE;}
    public static long getExecMove(){ return  EXEC_MOVE;}
    public static int getDataMove(){ return  DATA_MOVE;}
    public static int getDataRead(){ return DATA_READ;}
    public static int getDataWrite() {return DATA_WRITE;}

    public static void incrProgSize(){ PROG_SIZE++;}
    public static void incrDataMove(){DATA_MOVE++;}
    public static void incrDataRead(){DATA_READ++;}
    public static void incrDataWrite(){ DATA_WRITE++;}
    public static void incrExecMove(){ EXEC_MOVE++;}

    public static void setProgSize(int progSize){ PROG_SIZE=progSize;}
    public static void setExecTime(long execTime){ EXEC_TIME=execTime;}
}
