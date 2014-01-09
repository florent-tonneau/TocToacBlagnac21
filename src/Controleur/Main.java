package Controleur;

import java.util.Vector;

import javax.swing.UIManager;

import Modele.Activite;
import Modele.Membre;
import Vue.VueMembre;

public class Main {
	
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){
			System.out.println(e);
		}
		CtrlPrincipal cp=new CtrlPrincipal();	
	}

}
