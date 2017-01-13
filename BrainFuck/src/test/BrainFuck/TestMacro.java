package BrainFuck;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by thiba on 13/01/2017.
 */
public class TestMacro {

    private Memory memory;
    private Macro macro;

    @Before
    public void init(){
        memory = new Memory();
        macro = new Macro(1,"+-<>.,");
    }

    @Test
    public void testMacro(){

        ArrayList<Instruction> list= macro.getListeInst();
        ArrayList<Commandes> list2= new ArrayList<>();
        list2.add(Commandes.INCR);
        list2.add(Commandes.DECR);
        list2.add(Commandes.LEFT);
        list2.add(Commandes.RIGHT);
        list2.add(Commandes.OUT);
        list2.add(Commandes.IN);
        for(int i=0;i<list2.size();i++)
            assertNotEquals(list2.get(i),list.get(i));
    }
}
