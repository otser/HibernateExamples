package net.viralpatel.hibernate.oto.xml;

import java.io.Serializable;
import java.sql.Date;

public class Employe implements Serializable {

	private Long employeId;

	private String firstname;

	private String lastname;

	private Date birthDate;

	private String cellphone;

	private EmployeDetail employeDetail;

	public Employe() {

	}

	public Employe(String firstname, String lastname, Date birthdate,
			String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthdate;
		this.cellphone = phone;
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

	public EmployeDetail getEmployeDetail() {
		return employeDetail;
	}

	public void setEmployeDetail(EmployeDetail employeDetail) {
		this.employeDetail = employeDetail;
	}

	
}
