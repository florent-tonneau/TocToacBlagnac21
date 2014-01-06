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
	 *Description: Démarre le contrôleur pour créer et ouvrir une fenêtre
	 *Entrée: -
	 *Sortie: -
	 *Retour: -
	 *Précondition: -
	 * */
	public void demarrerControleur(){
		this.vm = new VueMembre("Vue membre", this);
		this.vm.setVisible(true);
		this.vm.majVueMembre();
	}
	
	/**
	 *Nom: addAct
	 *Description: permet d'ajouter une activité passée en paramètre à la liste des activités
	 *Entrée: Activite e
	 *Sortie: listeA mise à jour
	 *Retour: -
	 *Précondition: -
	 * */
	public void addAct( Activite e)
	{
		this.listeA.addElement(e);
	}
	
	/**
	 *Nom: removeAct
	 *Description: permet de supprimer une activité passée en paramètre de la liste d'activité
	 *Entrée: Activite e
	 *Sortie: listeA mise à jour
	 *Retour: -
	 *Précondition: l'activité e doit exister
	 * */
	public void removeAct( Activite e)
	{
		this.listeA.remove(e);
	}

	/**
	 *Nom: getNbActivites
	 *Description: Retourne le nombre total d'activités dans la liste
	 *Entrée: -
	 *Sortie: -
	 *Retour: la taille de la liste
	 *Précondition: liste non vide
	 * */
	public int getNbActivites()
	{
		return this.listeA.size();
	}
	
	/**
	 *Nom: getListeActivite 
	 *Description: Retourne un vecteur (tableau) d'activités
	 *Entrée: -
	 *Sortie: -
	 *Retour: une liste d'activités
	 *Précondition: -
	 * */
	public Vector<Activite> getListeActivite()
	{
		return this.listeA;
	}
	
	/**
	 *Nom: getMembreActivite
	 *Description: Retourne une liste de membres inscrit à une activité passée en paramètre
	 *Entrée: Activite _act
	 *Sortie: -
	 *Retour: une liste de membre
	 *Précondition: l'activité doit exister
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
	 *Entrée: -
	 *Sortie: -
	 *Retour: -
	 *Précondition: la vue doit être active
	 * */
	public void ctrlStopVueMembre() {
		this.vm.setVisible(false);
	}

	public String getNomMembre() {
		return nomMembre;
	}
}
