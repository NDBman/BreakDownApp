package hu.unideb.inf.dandy.szd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import hu.unideb.inf.dandy.szd.jpa.entity.DiskJockeyEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.DiskJockeyRepository;
import hu.unideb.inf.dandy.szd.services.DiskJockeyServices;

public class DiskJockeyServicesImpl implements DiskJockeyServices {

	@Autowired
	private DiskJockeyRepository diskJockeyRepository;
	
	@Override
	public void newDiskJockey(String name) {
		DiskJockeyEntity newDiskJockey = new DiskJockeyEntity();
		newDiskJockey.setName(name);
		
		diskJockeyRepository.save(newDiskJockey);
	}

}
