package BrainFuck;


import BrainFuck.Instructions.Back;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Cette classe réalise les traitements sur le tableau
 */


public abstract class Computational {

	public static int locationExcecutionPointer;
	private static List<Computational> programm= new ArrayList<>();
	protected Memory memory;
	protected Trace trace;
	protected String courteSyntaxe;
	protected Color couleur;

	public Computational(Memory memory){
		this.memory=memory;
		trace=new Trace(memory);
	}

    public void execute() {
		Metrics.incrExecMove();
		if (trace.getFile() != null){
			trace.updateFichierLog();
				if(this.endOfExecution())
					trace.trace();

		}
	}





    public abstract void rewrite();

    public abstract Color translate();

    public abstract void Check();

	public abstract void setFichier(String s);

    public abstract void closeFichier();


	public static List<Computational> getProgramm(){ return programm;}



	public boolean endOfExecution(){
		if ((locationExcecutionPointer==programm.size()-1)&&((programm.get(programm.size() - 1) instanceof Back && memory.getMemory() == 0)||!(programm.get(programm.size() - 1) instanceof Back)))
			return true;
		return false;
	}

}

