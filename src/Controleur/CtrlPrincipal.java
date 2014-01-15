package Controleur;

import javax.swing.JOptionPane;

import Vue.FenPrincipale;

public class CtrlPrincipal {

	private FenPrincipale fp;
	
	public CtrlPrincipal ( ) {
		fp=new FenPrincipale("TocToac - Menu Principal", this);
		fp.setVisible(true);
	}
	
	public void ctrlConsultActivite (String _nomMembre) {
		CtrlListeAct cla = new CtrlListeAct(_nomMembre);
		cla.demarrerControleur(this.fp);
	}
	
	public void ctrlEditerActivite (){
		CtrlEditerAct cea = new CtrlEditerAct();
		cea.demarrerControleurEditerAct(this.fp, true);
	}
	
	public void ctrlStopFen () {
		int retour = JOptionPane.showConfirmDialog(this.fp, "Voulez-vous quitter la fenetre principale ?");
		if (retour == 0)
		{
			System.exit(0);	
		}
	}
	
	public void ctrlEditerPonctuel () {
		CtrlEditerAct cea = new CtrlEditerAct();
		cea.demarrerControleurEditerAct(this.fp, false);
	}
}
