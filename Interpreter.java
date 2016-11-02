
/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */

public class Interpreter{
	private Computational computational;


	public Interpreter(Computational computational){
		this.computational=computational;
	}

	public void interprete(String line){
            switch (line) {
                case "INCR":
                    computational.incr();
                    break;

                case "DECR":
                    computational.decr();
                    break;

                case "RIGHT":
                    computational.right();
                    break;

                case "LEFT":
                    computational.left();
                    break;

                default:{
                	int size=line.length();
                	for(int i=0;i<size;i++){
                		char c=line.charAt(i);
                		switch (c){
                			case '+':
                				computational.incr();
                				break;
                			case '-':
                				computational.decr();
                				break;
                			case '<':
                				computational.left();
                				break;
                			case '>':
                				computational.right();
                				break;
                			default :
                				break;
                		}
                	}
                	break;
               }
            }
	}
	
}
