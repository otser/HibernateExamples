package net.viralpatel.hibernate.mto.xml.oto;


public class Adresse {

	private Long adresseId;
	private String street;
	private String city;
	private String state;
	private String country;
	private Employe employe;
	
	
	
	
	
	public Adresse() {
	}

	public Adresse(String street, String city, String state, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public Long getAdresseId() {
		return adresseId;
	}
	public void setAdresseId(Long adresseId) {
		this.adresseId = adresseId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	
	
	
}
