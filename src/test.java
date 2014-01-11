
import java.util.Vector;

import Modele.Activite;
import Modele.Membre;

public class test {

	public static void main(String[] args) {
		System.out.println("test membre");
		Membre m;
		String nom;
		int i;
		m=new Membre(0,"");
		nom=m.getNom();
		i=m.getIdMembre();
		if(nom.equals("")){
			System.out.println("nom OK");
		}
		else
			System.out.println("nom=="+""+" OK");
		if(i!=0){
			System.out.println("Problème idMembre NOK");
		}
		else
			System.out.println("i=="+i +" OK");
		m.setIdMembre(5);
		m.setNom("test");
		i=m.getIdMembre();
		nom=m.getNom();
		if(nom.equals("")){
			System.out.println("nom inchangé NOK");
		}
		else
			System.out.println("nom : "+nom+" OK");
		if(i!=5){
			System.out.println("idMembre inchangé NOK");
		}
		else
			System.out.println("i=="+i+" OK");
		
		System.out.println("Test Activité");
		Vector<Membre> vm=new Vector<>();
		Activite a;
		vm.add(m);
		a=new Activite("a", "01", "b", vm, true);
		m=new Membre(2, "nom");
		a.addParticipant(m);
		vm=a.getParticipants();
		if(vm.size()!=2)
			System.out.println("Pas d'ajout du membre");
		else{
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
		nom=a.getTitre();
		if(nom=="a")
			System.out.println("titre OK");
		else
			System.out.println("titre NOK");
		a.setTitre("test");
		nom=a.getTitre();
		if(nom=="test")
			System.out.println("titre modifié OK");
		else
			System.out.println("titre modifié NOK");
		nom=a.getDate();
		if(nom=="01")
			System.out.println("date OK");
		else 
			System.out.println("date NOK");
		a.setDate("01/01/13");
		if(a.getDate().equalsIgnoreCase("01/01/13"))
			System.out.println("date modif OK");
		else
			System.out.println("date modif NOK");
		if(a.getHoraire()=="b")
			System.out.println("horaire OK");
		else
			System.out.println("horaire NOK");
		a.setHoraire("14h");
		if(a.getHoraire()=="14h")
			System.out.println("horaire modif OK");
		else
			System.out.println("horaire modif NOK");
	}

}
