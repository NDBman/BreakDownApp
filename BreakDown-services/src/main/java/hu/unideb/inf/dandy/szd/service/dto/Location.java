package hu.unideb.inf.dandy.szd.service.dto;

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

	private Integer postalCode;
	private String city;
	private String street;
	private String houseNumber;
	
}
