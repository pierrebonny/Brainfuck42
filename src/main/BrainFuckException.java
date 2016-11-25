public class BrainFuckException extends RuntimeException {


    public BrainFuckException(String message,int number){
        System.err.println(message);
        printStackTrace();
        System.exit(number);
    }
}