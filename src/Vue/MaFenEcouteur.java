package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class MaFenEcouteur implements ActionListener, WindowListener {
	MaFen mf;
	
	public MaFenEcouteur (MaFen f)
	{
		this.mf = f;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(this.mf.getbListe()))
		{
			//Appeler une méthode du controleur
		}
	}
	
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
		/* !!!!!!!!!!!!!!!!!!!!A ECRIRE DANS LE CONTROLEUR!!!!!!!!!!!!!!!!!!!!
		int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous Quitter l'éditeur de question ?", "Quitter", JOptionPane.YES_NO_OPTION);
		if (retour == 0)
		{
				this.vedq.setVisible(false);
		}		
		*/
		System.exit(0);
		
	}

	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
