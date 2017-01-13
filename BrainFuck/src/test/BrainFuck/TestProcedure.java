package BrainFuck;

import BrainFuck.Instructions.Decr;
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
public class TestProcedure {

    private Memory memory;
    private Procedure procedure;

    @Before
    public void init(){
        memory = new Memory();

    }

    @Test
    public void testFunction(){
        procedure = new Procedure(memory,1,"+++++>>>>>","Procedure");

        ArrayList<Computational> list= procedure.getListeInst();
        ArrayList<Computational> list2= new ArrayList<>();
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Incr(memory));
        list2.add(new Right(memory));
        list2.add(new Right(memory));
        list2.add(new Right(memory));
        list2.add(new Right(memory));
        list2.add(new Right(memory));

        for(int i=0;i<list2.size();i++)
            assertNotEquals(list2.get(i),list.get(i));

        assertEquals(procedure.name,"Procedure");
        assertTrue(procedure.nbRepetition==1);
        assertTrue(procedure.pointeurMemoire==-1);
        assertEquals(procedure.chaineInstructions,"+++++>>>>>");

        Computational.getProgramm().clear();

    }
}
