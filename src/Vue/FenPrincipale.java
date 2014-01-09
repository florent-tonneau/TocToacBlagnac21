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

public class FenPrincipale extends JFrame implements ActionListener, WindowListener{

	private CtrlPrincipal cp;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnConsulterLaListe;
	private JButton btnConnexion;
	private JLabel label;
	private JLabel label_1;
	private JComboBox<String> comboBox;
	private JPanel panel;
	private JSplitPane splitPane;

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
		
		btnConsulterLaListe = new JButton("Consulter la liste des Activit\u00E9s");
		contentPane.add(btnConsulterLaListe, BorderLayout.SOUTH);
		btnConsulterLaListe.setEnabled(false);
		btnConsulterLaListe.addActionListener(this);
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.NORTH);
		
		btnConnexion = new JButton("Connexion");
		splitPane.setRightComponent(btnConnexion);
		btnConnexion.addActionListener(this);
		
		panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		label = new JLabel("Identifiant :");
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);
		
		label_1 = new JLabel("Rôle :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);
		
		Vector<String> vroles = new Vector<String>();
		vroles.add("Sportif");
		vroles.add("Entraîneur");
		vroles.add("Admin");
		comboBox = new JComboBox<String>(vroles);
		panel.add(comboBox);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if ((arg0.getSource().equals(btnConnexion) || arg0.getSource().equals(this.btnConsulterLaListe))
				&&  textField.getText().equals("")){
			JOptionPane.showMessageDialog(this, 
					"Le nom de l'utilisateur doit être renseigné pour pouvoir continuer.",
					"Attention !", JOptionPane.WARNING_MESSAGE);
		}
		else if (arg0.getSource().equals(btnConnexion)){
			if(comboBox.getSelectedIndex() == 0){//Sportif
				btnConsulterLaListe.setEnabled(true);
			}
			else if(comboBox.getSelectedIndex() == 1){//Entraineur
				btnConsulterLaListe.setEnabled(true);
			}
			else{//Admin
				btnConsulterLaListe.setEnabled(true);
			}
		}
		else {
			if (arg0.getSource().equals(this.btnConsulterLaListe)) {
				this.cp.ctrlConsultActivite(textField.getText());
			
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
