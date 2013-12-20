package Controleur;

import java.awt.Event;
import java.util.Vector;

import Modele.Membre;

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

	public int getNbActivite()
	{
		return this.listeA.size();
	}
	
	public Vector<Event> getListe()
	{
		return this.listeA;
	}
}
