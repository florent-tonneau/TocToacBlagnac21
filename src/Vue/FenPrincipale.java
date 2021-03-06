package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controleur.CtrlPrincipal;

/**
 * @author Groupe1
 *
 */
public class FenPrincipale extends JFrame implements ActionListener, WindowListener, FocusListener{

	
	private static final long serialVersionUID = 1L;
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
	private JButton btnEditerEvent;

	
	/**
	 * Cr��e Une fen�tre principale avec son titre et son contr�leur
	 * 
	 * @param _t
	 * @param _cp
	 */
	public FenPrincipale(String _t, CtrlPrincipal _cp) {
		super (_t);
		this.cp=_cp;
		this.addWindowListener(this);
		setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JP_Boutons = new JPanel();
		contentPane.add(JP_Boutons, BorderLayout.CENTER);
		JP_Boutons.setLayout(new GridLayout(4, 1, 0, 0));
		
		btnEditerAct = new JButton("Editer les Entra�nements");
		btnEditerAct.setEnabled(false);
		JP_Boutons.add(btnEditerAct);
		btnEditerAct.addActionListener(this);
		
		btnEditerEvent = new JButton("Editer les Ev�nements Ponctuels");
		JP_Boutons.add(btnEditerEvent);
		btnEditerEvent.setEnabled(false);		
		btnEditerEvent.addActionListener(this);
		
		btnConsulterListe = new JButton("Consulter la liste des Activit�s");
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
		
		lbRoles = new JLabel("R�le :");
		lbRoles.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbRoles);
		
		Vector<String> vroles = new Vector<String>();
		vroles.add("Sportif");
		vroles.add("Entra�neur");
		vroles.add("Admin");
		comboBox = new JComboBox<String>(vroles);
		panel.add(comboBox);
		
		this.textField.addFocusListener(this);
		this.comboBox.addFocusListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		/**
		 * Si le champ d'identification est vide, un message d'erreur s'affiche
		 */
		if ((arg0.getSource().equals(btnConnexion) || arg0.getSource().equals(this.btnConsulterListe))
				&&  textField.getText().equals("")){
			JOptionPane.showMessageDialog(this, 
					"Le nom de l'utilisateur doit �tre renseign� pour pouvoir continuer.",
					"Attention !", JOptionPane.WARNING_MESSAGE);
		}
		else if (arg0.getSource().equals(btnConnexion)){
			if(comboBox.getSelectedIndex() == 0){//Sportif
				btnConsulterListe.setEnabled(true);
				btnEditerAct.setEnabled(false);
				btnEditerEvent.setEnabled(true);
				
			}
			else if(comboBox.getSelectedIndex() == 1){//Entraineur
				btnConsulterListe.setEnabled(true);
				btnEditerAct.setEnabled(true);
				btnEditerEvent.setEnabled(true);
				
			}
			else{//Admin
				btnConsulterListe.setEnabled(true);
				btnEditerAct.setEnabled(true);
				btnEditerEvent.setEnabled(true);
			}
		}
		else {
			if (arg0.getSource().equals(this.btnConsulterListe)) {
				this.cp.ctrlConsultActivite(textField.getText());
			}
			if (arg0.getSource().equals(this.btnEditerAct)){
				this.cp.ctrlEditerActivite();
			}
			if (arg0.getSource().equals(this.btnEditerEvent)) {
				this.cp.ctrlEditerPonctuel();
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

	
	public void focusGained(FocusEvent arg0) {
		btnEditerAct.setEnabled(false);
		btnConsulterListe.setEnabled(false);
		btnEditerEvent.setEnabled(false);
	}

	
	public void focusLost(FocusEvent arg0) {}

}
