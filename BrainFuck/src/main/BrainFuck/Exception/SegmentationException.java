package BrainFuck.Exception;

/**
 * Created by Pierre on 04/01/2017.
 */
public class SegmentationException extends BrainFuckException {
    public SegmentationException(String message,int number){
        super(message,number);
    }
}
