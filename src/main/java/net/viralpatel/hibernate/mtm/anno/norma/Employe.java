package net.viralpatel.hibernate.mtm.anno.norma;

// default package
// Generated 9 sept. 2014 17:20:58 by Hibernate Tools 3.6.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Employe generated by hbm2java
 */
@Entity(name="net.viralpatel.hibernate.mtm.anno.norma.Employe")
@Table(name = "employe", catalog = "hibernate_examples")
public class Employe implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7023276647890699153L;
	private Long employeId;
	private String firstname;
	private String lastname;
	private Date birthDate;
	private String cellPhone;
	private Set<Poste> postes = new HashSet<Poste>(0);

	public Employe() {
	}
	
	public Employe(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "employe_id", unique = true, nullable = false)
	public Long getEmployeId() {
		return this.employeId;
	}

	public void setEmployeId(Long employeId) {
		this.employeId = employeId;
	}

	

	

	@Column(name = "firstname", length = 50)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", length = 50)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "cell_phone", length = 15)
	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	

	
	//Here, the Employe is the owner side and the Poste is the other side.
	//Here, the @JoinTable annotation is used to specify the details of the join table (table name and two join columns - using the @JoinColumn annotation). 
	//The cascade attribute of the @ManyToMany annotation is required, so that Hibernate will update the associated "postes" when the "Employe" is updated.
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "employe_poste", catalog = "hibernate_examples", 
			joinColumns = { @JoinColumn(name = "EMPLOYE_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "POSTE_ID", nullable = false, updatable = false) })
	public Set<Poste> getPostes() {
		return postes;
	}

	public void setPostes(Set<Poste> postes) {
		this.postes = postes;
	}

	public void addPoste(Poste poste) {
		
		if(postes == null){
			postes = new HashSet<Poste>();
		}
		postes.add(poste);
		}
	
}
