package Vue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

import sun.org.mozilla.javascript.internal.ast.NewExpression;

import Controleur.CtrlEditerAct;
import Controleur.CtrlListeAct;
import Modele.Activite;
import Modele.Membre;

public class VueEditerActivites extends JFrame implements ActionListener, WindowListener, MouseListener{

	private JPanel contentPane;
	private JTextField txtTitre, textDate, txtHoraire;
	private JCheckBox CB_Entrainement;
	private JList LS_Events;
	private JButton btnSauvegarder, btnAnnuler;
	private CtrlEditerAct cea;
	private JButton btnSupprimer, btnNouveau;
	private JSplitPane SP_Edition, SP_Central;

	public VueEditerActivites(String _title, CtrlEditerAct _cea) {
		super(_title);
		this.cea=_cea;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		SP_Central = new JSplitPane();
		SP_Central.setEnabled(false);
		contentPane.add(SP_Central, BorderLayout.CENTER);
		
		LS_Events = new JList();
		SP_Central.setLeftComponent(LS_Events);
		LS_Events.addMouseListener(this);
		
		SP_Edition = new JSplitPane();
		SP_Edition.setEnabled(false);
		SP_Edition.setResizeWeight(0.2);
		SP_Central.setRightComponent(SP_Edition);
		
		JPanel JP_labels = new JPanel();
		SP_Edition.setLeftComponent(JP_labels);
		JP_labels.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		JP_labels.add(lblTitre);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		JP_labels.add(lblDate);
		
		JLabel lblHoraire = new JLabel("Horaire :");
		lblHoraire.setHorizontalAlignment(SwingConstants.CENTER);
		JP_labels.add(lblHoraire);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		JP_labels.add(lblType);
		
		JPanel JP_Champs = new JPanel();
		SP_Edition.setRightComponent(JP_Champs);
		JP_Champs.setLayout(new GridLayout(4, 0, 0, 0));
		
		txtTitre = new JTextField();
		txtTitre.setText("Titre");
		JP_Champs.add(txtTitre);
		txtTitre.setColumns(10);
		
		textDate = new JTextField();
		textDate.setText("JJ/MM/AAAA");
		JP_Champs.add(textDate);
		textDate.setColumns(10);
		
		txtHoraire = new JTextField();
		txtHoraire.setText("HH:MM");
		JP_Champs.add(txtHoraire);
		txtHoraire.setColumns(10);
		
		CB_Entrainement = new JCheckBox("Entrainement");
		CB_Entrainement.setSelected(true);
		CB_Entrainement.setHorizontalAlignment(SwingConstants.CENTER);
		JP_Champs.add(CB_Entrainement);
		
		JSplitPane SP_BotBoutons = new JSplitPane();
		SP_BotBoutons.setResizeWeight(0.5);
		SP_BotBoutons.setEnabled(false);
		contentPane.add(SP_BotBoutons, BorderLayout.SOUTH);
		
		JSplitPane SP_SauvAnn = new JSplitPane();
		SP_SauvAnn.setEnabled(false);
		SP_SauvAnn.setResizeWeight(0.4);
		SP_BotBoutons.setRightComponent(SP_SauvAnn);
		
		btnSauvegarder = new JButton("Sauvegarder");
		SP_SauvAnn.setLeftComponent(btnSauvegarder);
		btnSauvegarder.addActionListener(this);
		btnSauvegarder.setEnabled(false);
		
		btnAnnuler = new JButton("Annuler");
		SP_SauvAnn.setRightComponent(btnAnnuler);
		btnAnnuler.addActionListener(this);
		
		JSplitPane SP_AffNouv = new JSplitPane();
		SP_AffNouv.setResizeWeight(0.5);
		SP_AffNouv.setEnabled(false);
		SP_BotBoutons.setLeftComponent(SP_AffNouv);
		
		btnSupprimer = new JButton("Supprimer");
		SP_AffNouv.setLeftComponent(btnSupprimer);
		btnSupprimer.addActionListener(this);
		
		btnNouveau = new JButton("Nouveau");
		SP_AffNouv.setRightComponent(btnNouveau);
		btnNouveau.addActionListener(this);
	}

	public void majListeActivites(){
		String s;
		Activite a;
		Vector<String> v = new Vector<String>();
		
		this.LS_Events.removeAll();
		
		for (int i =0; i<this.cea.getListeActivite().size(); i++)
		{
				a = this.cea.getListeActivite().get(i);
				if(a.isEntrainement() == true)
					s = ("Entraînement "+a.getTitre()+ " " + a.getDate()+ " " + a.getHoraire());
				else
					s = ("Ponctuel "+a.getTitre()+ " " + a.getDate()+ " " + a.getHoraire());
				v.add(s);
		}
		this.LS_Events.setListData(v);
	}

	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource().equals(this.btnSupprimer)){
			cea.getListeActivite().removeElementAt(LS_Events.getSelectedIndex());
			
		}
		if(ae.getSource().equals(this.btnAnnuler)){
			this.setVisible(false);
		}
		if(ae.getSource().equals(this.btnSauvegarder)){
			Activite ac;
			ac = cea.getListeActivite().get(LS_Events.getSelectedIndex());
			
			ac.setTitre(this.txtTitre.getText());
			ac.setDate(this.textDate.getText());
			ac.setHoraire(this.txtHoraire.getText());
			ac.setEntrainement(this.CB_Entrainement.isSelected());
			majListeActivites();
		}
		if(ae.getSource().equals(this.btnNouveau)){
			SP_Edition.setVisible(true);
			Activite ac;
			ac = new Activite("Titre", "JJ/MM/YYYY", "HH:MM", new Vector<Membre>(), true);
			
			this.txtTitre.setText(ac.getTitre());
			this.textDate.setText(ac.getDate());
			this.txtHoraire.setText(ac.getHoraire());
			if(ac.isEntrainement()){
				this.CB_Entrainement.setSelected(true);
			}
			else{
				this.CB_Entrainement.setSelected(false);
			}
			majListeActivites();
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {
		this.majActivite();
	}
	
	public void majActivite(){
		Activite ac;
		ac = cea.getListeActivite().get(LS_Events.getSelectedIndex());
		
		this.txtTitre.setText(ac.getTitre());
		this.textDate.setText(ac.getDate());
		this.txtHoraire.setText(ac.getHoraire());
		if(ac.isEntrainement()){
			this.CB_Entrainement.setSelected(true);
		}
		else{
			this.CB_Entrainement.setSelected(false);
		}
		btnSauvegarder.setEnabled(true);
	}
}
