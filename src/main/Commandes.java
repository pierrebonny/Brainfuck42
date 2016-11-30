package BrainFuck;
import java.awt.*;
/**
 * Created by Pierre on 16/11/2016.
 */
public enum Commandes {

    INCR("INCR",'+',"FFFFFFFF"),
    DECR("DECR",'-',"FF4B0082"),
    LEFT("LEFT",'<',"FF9400D3"),
    RIGHT("RIGHT",'>',"FF0000FF"),
    OUT("OUT",'.',"FF00FF00"),
    IN("IN",',',"FFFFFF00"),
    JUMP("JUMP",'[',"FFFF7F00"),
    BACK("BACK",']',"FFFF0000");

    private String longue = "";
    private char courte = ' ';
    private String hexa = "";

    Commandes (String longue, char courte, String hexa){
        this.longue = longue;
        this.courte = courte;
        this.hexa = hexa;
    }

    public String getLongue(){
        return longue;
    }

    public char getCourte(){
        return courte;
    }

    public Color getColor(){
        return hexatoColor(hexa);
    }

    public String getHexa(){
        return hexa;
    }

    private static Color hexatoColor(String hexa) {
    return new Color(
            Integer.valueOf( hexa.substring( 1, 3 ), 16 ),
            Integer.valueOf( hexa.substring( 3, 5 ), 16 ),
            Integer.valueOf( hexa.substring( 5, 7 ), 16 ) );
    }

    public Commandes findLongue(String l){
        for(Commandes c : Commandes.values()){
            if(c.longue.equals(l)) return c;            
        }
        return null;
    }

    public Commandes findCourte(char co){
        for(Commandes c : Commandes.values()){
            if(c.courte==co){
                return c;   
            }         
        }
        return null;
    }

    public Commandes findColor(String couleur){
        for(Commandes c : Commandes.values()){
            if(c.hexa==couleur) return c;            
        }
         return null;
    }
}

