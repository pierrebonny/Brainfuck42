

/**
 * Created by Pierre on 25/11/2016.
 */
public class BrainFuckException extends RuntimeException {


    public BrainFuckException(String message,int number){
        System.err.println(message);
        printStackTrace();
        System.exit(number);
    }
}
