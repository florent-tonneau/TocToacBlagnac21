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
		cla.demarrerControleur();
	}
	
	public void ctrlEditerActivite (){
		CtrlEditerAct cea = new CtrlEditerAct();
		cea.demarrerControleurEditerAct();
	}
	
	public void ctrlStopFen () {
		JOptionPane confirm = new JOptionPane();
		int retour = confirm.showConfirmDialog(this.fp, "Voulez-vous quitter la fenetre principale ?");
		if (retour == 0)
		{
			System.exit(0);	
		}
	}
}
