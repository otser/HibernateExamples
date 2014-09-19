package net.viralpatel.hibernate.otm.xml.list;

import java.sql.Date;

import sun.net.www.content.text.plain;

public class Employe {

	private Long employeId;

	private String firstname;

	private String lastname;

	private Date birthDate;

	private String cellphone;

	private Department department;

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

	public Long getEmployeId() {
		return employeId;
	}

	public void setEmployeId(Long employeeId) {
		this.employeId = employeeId;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
