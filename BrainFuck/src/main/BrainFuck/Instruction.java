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


public abstract class Instruction extends Computational {


	protected String courteSyntaxe;
	protected Color couleur;

	public Instruction(Memory memory){
		super(memory);
		trace=new Trace(memory);
	}

	public void execute() {
		Metrics.incrExecMove();
		if (trace.getFile() != null)
			trace.updateFichierLog();
	}

	public abstract Color translate();
	public abstract void setFichier(String s);
	public abstract void closeFichier();




}

