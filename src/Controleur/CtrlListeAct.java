package Controleur;

import Modele.Event;
import java.util.Vector;

public class CtrlListeAct {

	private Vector<Event> listeA;
	
	public CtrlListeAct()
	{
		this.listeA = new Vector<Event>();
		
	}
	
	public void addAct( Event e)
	{
		this.listeA.add(e);
	}
	
	public void removeAct( Event e)
	{
		this.listeA.remove(e);
	}

	public int getNbActivites()
	{
		return this.listeA.size();
	}
	
	public Vector<Event> getListeActivites()
	{
		return this.listeA;
	}
}
