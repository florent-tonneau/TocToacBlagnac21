package Controleur;

import java.util.Vector;
import Modele.Activite;
import Modele.Membre;
import Vue.VueMembre;


public class CtrlListeAct {

	private Vector<Activite> listeA;
	private VueMembre vm;
	
	
	public CtrlListeAct()
	{
		this.listeA=new Vector<Activite>();
		
		Vector<Membre> membre = new Vector<Membre>();
		membre.add(new Membre(1,"John"));
		membre.add(new Membre(2,"Paul"));
		Activite a1= new Activite("Event","21/21/21","18h",membre );
		
		this.addAct(a1);		
	}
	
	public void demarrerControleur(){
		this.vm = new VueMembre("Vue membre", this);
		this.vm.setVisible(true);
		this.vm.majVueMembre();
	}
	
	public void addAct( Activite e)
	{
		this.listeA.addElement(e);
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
	
	public Vector<Membre> getMembreActivite (Activite _act) {
			
		for (int i=0; i<this.getNbActivites();i++) {
			if ( this.listeA.elementAt(i).equals(_act))
				return this.listeA.elementAt(i).getParticipants();
		}
		return null;		
	}
	
	public void ctrlStopVueMembre() {
		this.vm.setVisible(false);
	}
}
