package Controleur;

import java.util.Vector;

import javax.swing.JOptionPane;

import Modele.Activite;
import Modele.Membre;
import Vue.MaFen;

public class CtrlPrincipal {

	private MaFen mf;
	
	public CtrlPrincipal ( ) {
		mf=new MaFen("TocToac - Menu Principal", this);
		mf.setVisible(true);
	}
	
	public void ctrlConsultActivite (String _nomMembre) {
		CtrlListeAct cla = new CtrlListeAct(_nomMembre);
		cla.demarrerControleur();
		
	}
	
	public void ctrlStopFen () {
		JOptionPane confirm = new JOptionPane();
		int retour = confirm.showConfirmDialog(this.mf, "Voulez-vous quitter la fenetre principale ?");
		if (retour == 0)
		{
			System.exit(0);	
		}
	}
}
