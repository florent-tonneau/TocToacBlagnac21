package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;

import Controleur.CtrlPrincipal;

/**
 * @author Groupe1
 *
 */
public class FenPrincipale extends JFrame implements ActionListener, WindowListener{

	private CtrlPrincipal cp;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnConsulterListe;
	private JButton btnConnexion;
	private JLabel lbIdentifiant;
	private JLabel lbRoles;
	private JComboBox<String> comboBox;
	private JPanel panel;
	private JSplitPane splitPane;
	private JPanel JP_Boutons;
	private JButton btnEditerAct;

	
	/**
	 * Créée Une fenêtre principale avec son titre et son contrôleur
	 * 
	 * @param _t
	 * @param _cp
	 */
	public FenPrincipale(String _t, CtrlPrincipal _cp) {
		super (_t);
		this.cp=_cp;
		this.addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JP_Boutons = new JPanel();
		contentPane.add(JP_Boutons, BorderLayout.CENTER);
		JP_Boutons.setLayout(new GridLayout(4, 1, 0, 0));
		
		btnEditerAct = new JButton("Editer les Activit\u00E9s");
		btnEditerAct.setEnabled(false);
		JP_Boutons.add(btnEditerAct);
		btnEditerAct.addActionListener(this);
		
		btnConsulterListe = new JButton("Consulter la liste des Activités");
		JP_Boutons.add(btnConsulterListe);
		btnConsulterListe.setEnabled(false);
		btnConsulterListe.addActionListener(this);
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.NORTH);
		
		btnConnexion = new JButton("Connexion");
		splitPane.setRightComponent(btnConnexion);
		btnConnexion.addActionListener(this);
		
		panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		lbIdentifiant = new JLabel("Identifiant :");
		panel.add(lbIdentifiant);
		lbIdentifiant.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);
		
		lbRoles = new JLabel("Rôle :");
		lbRoles.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbRoles);
		
		Vector<String> vroles = new Vector<String>();
		vroles.add("Sportif");
		vroles.add("Entraîneur");
		vroles.add("Admin");
		comboBox = new JComboBox<String>(vroles);
		panel.add(comboBox);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		/**
		 * Si le champ d'identification est vide, un message d'erreur s'affiche
		 */
		if ((arg0.getSource().equals(btnConnexion) || arg0.getSource().equals(this.btnConsulterListe))
				&&  textField.getText().equals("")){
			JOptionPane.showMessageDialog(this, 
					"Le nom de l'utilisateur doit être renseigné pour pouvoir continuer.",
					"Attention !", JOptionPane.WARNING_MESSAGE);
		}
		else if (arg0.getSource().equals(btnConnexion)){
			if(comboBox.getSelectedIndex() == 0){//Sportif
				btnConsulterListe.setEnabled(true);
			}
			else if(comboBox.getSelectedIndex() == 1){//Entraineur
				btnConsulterListe.setEnabled(true);
				btnEditerAct.setEnabled(true);
			}
			else{//Admin
				btnConsulterListe.setEnabled(true);
			}
		}
		else {
			if (arg0.getSource().equals(this.btnConsulterListe)) {
				this.cp.ctrlConsultActivite(textField.getText());
			}
			if (arg0.getSource().equals(this.btnEditerAct)){
				this.cp.ctrlEditerActivite();
			}
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
