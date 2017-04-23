package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.LocationEntity;
import hu.unideb.inf.dandy.szd.service.dto.Location;

public interface LocationServices {

	public LocationEntity createLocation(Integer postalCode, String city, String street, String houseNumber, CompetitionEntity competition);
	
	public LocationEntity save(Location location);
}
