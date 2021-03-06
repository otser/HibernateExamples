package net.viralpatel.hibernate.mtm.xml;


import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employe {

	private Long employeId;
	private String firstname;
	private String lastname;
	private Date birthDate = new Date(); // Calendar.getInstance().getTime()
	private String cellphone = "00 00 00 00 00";

	private Set<Meeting> meetings = new HashSet<Meeting>();
	
	/**
	 * All  Hibernate classes must have a constructor that doesn't take any parameters.
	 */
	public Employe() {
	}

	public Employe(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@Override
	public boolean equals(Object emp) {
		if(emp instanceof Employe) {
			Employe Employe = (Employe)emp;
			
			if(this.firstname.equals(Employe.getFirstname()) &&
					this.lastname.equals(Employe.getLastname()))
				return true;
		}

		return false;
	}
	@Override
	public int hashCode() {
	
		return this.firstname.hashCode() + this.lastname.hashCode();
	}
	
	public Long getEmployeId() {
		return employeId;
	}

	public void setEmployeId(Long employeId) {
		this.employeId = employeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	
	@Override
	public String toString() 
	{
		return getEmployeId()+";"+getFirstname()+";"+getLastname()+";"+getBirthDate()+";"+getCellphone();
	}
	
}
