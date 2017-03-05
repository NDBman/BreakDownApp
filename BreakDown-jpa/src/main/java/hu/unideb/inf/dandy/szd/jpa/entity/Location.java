package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Location extends BaseId{

	@Column(length=4)
	private int postalCode;
	private String city;
	private String street;
}
