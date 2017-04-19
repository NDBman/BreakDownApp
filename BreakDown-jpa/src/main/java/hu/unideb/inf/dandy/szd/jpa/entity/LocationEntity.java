package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LocationEntity extends BaseId{

	@Column(length=4)
	private Integer postalCode;
	private String city;
	private String street;
	private String houseNumber;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="location")
	private CompetitionEntity competition;
}
