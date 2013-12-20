/**********************************************
 * Cette classe m�tier permet de d�finir une activit�/�v�nement gr�ce � sa date,
 * l'horaire, le titre , et la liste des participants. 
 * 
 * @author Florent TONNEAU
 * @version 1.0
 **********************************************/
package Modele;

import java.util.Vector;

public class Activite {
	
	//----------------------------Attributs------------------------
	// Date de l'�v�nement
	private String date;
	// Horaire de l'�v�nement
	private String horaire;
	//Titre de l'activit�
	private String titre;
	//Liste des participants
	private Vector<Membre> participants;
	
	//-----------------------Constructeur----------------------------
	/**
	 * Permet d'initialiser un �v�nement.
	 *  
	 * @param _titre titre de l'activit�
	 * @param _date date de l'activit�
	 * @param _horaire horaire de l'activit�
	 * @param _participants liste des participants
	 */
	public Activite(String _titre, String _date, String _horaire, Vector <Membre> _participants){
		this.date=_date;
		this.horaire=_horaire;
		this.titre=_titre;
		
		for (int i=0;i<_participants.size();i++)
			participants.add(_participants.elementAt(i));
	}
	
	//----------------------M�thodes----------------------
	/**
	 * Permet d'obtenir tous les participants de l'�v�nement.
	 * 
	 * @return Vector<Membre>
	 */
	public Vector<Membre> getParticipants() {
		return this.participants;
	}

	/**
	 * Permet d'obtenir la date de l'activit�
	 * 
	 * @return String
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Change la date de l'�v�nement.
	 * 
	 * @param date String
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Permet d'obtenir l'horaire de l'�v�nement.
	 * 
	 * @return String
	 */
	public String getHoraire() {
		return horaire;
	}

	/**
	 * Change l'horaire de l'�v�nement avec le param�tre donn�.
	 * 
	 * @param horaire String
	 */
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	/**
	 * Permet d'obtenir le titre de l'activit�.
	 * 
	 * @return String
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Change le titre de l'�v�nement avec celui donn� en param�tre.
	 * 
	 * @param titre String
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Permet de d'ajouter un membre � l'�v�nement.
	 * 
	 * @param participant Membre
	 */
	public void addParticipant(Membre participant) {
		this.participants.add(participant);
	}
	
	
}
