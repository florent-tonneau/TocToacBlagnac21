package Vue;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MaFen extends JFrame{
	
	private JLabel lTocToac;
	private JButton bListe;
	
	public MaFen (String _t)
	{
		super (_t);
		
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
		
		MaFenEcouteur mfe = new MaFenEcouteur(this);
		this.bListe.addActionListener(mfe);
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
}
