/********************************
 * Controleur Principal de l'application : permet de créer tous les autres controleurs 
 * et gèrent la fenetre principale de l'application
 * 
 * @author Florent TONNEAU
 * @version 1.0 * 
 */

package Controleur;

import javax.swing.JOptionPane;

import Vue.FenPrincipale;

public class CtrlPrincipal {

	private FenPrincipale fp;
	
	/**
	 * Constructeur non paramétré pour créer une instance du controleur principal et
	 * la fenetre principale
	 */
	public CtrlPrincipal ( ) {
		fp=new FenPrincipale("TocToac - Menu Principal", this);
		fp.setVisible(true);
	}
	
	/**
	 * Permet de créer un constructeur de l'affichage des activités avec les membres
	 * 
	 * @param _nomMembre nom du membre (utilisateur)
	 */
	public void ctrlConsultActivite (String _nomMembre) {
		CtrlListeAct cla = new CtrlListeAct(_nomMembre);
		cla.demarrerControleur(this.fp);
	}
	
	/**
	 * Permet de créer un controleur d'édition d'entrainements
	 */
	public void ctrlEditerActivite (){
		CtrlEditerAct cea = new CtrlEditerAct();
		cea.demarrerControleurEditerAct(this.fp, true);
	}
	
	/**
	 * 
	 * Permet d'arreter la fenetre principale
	 */
	public void ctrlStopFen () {
		int retour = JOptionPane.showConfirmDialog(this.fp, "Voulez-vous quitter la fenetre principale ?");
		if (retour == 0)
		{
			System.exit(0);	
		}
	}
	
	/**
	 * Permet de créer un controleur d'édition d'événements ponctuels
	 */
	public void ctrlEditerPonctuel () {
		CtrlEditerAct cea = new CtrlEditerAct();
		cea.demarrerControleurEditerAct(this.fp, false);
	}
}
