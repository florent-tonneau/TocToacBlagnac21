package Modele;

public class Membre {
	private int idMembre;
	private String nom;
	
	
	public Membre (int _id, String _nom) {
		this.idMembre=_id;
		this.nom=_nom;
	}


	public int getIdMembre() {
		return idMembre;
	}


	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
}
