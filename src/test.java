

import java.io.File;
import java.util.Vector;

import Controleur.CtrlListeAct;
import Modele.Activite;
import Modele.Membre;

public class test {

	public static void main(String[] args) {
		
		System.out.println("test membre");
		
		Membre m;
		String nom;
		int i;
		
		//Initialisation d'un membre
		m=new Membre(0,"");
		nom=m.getNom();
		i=m.getIdMembre();
		
		//Test sur le nom du membre
		if(nom.equals("")){
			System.out.println("nom OK");
		}
		else
			System.out.println("nom NOK");
		
		//Test sur le id du membre
		if(i!=0){
			System.out.println("Problème idMembre NOK");
		}
		else
			System.out.println("i=="+i +" OK");
		
		//Modification de l'id et du nom du membre
		m.setIdMembre(5);
		m.setNom("test");
		i=m.getIdMembre();
		nom=m.getNom();
		
		//Test sur le nom modifié
		if(nom.equals("")){
			System.out.println("nom inchangé NOK");
		}
		else
			System.out.println("nom : "+nom+" OK");
		
		//Test sur l'id modifié
		if(i!=5){
			System.out.println("idMembre inchangé NOK");
		}
		else
			System.out.println("i=="+i+" OK");
		
		//------------------------------------------------------
		
		System.out.println();
		System.out.println("Test Activité");
		
		//Initialisation du vecteur de membre et de l'activité
		Vector<Membre> vm=new Vector<>();
		Activite a;
		vm.add(m);
		a=new Activite("a", "01", "b", vm, true);
		
		//Ajout d'un membre à l'activité
		m=new Membre(2, "nom");
		a.addParticipant(m);
		vm=a.getParticipants();
		
		//Test sur le nombre de membre dans l'activité
		if(vm.size()!=2)
			System.out.println("Pas d'ajout du membre");
		else{
			
			//Test sur les membres inscrit dans l'activité
			m=vm.get(0);
			if(m.getIdMembre()==5 && m.getNom().equals("test"))
				System.out.println("membre 0 OK");
			else
				System.out.println("membre 0 NOK");
			m=vm.get(1);
			if(m.getIdMembre()==2 && m.getNom().equals("nom"))
				System.out.println("membre 1 OK");
			else
				System.out.println("membre 1 NOK");
		}
		
		//Test sur le nom de l'activité
		nom=a.getTitre();
		if(nom=="a")
			System.out.println("titre OK");
		else
			System.out.println("titre NOK");
		
		//Modification du titre de l'activité
		a.setTitre("test");
		nom=a.getTitre();
		
		//Test sur le titre modifié
		if(nom=="test")
			System.out.println("titre modifié OK");
		else
			System.out.println("titre modifié NOK");
		
		//Test sur la date de l'activité
		nom=a.getDate();
		if(nom=="01")
			System.out.println("date OK");
		else 
			System.out.println("date NOK");
		
		//Modification de la date de l'activité
		a.setDate("01/01/13");
		
		//Test sur la date modifié
		if(a.getDate().equalsIgnoreCase("01/01/13"))
			System.out.println("date modif OK");
		else
			System.out.println("date modif NOK");
		
		//Test sur l'horaire de l'activité
		if(a.getHoraire()=="b")
			System.out.println("horaire OK");
		else
			System.out.println("horaire NOK");
		
		//Modification de l'horaire de l'activité
		a.setHoraire("14h");
		
		//Test sur l'horaire modifié
		if(a.getHoraire()=="14h")
			System.out.println("horaire modif OK");
		else
			System.out.println("horaire modif NOK");
		
		//Test pour savoir s'il est un entraineur
		if(a.isEntrainement()==true)
			System.out.println("Entraineur OK");
		else
			System.out.println("Entraineur NOK");
		
		a=new Activite("a", "01", "b", vm, false);
		if(a.isEntrainement()==false)
			System.out.println("Pas entraineur OK");
		else
			System.out.println("Pas entraineur NOK");
		
		//---------------------------------------------------
		
		System.out.println();
		System.out.println("Test CtrlListeAct");
		
		CtrlListeAct ctrl;
		
		//Initialisation du controleur de liste d'activité
		ctrl= new CtrlListeAct("test");
		
		//Test sur le nom du membre 
		if(ctrl.getNomMembre().equals("test"))
			System.out.println("Nom membre OK");
		else
			System.out.println("Nom membre NOK");
		
		//Test du nombre d'activité dans le controleur
		if(ctrl.getNbActivites() == 3)
			System.out.println("NB activité OK");
		else
			System.out.println("NB activité NOK : " + ctrl.getNbActivites());
		
		//Ajout d'une activité
		ctrl.addAct(a);
		
		//Test du nombre d'activité après ajout
		if(ctrl.getNbActivites() == 4)
			System.out.println("NB activité après ajout OK");
		else
			System.out.println("NB activité après ajout NOK : " + ctrl.getNbActivites());
		
		//Test sur l'activité ajouté
		if(ctrl.getListeActivite().get(3).equals(a))
			System.out.println("Activité OK");
		else
			System.out.println("Activité NOK");
		
		//Test sur le membre de membre de l'activité ajouté
		if(ctrl.getMembreActivite(3).get(1).equals(m))
			System.out.println("Membre OK");
		else
			System.out.println("Membre NOK");
		
		//Sauvegarde du controleur
		ctrl.sauvegarderListeActivite(ctrl.getListeActivite());
		
		//Test de la sauvegarde
		File f= new File("Activites");
		if(f.exists())
			System.out.println("Sauvegarde OK");
		else
			System.out.println("Sauvegarde NOK");
		
		//Enlévement de l'activité ajouté précédemment
		ctrl.removeAct(a);
		
		//Test sur le nombre d'activité
		if(ctrl.getNbActivites()==3)
			System.out.println("NB activité après le remove OK");
		else
			System.out.println("NB activité après le remove NOK : " + ctrl.getNbActivites());
		
		//Remise a zéro du controleur
		ctrl.removeAct(ctrl.getListeActivite().get(2));
		ctrl.removeAct(ctrl.getListeActivite().get(1));
		ctrl.removeAct(ctrl.getListeActivite().get(0));
		
		//Chargement du fichier
		ctrl.chargerListeActivite();
		
		//Test du chargement
		if(ctrl.getNbActivites()==4){
			if(ctrl.getNomMembre().equals("test"))
				System.out.println("Chargement et sauvegarde OK");
		}
		else
			System.out.println("NB activité NOK -> sauvegarde ou chargement NOK : " + ctrl.getNbActivites());
		
		//Réinisialisation du fichier de sauvegarde pour refaire les test
		ctrl.removeAct(ctrl.getListeActivite().get(3));
		ctrl.sauvegarderListeActivite(ctrl.getListeActivite());
	}

}
