package Vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controleur.CtrlPrincipal;

public class MaFen extends JFrame implements ActionListener, WindowListener{
	
	private CtrlPrincipal cp;
	private JLabel lTocToac;
	private JButton bListe;
	
	public MaFen (String _t, CtrlPrincipal _cp)
	{
		super (_t);
		this.cp=_cp;
		
		//Configuration de la fenêtre
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setSize(400, 400);
		this.bListe = new JButton("Consulter la liste des activités");
		this.lTocToac = new JLabel("TocToac");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//Ajout des boutons à la fenêtre
		this.add(this.bListe, BorderLayout.SOUTH);
		this.add(this.lTocToac, BorderLayout.CENTER);
		this.lTocToac.setHorizontalAlignment(JLabel.CENTER);
		this.lTocToac.setVerticalAlignment(JLabel.CENTER);
		
		this.bListe.addActionListener(this);
		this.addWindowListener(this);
	}

	public JLabel getlTocToac() {
		return lTocToac;
	}

	public void setlTocToac(JLabel lTocToac) {
		this.lTocToac = lTocToac;
	}

	public JButton getbListe() {
		return bListe;
	}

	public void setbListe(JButton bListe) {
		this.bListe = bListe;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(this.getbListe()))
		{
			this.cp.ctrlConsultActivite();
		}
	}
	
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	
	public void windowClosing(WindowEvent arg0) {
		this.cp.ctrlStopFen();
	}

	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
