package BrainFuck.Exception;

/**
 * Created by Pierre on 07/12/2016.
 */
public class InvalidColorException extends BrainFuckException {

    public InvalidColorException(String message,int number){
        super(message,number);
    }
}
