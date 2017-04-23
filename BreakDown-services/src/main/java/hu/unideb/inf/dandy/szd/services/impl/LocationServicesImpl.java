package hu.unideb.inf.dandy.szd.services.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.LocationEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.LocationRepository;
import hu.unideb.inf.dandy.szd.service.dto.Location;
import hu.unideb.inf.dandy.szd.services.LocationServices;

@Service
@Transactional
public class LocationServicesImpl implements LocationServices {

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LocationEntity createLocation(Integer postalCode, String city, String street, String houseNumber,
			CompetitionEntity competition) {
		LocationEntity newLocation = new LocationEntity();
		newLocation.setPostalCode(postalCode);
		newLocation.setCity(city);
		newLocation.setStreet(street);
		newLocation.setHouseNumber(houseNumber);
		newLocation.setCompetition(competition);

		return locationRepository.save(newLocation);
	}

	@Override
	public LocationEntity save(Location location) {
		return locationRepository.save(modelMapper.map(location, LocationEntity.class));
	}

}
