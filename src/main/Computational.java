import java.awt.*;

/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */


public abstract class Computational {

	public static int EXEC_MOVE;
	public static int DATA_READ;
	public static int DATA_WRITE;
	public static int DATA_MOVE;
	protected Memory memory;
	protected String courteSyntaxe;
	protected Color couleur;

	public Computational(Memory memory){ this.memory=memory;}

    public void execute(){ EXEC_MOVE++;}

    public abstract void rewrite();

    public abstract Color translate();

    public abstract void Check();

	public abstract void setFichier(String s);

    public abstract void closeFichier();

}

