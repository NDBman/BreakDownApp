package hu.unideb.inf.dandy.szd.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

	private Long id;
	private Integer postalCode;
	private String city;
	private String street;
	private Integer houseNumber;
	
	private Comptetition competition;
}
