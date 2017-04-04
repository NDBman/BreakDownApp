package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;

public interface LocationServices {

	public void createLocation(Integer postalCode, String city, String street, Integer houseNumber, CompetitionEntity competition);
}
