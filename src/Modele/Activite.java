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
	
	//Type de l'événement
	private boolean entrainement;
	
	//-----------------------Constructeur----------------------------
	/**
	 * Permet d'initialiser un événement.
	 *  
	 * @param _titre titre de l'activité
	 * @param _date date de l'activité
	 * @param _horaire horaire de l'activité
	 * @param _participants liste des participants
	 * @param _entrainement booleen true si c'est un entrainement
	 */
	public Activite(String _titre, String _date, String _horaire, Vector <Membre> _participants, boolean _entrainement){
		this.date=_date;
		this.horaire=_horaire;
		this.titre=_titre;
		this.entrainement=_entrainement;
		participants = new Vector<Membre>();
		
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
	 * Permet d'ajouter un membre à l'événement.
	 * 
	 * @param participant Membre
	 */
	public void addParticipant(Membre participant) {
		this.participants.add(participant);
	}

	/**
	 * Permet de savoir si l'activité est un entrainement
	 * 
	 * @return true si c'est un entrainement sinon false
	 */
	public boolean isEntrainement() {
		return entrainement;
	}
	
	
}
