package BrainFuck.Exception;

/**
 * Created by Pierre on 25/11/2016.
 */
public class BrainFuckException extends RuntimeException {

    private String message;
    private int number;

    public BrainFuckException(String message,int number){
        this.message=message;
        this.number=number;
        printStackTrace();

    }

    public void erreur(){
        System.err.println(message);
        System.exit(number);
    }
    public String getMessage(){return message;}
}
