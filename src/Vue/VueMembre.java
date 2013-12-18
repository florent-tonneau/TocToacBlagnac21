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

public class VueMembre extends JFrame {

	private JPanel contentPane;
	private String title;
	private JList LS_Events;
	private JList LS_Participants;
	private JButton btnAfficher;
	private JButton btnInscrire;
	private JSplitPane SP_Back;
	private JSplitPane SP_Left;
	private JSplitPane SP_Right;
	//private ctrlListeActs cla;
	
	public VueMembre(String title, int x, int y, int l, int L) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		SP_Back = new JSplitPane();
		SP_Back.setEnabled(false);
		SP_Back.setResizeWeight(0.35);
		SP_Back.setContinuousLayout(true);
		contentPane.add(SP_Back, BorderLayout.CENTER);
		
		SP_Left = new JSplitPane();
		SP_Left.setResizeWeight(1.0);
		SP_Left.setForeground(new Color(240, 240, 240));
		SP_Left.setEnabled(false);
		SP_Left.setBackground(new Color(240, 240, 240));
		SP_Left.setOrientation(JSplitPane.VERTICAL_SPLIT);
		SP_Back.setLeftComponent(SP_Left);
		
		btnAfficher = new JButton("Afficher Participants >>>");
		SP_Left.setRightComponent(btnAfficher);
		
		LS_Events = new JList();
		SP_Left.setLeftComponent(LS_Events);
		
		SP_Right = new JSplitPane();
		SP_Right.setResizeWeight(1.0);
		SP_Right.setForeground(new Color(240, 240, 240));
		SP_Right.setEnabled(false);
		SP_Right.setBackground(new Color(240, 240, 240));
		SP_Right.setOrientation(JSplitPane.VERTICAL_SPLIT);
		SP_Back.setRightComponent(SP_Right);
		
		LS_Participants = new JList();
		SP_Right.setLeftComponent(LS_Participants);
		
		btnInscrire = new JButton("S'inscrire");
		SP_Right.setRightComponent(btnInscrire);
	}

	public void majVueMembre(){
		
	}
}
