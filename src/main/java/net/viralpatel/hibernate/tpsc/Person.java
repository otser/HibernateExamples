package net.viralpatel.hibernate.tpsc;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity(name="net.viralpatel.hibernate.tpsc.Person") //Using Hibernate and JPA you cannot have two classes with the same name (on different packages) mapped. This raise an error at runtime: Caused by: org.hibernate.DuplicateMappingException: duplicate import: 
@Table(name = "PERSON")
//JOINED is a strategy in which fields that are specific to a subclass are mapped to a separate table than the fields that are common to the parent class, and a join is performed to instantiate the subclass. 
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	private Long personId;
	
	@Basic(fetch=FetchType.LAZY) 
	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@Column(name = "LASTNAME")
	@Basic(fetch=FetchType.LAZY) 
	private String lastname;
	
	public Person() {
	
	}
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
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
	
	@Override
	public String toString() 
	{
		return getPersonId()+";"+getFirstname()+";"+getLastname();
	}
	
}
