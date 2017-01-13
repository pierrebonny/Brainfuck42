package BrainFuck;

import BrainFuck.Instructions.Decr;
import BrainFuck.Instructions.In;
import BrainFuck.Instructions.Incr;
import BrainFuck.Instructions.Right;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Pierre on 13/01/2017.
 */
public class TestFunction {

    private Memory memory;
    private Function function;

    @Before
    public void init(){
        memory = new Memory();

    }

    @Test
    public void testFunction(){
        function = new Function(memory,2,"+++->>+","Function");

        ArrayList<Computational> list= function.getListeInst();
        ArrayList<Computational> list2= new ArrayList<>();
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Decr(memory));
        list2.add(new Right(memory));
        list2.add(new Right(memory));
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Decr(memory));
        list2.add(new Right(memory));
        list2.add(new Right(memory));
        list2.add(new Incr(memory));

        for(int i=0;i<list2.size();i++)
            assertNotEquals(list2.get(i),list.get(i));

        assertEquals(function.name,"Function");
        assertTrue(function.nbRepetition==2);
        assertTrue(function.pointeurMemoire==-1);
        assertEquals(function.chaineInstructions,"+++->>+");

        Computational.getProgramm().clear();

    }
}
