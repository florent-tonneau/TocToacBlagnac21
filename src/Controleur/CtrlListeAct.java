package Controleur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;

import Modele.Activite;
import Modele.Membre;
import Vue.VueMembre;


public class CtrlListeAct {

	private Vector<Activite> listeA;
	private VueMembre vm;
	private String nomMembre;	
	
	public CtrlListeAct(String _n)
	{
		vm=null;
		this.listeA=new Vector<Activite>();			
		chargerListeActivite();		
		this.nomMembre=_n;
	}
	
	/**
	 *Nom: demarrerControleur
	 *Description: Démarre le contrôleur pour créer et ouvrir une fenêtre
	 *Entrée: -
	 *Sortie: -
	 *Retour: -
	 *Précondition: -
	 * */
	public void demarrerControleur(JFrame _fen){
		this.vm = new VueMembre(_fen,"Vue membre", this);
		this.vm.setVisible(true);
		this.vm.majActivites();
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
	public Vector<Membre> getMembreActivite (int index) {
		
		return this.listeA.get(index).getParticipants();
				
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
		this.vm.dispose();
	}

	/**
	 *Nom: getNomMembre
	 *Description: permet d'obtenir le nom du membre qui utilise le programme
	 *Entrée: -
	 *Sortie: -
	 *Retour: String
	 *Précondition: -
	 * */
	public String getNomMembre() {
		return nomMembre;
	}
	
	/**
	 *Nom: chargerListeActivite
	 *Description: permet de charger d'un fichier les activités et les membres qui sont inscrits à ceux-ci.
	 *Entrée: -
	 *Sortie: -
	 *Retour: -
	 *Précondition: Le fichier "Activites" existe et se trouve dans le répertoire courant du projet
	 * */
	public void chargerListeActivite (){
					
		Scanner scanner;
		try {
			
			scanner = new Scanner(new FileReader("Activites"));
			String str ;
			String[] mots = null ;
			Vector<Membre> membres=new Vector<Membre>();
			
			while (scanner.hasNextLine()) {
			     str = scanner.nextLine();
			     mots=str.split("@@");
			     
			     for ( int i=4; i<mots.length;i=i+2){
			    	 membres.add(new Membre(Integer.parseInt(mots[i]), mots[i+1]));
			     }
			     
			     this.listeA.add(new Activite(mots[0], mots[1], mots[2],membres, Boolean.parseBoolean(mots[3]) ));
			     membres.removeAllElements();
			}
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}	
	}
	
	/**
	 *Nom: sauvegarderListeActivite
	 *Description: permet de sauvegarder les activités et les membres qui sont inscrits à ces activités, dans 
	 * 				un fichier nommé "Activites".
	 *Entrée: Vector<Activite> activités 
	 *Sortie: -
	 *Retour: -
	 *Précondition: -
	 * */
	public void sauvegarderListeActivite (Vector<Activite> _act) {
		File f=new File("Activites");
		FileWriter fw;
		
		try {			
			fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter ( fw ) ;
			PrintWriter pw = new PrintWriter ( bw );
			
			for ( int i=0; i< this.listeA.size(); i++) {
				
				pw.print(this.listeA.get(i).getTitre());
				pw.print("@@");
				pw.print(this.listeA.get(i).getDate());
				pw.print("@@");
				pw.print(this.listeA.get(i).getHoraire());
				pw.print("@@");
				pw.print(this.listeA.get(i).isEntrainement());
				pw.print("@@");
				
				for ( int j=0; j<this.listeA.get(i).getParticipants().size();j++) {
					pw.print(Integer.toString(this.listeA.get(i).getParticipants().get(j).getIdMembre()));
					pw.print("@@");
					pw.print(this.listeA.get(i).getParticipants().get(j).getNom());
					pw.print("@@");
				}
				bw.newLine();
			}
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

	/**
	 *Nom: desinscrireMembre
	 *Description: permet de désinscrire un membre d'une activité
	 *Entrée: index de l'activité
	 *Sortie: -
	 *Retour: -
	 *Précondition: Le membre a désinscrire est dans la liste des membres de l'activité correspondante à l'index.
	 * */
	public void desinscrireMembre(int index) {
		
		int indexMembre=-1;
		
		for (int i=0; i<this.listeA.get(index).getParticipants().size();i++)
			if ( this.listeA.get(index).getParticipants().get(i).getNom().equals(this.nomMembre))
				indexMembre=i;
		
		this.listeA.get(index).getParticipants().remove(indexMembre);
		this.sauvegarderListeActivite(listeA);
		this.vm.majMembres();
	}

	/**
	 *Nom: inscrireMembre
	 *Description: permet d'inscrire l'utilisateur comme membre de l'activité référencée par l'index 
	 *Entrée: index de l'activité
	 *Sortie: -
	 *Retour: -
	 *Précondition: L'utilisateur ne doit pas etre déjà inscrit
	 * */
	public void inscrireMembre(int index) {
		this.listeA.get(index).getParticipants().add(new Membre(this.listeA.get(index).getParticipants().size()+1,this.nomMembre));
		this.sauvegarderListeActivite(listeA);
		this.vm.majMembres();
	}
}
