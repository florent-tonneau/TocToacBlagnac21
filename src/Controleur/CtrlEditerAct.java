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
import Vue.VueEditerActivites;
import Vue.VueMembre;

import Modele.Activite;
import Modele.Membre;

public class CtrlEditerAct {

	private Vector<Activite> listeA; 
	private VueEditerActivites vea;
	
	public CtrlEditerAct () {
		vea=null;
		this.listeA=new Vector<Activite>();			
		chargerListeActivite();	
	}
	
	/**
	 *Nom: demarrerControleur
	 *Description: Démarre le contrôleur pour créer et ouvrir une fenêtre
	 *Entrée: -
	 *Sortie: -
	 *Retour: -
	 *Précondition: -
	 * */
	public void demarrerControleurEditerAct () {
		this.vea = new VueEditerActivites("Edition", this);
		this.vea.setVisible(true);
		this.vea.majListeActivites();
		this.vea.majActivite();
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
	 *Nom: ctrlStopVueEditerAct
	 *Description: Ferme la vue editer activités
	 *Entrée: -
	 *Sortie: -
	 *Retour: -
	 *Précondition: la vue doit être active
	 * */
	public void ctrlStopVueEditerAct() {
		this.vea.setVisible(false);
		this.vea.dispose();
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
	 *Nom:  editerActivite
	 *Description:  permet d'editer une activite dans le vector d'activite
	 *Entrée: index de l'activité à editer, activité à remplacer
	 *Sortie: vector modifié
	 *Retour: -
	 *Précondition: -
	 * */
	public void editerActivite (int _index, Activite _act) {
		this.listeA.setElementAt(_act, _index);
		sauvegarderListeActivite(this.listeA);
		this.vea.majListeActivites();
	}
	
	/**
	 *Nom:  supprimerActivite
	 *Description: permet de supprimer une activité dans le vector d'activité
	 *Entrée:  index de l'activité à supprimer
	 *Sortie: -
	 *Retour: - 
	 *Précondition: index doit porter sur une activité existante
	 * */
	public void supprimerActivite (int _index) {
		this.listeA.remove(_index);
		sauvegarderListeActivite(this.listeA);
		this.vea.majListeActivites();
	}
	
	/**
	 *Nom:  ajouterActivite
	 *Description: permet d'ajouter une activité dans la liste
	 *Entrée: activité à ajouter
	 *Sortie: -
	 *Retour: -
	 *Précondition: -
	 * */
	public void ajouterActivite (Activite _act) {
		this.listeA.add(_act);
		sauvegarderListeActivite(this.listeA);
		this.vea.majListeActivites();
	}
	
	
}
