package Controleur;

import java.util.Vector;
import Modele.Activite;
import Modele.Membre;
import Vue.VueMembre;


public class CtrlListeAct {

	private Vector<Activite> listeA;
	private VueMembre vm;
	private String nomMembre;
	
	
	public CtrlListeAct()
	{
		this.listeA=new Vector<Activite>();
		
		Vector<Membre> membre = new Vector<Membre>();
		membre.add(new Membre(1,"John"));
		membre.add(new Membre(2,"Paul"));
		Activite a1= new Activite("Event","21/21/21","18h",membre );
		
		this.addAct(a1);		
	}
	
	/**
	 *Nom: demarrerControleur
	 *Description: D�marre le contr�leur pour cr�er et ouvrir une fen�tre
	 *Entr�e: -
	 *Sortie: -
	 *Retour: -
	 *Pr�condition: -
	 * */
	public void demarrerControleur(){
		this.vm = new VueMembre("Vue membre", this);
		this.vm.setVisible(true);
		this.vm.majVueMembre();
	}
	
	/**
	 *Nom: addAct
	 *Description: permet d'ajouter une activit� pass�e en param�tre � la liste des activit�s
	 *Entr�e: Activite e
	 *Sortie: listeA mise � jour
	 *Retour: -
	 *Pr�condition: -
	 * */
	public void addAct( Activite e)
	{
		this.listeA.addElement(e);
	}
	
	/**
	 *Nom: removeAct
	 *Description: permet de supprimer une activit� pass�e en param�tre de la liste d'activit�
	 *Entr�e: Activite e
	 *Sortie: listeA mise � jour
	 *Retour: -
	 *Pr�condition: l'activit� e doit exister
	 * */
	public void removeAct( Activite e)
	{
		this.listeA.remove(e);
	}

	/**
	 *Nom: getNbActivites
	 *Description: Retourne le nombre total d'activit�s dans la liste
	 *Entr�e: -
	 *Sortie: -
	 *Retour: la taille de la liste
	 *Pr�condition: liste non vide
	 * */
	public int getNbActivites()
	{
		return this.listeA.size();
	}
	
	/**
	 *Nom: getListeActivite 
	 *Description: Retourne un vecteur (tableau) d'activit�s
	 *Entr�e: -
	 *Sortie: -
	 *Retour: une liste d'activit�s
	 *Pr�condition: -
	 * */
	public Vector<Activite> getListeActivite()
	{
		return this.listeA;
	}
	
	/**
	 *Nom: getMembreActivite
	 *Description: Retourne une liste de membres inscrit � une activit� pass�e en param�tre
	 *Entr�e: Activite _act
	 *Sortie: -
	 *Retour: une liste de membre
	 *Pr�condition: l'activit� doit exister
	 * */
	public Vector<Membre> getMembreActivite (Activite _act) {
			
		for (int i=0; i<this.getNbActivites();i++) {
			if ( this.listeA.elementAt(i).equals(_act))
				return this.listeA.elementAt(i).getParticipants();
		}
		return null;		
	}
	
	/**
	 *Nom: ctrlStopVueMembre
	 *Description: Ferme la vue membre
	 *Entr�e: -
	 *Sortie: -
	 *Retour: -
	 *Pr�condition: la vue doit �tre active
	 * */
	public void ctrlStopVueMembre() {
		this.vm.setVisible(false);
	}

	public String getNomMembre() {
		return nomMembre;
	}
}
