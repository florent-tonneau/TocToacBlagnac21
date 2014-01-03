package Controleur;

import javax.swing.JOptionPane;

import Vue.MaFen;

public class CtrlPrincipal {

	private MaFen mf;
	
	public CtrlPrincipal ( ) {
		mf=new MaFen("TocToac - Menu Principal", this);
		mf.setVisible(true);
	}
	
	public void ctrlConsultActivite () {
		CtrlListeAct cla = new CtrlListeAct();
	}
	
	public void ctrlStopFen () {
		int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter la fenetre principale ?", "Quitter", JOptionPane.YES_NO_OPTION);
		if (retour == 0)
		{
			System.exit(0);	
		}
	}
}
