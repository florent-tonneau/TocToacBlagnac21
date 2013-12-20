package Controleur;

import java.util.Vector;
import Modele.Activite;


public class CtrlListeAct {

	private Vector<Activite> listeA;
	
	public CtrlListeAct()
	{
		
		this.listeA = new Vector<Activite>();
	}
	
	public void addAct( Activite e)
	{
		this.listeA.add(e);
	}
	
	public void removeAct( Activite e)
	{
		this.listeA.remove(e);
	}

	public int getNbActivites()
	{
		return this.listeA.size();
	}
	
	public Vector<Activite> getListeActivite()

	{
		return this.listeA;
	}
}
