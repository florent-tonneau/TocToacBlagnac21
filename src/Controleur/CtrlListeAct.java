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
import Modele.Activite;
import Modele.Membre;
import Vue.VueMembre;


public class CtrlListeAct {

	private Vector<Activite> listeA;
	private VueMembre vm;
	private String nomMembre;	
	
	public CtrlListeAct(String _n)
	{
		this.listeA=new Vector<Activite>();	
		
			
		chargerListeActivite();
		
		this.nomMembre=_n;
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
		this.vm.dispose();
	}

	public String getNomMembre() {
		return nomMembre;
	}
	
	private void chargerListeActivite (){
					
		Scanner scanner;
		try {
			
			scanner = new Scanner(new FileReader("Activites"));
			String str ;
			String[] mots = null ;
			Vector<Membre> membres=new Vector<Membre>();
			
			while (scanner.hasNextLine()) {
			     str = scanner.nextLine();
			     mots=str.split("@@");
			     
			     for ( int i=3; i<mots.length;i=i+2){
			    	 membres.add(new Membre(Integer.parseInt(mots[i]), mots[i+1]));
			     }
			     
			     this.listeA.add(new Activite(mots[0], mots[1], mots[2],membres ));
			}
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}	
	}
	
	private void sauvegarderListeActivite (Vector<Activite> _act) {
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
}
