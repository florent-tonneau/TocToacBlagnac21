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

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

import sun.org.mozilla.javascript.internal.ast.NewExpression;

import Controleur.CtrlEditerAct;
import Controleur.CtrlListeAct;
import Modele.Activite;
import Modele.Membre;

public class VueEditerActivites extends JDialog implements ActionListener, WindowListener, MouseListener{

        private JPanel contentPane;
        private JTextField txtTitre, textDate, txtHoraire;
        private JCheckBox CB_Entrainement;
        private JList LS_Events;
        private JButton btnSauvegarder, btnAnnuler;
        private CtrlEditerAct cea;
        private JButton btnSupprimer, btnNouveau;
        private JSplitPane SP_Edition, SP_Central;
        private boolean mode, modeEditionEntrainement;
        private int selected;

        public VueEditerActivites(JFrame _fen,String _title, CtrlEditerAct _cea, boolean modeEditionEntrainement) {
                super(_fen, _title, true);
                this.modeEditionEntrainement=modeEditionEntrainement;
                this.cea=_cea;                
                this.setBounds(100, 100, 450, 300);
                setLocationRelativeTo(_fen);
                this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setLayout(new BorderLayout(0, 0));
                setContentPane(contentPane);
                this.mode = false;
                
                SP_Central = new JSplitPane();
                SP_Central.setEnabled(true);
                contentPane.add(SP_Central, BorderLayout.CENTER);
                
                LS_Events = new JList();
                SP_Central.setLeftComponent(LS_Events);
                LS_Events.addMouseListener(this);
                
                SP_Edition = new JSplitPane();
                SP_Edition.setEnabled(false);
                SP_Edition.setResizeWeight(0.2);
                SP_Central.setRightComponent(SP_Edition);
                SP_Central.setResizeWeight(0.4);
                
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
                
                JPanel JP_Champs = new JPanel();
                SP_Edition.setRightComponent(JP_Champs);
                JP_Champs.setLayout(new GridLayout(4, 0, 0, 0));
                
                txtTitre = new JTextField();
                txtTitre.setText("Titre");
                JP_Champs.add(txtTitre);
                txtTitre.setColumns(10);
                txtTitre.setEditable(false);
                
                textDate = new JTextField();
                textDate.setText("JJ/MM/AAAA");
                JP_Champs.add(textDate);
                textDate.setColumns(10);
                textDate.setEditable(false);
                
                txtHoraire = new JTextField();
                txtHoraire.setText("HH:MM");
                JP_Champs.add(txtHoraire);
                txtHoraire.setColumns(10);
                txtHoraire.setEditable(false);
                
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
                
                this.addWindowListener(this);
        }

        public void majListeActivites(){
                String s;
                Activite a;
                Vector<String> v = new Vector<String>();
                
                this.LS_Events.removeAll();
                
                for (int i =0; i<this.cea.getListeActivite().size(); i++)
                {
                                a = this.cea.getListeActivite().get(i);
                                
                                if ( this.modeEditionEntrainement == true) {
                                        if(a.isEntrainement() == true){
                                                s = ("Entraînement "+a.getTitre()+ " " + a.getDate()+ " " + a.getHoraire());
                                                v.add(s);
                                        }
                                }
                                else {
                                        if(a.isEntrainement() == false){
                                                s = ("Ponctuel "+a.getTitre()+ " " + a.getDate()+ " " + a.getHoraire());
                                                v.add(s);
                                        }
                                }
                                
                }
                this.LS_Events.setListData(v);
                LS_Events.setSelectedIndex(-1);
        }

        public void windowActivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
        
        public void windowClosing(WindowEvent e) {
                this.cea.ctrlStopVueEditerAct();
        }
        
        public void windowDeactivated(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowOpened(WindowEvent e) {}
        public void actionPerformed(ActionEvent ae) {
                if(ae.getSource().equals(this.btnSupprimer)){
                        
                        this.cea.supprimerActivite(selected);
                        majListeActivites();
                        majActivite();
                        
                }
                if(ae.getSource().equals(this.btnAnnuler)){
                        this.cea.ctrlStopVueEditerAct();
                }
                if(ae.getSource().equals(this.btnSauvegarder)){
                        if(mode){
                                Activite ac;
                                ac = new Activite("Titre", "JJ/MM/YYYY", "HH:MM", new Vector<Membre>(), this.modeEditionEntrainement);
                                ac.setTitre(this.txtTitre.getText());
                                ac.setDate(this.textDate.getText());
                                ac.setHoraire(this.txtHoraire.getText());
                                this.cea.ajouterActivite(ac);
                                
                                majListeActivites();
                                majActivite();
                                mode = false;
                                majChamps(mode);
                                btnSauvegarder.setEnabled(false);
                                btnSupprimer.setEnabled(true);
                                LS_Events.setEnabled(true);
                                
                                
                        }
                }
                if(ae.getSource().equals(this.btnNouveau)){
                        mode = true;
                        majChamps(mode);
                        Activite ac;
                        ac = new Activite("Titre", "JJ/MM/YYYY", "HH:MM", new Vector<Membre>(),this.modeEditionEntrainement);
                        
                        this.txtTitre.setText(ac.getTitre());
                        this.textDate.setText(ac.getDate());
                        this.txtHoraire.setText(ac.getHoraire());
                        majListeActivites();
                        btnSauvegarder.setEnabled(true);
                        btnSupprimer.setEnabled(false);
                        LS_Events.setEnabled(false);
                }
        }
        
        public void mouseClicked(MouseEvent arg0) {}
        public void mouseEntered(MouseEvent arg0) {}
        public void mouseExited(MouseEvent arg0) {}
        public void mousePressed(MouseEvent arg0) {}
        public void mouseReleased(MouseEvent arg0) {
                if ( LS_Events.isEnabled())
                        this.majActivite();
        }
        
        public void majActivite(){
                Vector<Activite> ac;
                ac = cea.getListeActivite();
                Activite a=new Activite("","","",new Vector<Membre>(),this.modeEditionEntrainement);
                int j = -1;
                
                for (int i=0;i<ac.size();i++)
                {
                        if (this.modeEditionEntrainement == true) {
                                if (ac.get(i).isEntrainement() ==true )
                                        j++;
                        }
                        else {
                                if (ac.get(i).isEntrainement() ==false )
                                        j++;
                        }        
                        
                        
                        if (j==LS_Events.getSelectedIndex()) {
                                a=ac.get(i);
                                selected = i;
                                i=ac.size();        
                        }
                                
                }
                
                this.txtTitre.setText(a.getTitre());
                this.textDate.setText(a.getDate());
                this.txtHoraire.setText(a.getHoraire());
        }
        
        public void majChamps(boolean mode){
                txtTitre.setEditable(mode);
                textDate.setEditable(mode);
                txtHoraire.setEditable(mode);
        }
}