/**********************************************
 * Cette classe métier permet de définir une activité/événement grâce à sa date,
 * l'horaire, le titre , et la liste des participants. 
 * 
 * @author Florent TONNEAU
 * @version 1.0
 **********************************************/
package Modele;

import java.util.Vector;

public class Activite {
	
	//----------------------------Attributs------------------------
	// Date de l'événement
	private String date;
	// Horaire de l'événement
	private String horaire;
	//Titre de l'activité
	private String titre;
	//Liste des participants
	private Vector<Membre> participants;
	
	//-----------------------Constructeur----------------------------
	/**
	 * Permet d'initialiser un événement.
	 *  
	 * @param _titre titre de l'activité
	 * @param _date date de l'activité
	 * @param _horaire horaire de l'activité
	 * @param _participants liste des participants
	 */
	public Activite(String _titre, String _date, String _horaire, Vector <Membre> _participants){
		this.date=_date;
		this.horaire=_horaire;
		this.titre=_titre;
		
		for (int i=0;i<_participants.size();i++)
			participants.add(_participants.elementAt(i));
	}
	
	//----------------------Méthodes----------------------
	/**
	 * Permet d'obtenir tous les participants de l'événement.
	 * 
	 * @return Vector<Membre>
	 */
	public Vector<Membre> getParticipants() {
		return this.participants;
	}

	/**
	 * Permet d'obtenir la date de l'activité
	 * 
	 * @return String
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Change la date de l'événement.
	 * 
	 * @param date String
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Permet d'obtenir l'horaire de l'événement.
	 * 
	 * @return String
	 */
	public String getHoraire() {
		return horaire;
	}

	/**
	 * Change l'horaire de l'événement avec le paramètre donné.
	 * 
	 * @param horaire String
	 */
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	/**
	 * Permet d'obtenir le titre de l'activité.
	 * 
	 * @return String
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Change le titre de l'événement avec celui donné en paramètre.
	 * 
	 * @param titre String
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Permet de d'ajouter un membre à l'événement.
	 * 
	 * @param participant Membre
	 */
	public void addParticipant(Membre participant) {
		this.participants.add(participant);
	}
	
	
}
