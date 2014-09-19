package net.viralpatel.hibernate.mto.xml;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Employe {

	private Long employeId;

	private String firstname;

	private String lastname;

	private Date birthDate;

	private String cellphone;

	private Set<Adresse> adresses;

	public Employe() {
	}

	public Employe(String firstname, String lastname, Date birthdate,
			String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthdate;
		this.cellphone = phone;
	}

	public Employe(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.cellphone = phone;
	}
	
	@Override
	public boolean equals(Object emp) {
		if(emp instanceof Employe) {
			Employe employee = (Employe)emp;
			
			if(this.firstname.equals(employee.getFirstname()) &&
					this.lastname.equals(employee.getLastname()))
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

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}



	public void addAdresse(Adresse adresse) {
		adresse.setEmploye(this);
		if(adresses == null){
			adresses = new HashSet<Adresse>();
		}
		adresses.add(adresse);
		}
	
}
