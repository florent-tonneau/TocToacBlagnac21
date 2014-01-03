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
		JOptionPane confirm = new JOptionPane();
		int retour = confirm.showConfirmDialog(null, "Voulez-vous quitter la fenetre principale ?");
		if (retour == 0)
		{
			System.exit(0);	
		}
	}
}
