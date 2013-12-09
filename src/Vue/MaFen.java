package Vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MaFen extends JFrame{
	
	private JLabel Hello;
	public MaFen (String title, int x, int y, int longueur, int largeur)
	{
		super (title);
		
		this.setBounds (x,y,longueur,largeur);
		this.setResizable(true);
		this.Hello=new JLabel("Hello Word !",JLabel.CENTER);
		this.add(this.Hello, BorderLayout.CENTER);
	}
}
