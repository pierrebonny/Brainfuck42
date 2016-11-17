import java.awt.*;

/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */


public interface Computational {
    Memory memory = new Memory();

    public void execute();

    public void rewrite();

    public Color translate();

    public void Check();

}
