package net.viralpatel.hibernate.mtm.anno.extra1;

// default package
// Generated 9 sept. 2014 17:20:58 by Hibernate Tools 3.6.0

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 *	The @AssociationOverride annotation is used to override a many-to-one or one-to-one mapping of property or field for an entity relationship. - 
 *	See more at: http://www.javabeat.net/eclipselink-jpa-annotations-attributeoverride-associationoverride/#sthash.htxDwGk7.dpuf
 *	name (Required): This argument specify the name of the relationship property whose mapping is being overridden if property-based access is being used, or the name of the relationship field if field-based access is used.
 *	joinColumns (Required): This argument specify the join column that is being mapped to the persistent attribute. The mapping type will remain the same as is defined in the mapped superclass.
 *	- See more at: http://www.javabeat.net/eclipselink-jpa-annotations-attributeoverride-associationoverride/#sthash.htxDwGk7.dpuf
 */
@Entity(name="net.viralpatel.hibernate.mtm.anno.extra1.EmployePoste")
@Table(name = "employe_poste", catalog = "hibernate_examples")
@AssociationOverrides({@AssociationOverride(name = "id.employe", joinColumns = @JoinColumn(name = "EMPLOYE_ID")),
						@AssociationOverride(name = "id.poste", joinColumns = @JoinColumn(name = "POSTE_ID")) })
public class EmployePoste implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3038934675856281970L;
	private EmployePosteId id = new EmployePosteId();
//	private Employe employe;
//	private Poste poste;
	private Float remuneration;
	private Date dateEmbauche;
	private Date dateDebut;
	private Date dateFin;

	public EmployePoste() {
	}

	public EmployePoste(EmployePosteId id, Employe employe, Poste poste) {
		this.id = id;
		this.id.setEmploye(employe);
		this.id.setPoste(poste);
	}

	public EmployePoste(EmployePosteId id, Employe employe, Poste poste, Float remuneration, Date dateEmbauche, Date dateDebut, Date dateFin) {
		this.id = id;
		this.id.setEmploye(employe);
		this.id.setPoste(poste);
		this.remuneration = remuneration;
		this.dateEmbauche = dateEmbauche;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}	
	
	public EmployePoste(Employe employe, Poste poste, Float remuneration, Date dateEmbauche, Date dateDebut, Date dateFin) {
		this.id.setEmploye(employe);
		this.id.setPoste(poste);
		this.remuneration = remuneration;
		this.dateEmbauche = dateEmbauche;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	@EmbeddedId
//	@AttributeOverrides({
//			@AttributeOverride(name = "employeId", column = @Column(name = "employe_id", nullable = false)),
//			@AttributeOverride(name = "posteId", column = @Column(name = "poste_id", nullable = false)) })
	public EmployePosteId getId() {
		return this.id;
	}

	public void setId(EmployePosteId id) {
		this.id = id;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "employe_id", nullable = false, insertable = false, updatable = false)
	@Transient
	public Employe getEmploye() {
		return this.id.getEmploye();
	}

	public void setEmploye(Employe employe) {
		this.id.setEmploye(employe);
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "poste_id", nullable = false, insertable = false, updatable = false)
	@Transient
	public Poste getPoste() {
		return this.id.getPoste();
	}

	public void setPoste(Poste poste) {
		this.id.setPoste(poste);
	}

	@Column(name = "remuneration", precision = 12, scale = 0)
	public Float getRemuneration() {
		return this.remuneration;
	}

	public void setRemuneration(Float remuneration) {
		this.remuneration = remuneration;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_embauche", length = 10)
	public Date getDateEmbauche() {
		return this.dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut", length = 10)
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin", length = 10)
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
