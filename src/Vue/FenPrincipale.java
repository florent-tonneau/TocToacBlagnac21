package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;

public class FenPrincipale extends JFrame {

	private JPanel contentPane;
	private String title;
	private JList LS_Events;
	

	/**
	 * Create the frame.
	 */
	public FenPrincipale(String title, int x, int y, int l, int L) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane SP_Back = new JSplitPane();
		SP_Back.setEnabled(false);
		SP_Back.setResizeWeight(0.3);
		SP_Back.setContinuousLayout(true);
		contentPane.add(SP_Back, BorderLayout.CENTER);
		
		JSplitPane SP_Left = new JSplitPane();
		SP_Left.setResizeWeight(1.0);
		SP_Left.setForeground(new Color(240, 240, 240));
		SP_Left.setEnabled(false);
		SP_Left.setBackground(new Color(240, 240, 240));
		SP_Left.setOrientation(JSplitPane.VERTICAL_SPLIT);
		SP_Back.setLeftComponent(SP_Left);
		
		JButton btnAfficher = new JButton("Afficher >>>");
		SP_Left.setRightComponent(btnAfficher);
		
		LS_Events = new JList();
		SP_Left.setLeftComponent(LS_Events);
		
		JList LS_Participants = new JList();
		SP_Back.setRightComponent(LS_Participants);
	}

}
