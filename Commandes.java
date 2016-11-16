/**
 * Created by Pierre on 16/11/2016.
 */
public enum Commandes {

    INCR("INCR",'+',"FFFFFF"),
    DECR("DECR",'-',"4B0082"),
    LEFT("LEFT",'<',"9400D3"),
    RIGHT("RIGHT",'>',"0000FF"),
    OUT("OUT",'.',"00FF00"),
    IN("IN",',',"FFFF00");

    private String longue = "";
    private char courte = ' ';
    private String hexa = "";

    Commandes (String longue, char courte, String hexa){
        this.longue = longue;
        this.courte = courte;
        this.hexa = hexa;
    }

}
