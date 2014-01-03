package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JButton;

import Controleur.CtrlListeAct;
import Modele.Activite;
import Modele.Membre;
//import Modele.Event;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

public class VueMembre extends JFrame implements ActionListener, WindowListener{

	private static final long serialVersionUID = -4738830974865641490L;
	private JPanel contentPane;
	private String title;
	private JList LS_Events, LS_Participants;
	private JButton btnAfficher, btnInscrire;
	private JSplitPane SP_Back, SP_Left, SP_Right;
	private CtrlListeAct cla;
	
	public VueMembre(String title, CtrlListeAct _cla) {
		super(title);
		this.cla=_cla;
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(50, 50, 640, 480);
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
		
		this.btnAfficher.addActionListener(this);
		this.btnInscrire.addActionListener(this);
		this.addWindowListener(this);
	}

	public JButton getBtnAfficher() {
		return btnAfficher;
	}

	public JButton getBtnInscrire() {
		return btnInscrire;
	}

	public void majVueMembre(){
		String s;
		Activite a;
		Vector<String> v = new Vector<String>();
		
		this.LS_Events.removeAll();
		this.LS_Participants.removeAll();
		
		for (int i =0; i<this.cla.getListeActivite().size(); i++)
		{
				a = this.cla.getListeActivite().get(i);
				s = (a.getTitre()+ " " + a.getDate()+ " " + a.getHoraire());
				v.add(s);
		}
		
		this.LS_Events.setListData(v);
		
	}

	
	public void actionPerformed(ActionEvent arg0) {		
		if ( arg0.getSource().equals(this.btnAfficher))
		{
			this.LS_Participants.removeAll();
			if(LS_Events.getSelectedIndex() != -1){
				
				Vector<String> v= new Vector<String>();
				String s;
				Membre m;
				
				Vector<Membre> vm= new Vector<Membre>(this.cla.getMembreActivite(this.cla.getListeActivite().elementAt(LS_Events.getSelectedIndex())));
				
				for (int i =0; i<vm.size(); i++)
				{
						m= vm.elementAt(i);
						s = (m.getNom());
						v.add(s);
				}
				
				
				this.LS_Participants.setListData(v);
			}
		}
	}
	
	public void windowActivated(WindowEvent arg0) {}	
	public void windowClosed(WindowEvent arg0) {}	
	public void windowClosing(WindowEvent arg0) {
			this.cla.ctrlStopVueMembre();
	}
	
	public void windowDeactivated(WindowEvent arg0) {}	
	public void windowDeiconified(WindowEvent arg0) {}	
	public void windowIconified(WindowEvent arg0) {}	
	public void windowOpened(WindowEvent arg0) {}
	
	
}
