package net.viralpatel.hibernate.mtm.xml;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Meeting {

	private Long meetingId;
	private String subject;
	private Date meetingDate;
	private Categorie categorie;

	private Set<Employe> employes = new HashSet<Employe>();
	
	/**
	 * All  Hibernate classes must have a constructor that doesn't take any parameters.
	 */
	public Meeting() {
		super();
	}

	public Meeting(String subject, Categorie categorie) {
		this.subject = subject;
		this.meetingDate = new Date();
		this.categorie = categorie;
	}
	
	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	
	
//	@Override
//	public String toString() 
//	{
//		return get+";"+get+";"+get+";"+get+";"+get;
//	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() 
	{
		return getMeetingId()+";"+getSubject()+";"+getMeetingDate()+";"+getEmployes();
	}
}
