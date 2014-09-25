package net.viralpatel.hibernate.mtm.xml.otm;


public class Poste {

	private Long posteId;
	private Float remBase;
	private Character categorie;
	private String description;
	private Employe employe;

	/**
	 * All  Hibernate classes must have a constructor that doesn't take any parameters.
	 */
	public Poste() {
		super();
	}

	
	public Poste(Float remBase, Character categorie, String description) {
		super();
		this.remBase = remBase;
		this.categorie = categorie;
		this.description = description;
	}


	public Long getPosteId() {
		return posteId;
	}

	public void setPosteId(Long posteId) {
		this.posteId = posteId;
	}

	public Float getRemBase() {
		return remBase;
	}

	public void setRemBase(Float remBase) {
		this.remBase = remBase;
	}

	public Character getCategorie() {
		return categorie;
	}

	public void setCategorie(Character categorie) {
		this.categorie = categorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	@Override
	public String toString() 
	{
		return getPosteId()+"; "+getCategorie()+"; "+getRemBase()+"; "+getDescription();
	}
}
