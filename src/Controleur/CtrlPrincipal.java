/********************************
 * Controleur Principal de l'application : permet de cr�er tous les autres controleurs 
 * et g�rent la fenetre principale de l'application
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
	 * Constructeur non param�tr� pour cr�er une instance du controleur principal et
	 * la fenetre principale
	 */
	public CtrlPrincipal ( ) {
		fp=new FenPrincipale("TocToac - Menu Principal", this);
		fp.setVisible(true);
	}
	
	/**
	 * Permet de cr�er un constructeur de l'affichage des activit�s avec les membres
	 * 
	 * @param _nomMembre nom du membre (utilisateur)
	 */
	public void ctrlConsultActivite (String _nomMembre) {
		CtrlListeAct cla = new CtrlListeAct(_nomMembre);
		cla.demarrerControleur(this.fp);
	}
	
	/**
	 * Permet de cr�er un controleur d'�dition d'entrainements
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
	 * Permet de cr�er un controleur d'�dition d'�v�nements ponctuels
	 */
	public void ctrlEditerPonctuel () {
		CtrlEditerAct cea = new CtrlEditerAct();
		cea.demarrerControleurEditerAct(this.fp, false);
	}
}
