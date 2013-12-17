package Modele;

import java.util.Vector;

public class Event {
	private String date;
	private String horaire;
	private String titre;
	private Vector<Membre> participants;
	
	public Event(String _titre, String _date, String _horaire, Vector <Membre> _participants){
		this.date=_date;
		this.horaire=_horaire;
		this.titre=_titre;
		
		for (int i=0;i<_participants.size();i++)
			participants.add(_participants.elementAt(i));
	}
	
	public Vector<Membre> getParticipants() {
		return this.participants;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHoraire() {
		return horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setParticipants(Membre participant) {
		this.participants.add(participant);
	}
	
	
}
