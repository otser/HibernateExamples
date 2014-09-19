package net.viralpatel.hibernate.tpsc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="OWNER")
//Owner classes is child of Person class. Thus while specifying the mappings, we used @PrimaryKeyJoinColumn to map it to parent table.
//@PrimaryKeyJoinColumn – This annotation specifies a primary key column that is used as a foreign key to join to another table.
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class Owner extends Person {

	@Column(name="stocks")
	private Long stocks;
	
	@Column(name="partnership_stake")
	private Long partnershipStake;

	public Owner() {
	}
	
	public Owner(String firstname, String lastname, Long stocks, Long partnershipStake) {
		
		super(firstname, lastname);
		
		this.stocks = stocks;
		this.partnershipStake = partnershipStake;
	}

	public Long getStocks() {
		return stocks;
	}

	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}

	public Long getPartnershipStake() {
		return partnershipStake;
	}
	
	@Override
	public String toString() 
	{
		return getPersonId()+";"+getFirstname()+";"+getLastname()+";"+getStocks()+";"+getPartnershipStake();
	}

	public void setPartnershipStake(Long partnershipStake) {
		this.partnershipStake = partnershipStake;
	}
	
}
