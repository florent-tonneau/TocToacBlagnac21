/**************************************************************
 * Cette classe métier permet de définir un Membre.
 * 
 * 
 * @author Florent TONNEAU
 * @version 1.0
 **************************************************************/

package Modele;

public class Membre {
	//------------------------Attributs---------------------------
	// numero d'identification unique du membre
	private int idMembre;
	// nom du membre
	private String nom;
	
	//------------------------Constructeur------------------------
	/**
	 * Permet d'initialiser un nouveau membre avec son numéro
	 * d'identification et son nom.
	 * 
	 * @param _id
	 * @param _nom
	 */
	public Membre (int _id, String _nom) {
		this.idMembre=_id;
		this.nom=_nom;
	}

	//-----------------------Méthodes------------------------------
	/**
	 * Permet d'obtenir le numéro d'identifiant d'un membre.
	 * 
	 * @return int 
	 */
	public int getIdMembre() {
		return idMembre;
	}

	/**
	 * Permet de changer le numéro d'identifiant d'un membre
	 * 
	 * @param idMembre int
	 */
	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}

	/**
	 * Permet d'obtenir le nom d'un membre
	 * 
	 * @return String
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Permet de changer le nom d'un membre 
	 * 
	 * @param nom String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
