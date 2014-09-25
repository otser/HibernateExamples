package net.viralpatel.hibernate.tpch;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Inheritance – Defines the inheritance strategy to be used for an entity class hierarchy. It is specified on the entity class that is the root of the entity class hierarchy.
//
//@DiscriminatorColumn – Is used to define the discriminator column for the SINGLE_TABLE and JOINED inheritance mapping strategies. 
//The strategy and the discriminator column are only specified in the root of an entity class hierarchy or sub hierarchy in which a different inheritance strategy is applied
//
//If the @DiscriminatorColumn annotation is missing, and a discriminator column is required, the name of the discriminator column defaults to "DTYPE" and the discriminator type to DiscriminatorType.STRING.
//
//@DiscriminatorValue – Is used to specify the value of the discriminator column for entities of the given type. The DiscriminatorValue annotation can only be specified on a concrete entity class. 
//If the DiscriminatorValue annotation is not specified and a discriminator column is used, a provider-specific function will be used to generate a value representing the entity type. 
//If the DiscriminatorType is STRING, the discriminator value default is the entity name.



@Entity(name="net.viralpatel.hibernate.tpch.Person")//Using Hibernate and JPA you cannot have two classes with the same name (on different packages) mapped. This raise an error at runtime: Caused by: org.hibernate.DuplicateMappingException: duplicate import:
@Table(name = "PERSON")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="discriminator",
    discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="P")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	private Long personId;
	
	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@Column(name = "LASTNAME")
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
}
