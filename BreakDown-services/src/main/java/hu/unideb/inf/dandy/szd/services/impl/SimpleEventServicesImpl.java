package hu.unideb.inf.dandy.szd.services.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.Competition;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEvent;
import hu.unideb.inf.dandy.szd.jpa.repo.SimpleEventRepository;
import hu.unideb.inf.dandy.szd.services.SimpleEventServices;

@Service
@Transactional
public class SimpleEventServicesImpl implements SimpleEventServices {

	@Autowired
	private SimpleEventRepository simpleEventRepository;
	
	@Override
	public void createSimpleEvent(String name, Timestamp startTime, Timestamp endTime, String description,
			Competition competition) {
		SimpleEvent newSimpleEvent = new SimpleEvent();
		
		newSimpleEvent.setName(name);
		newSimpleEvent.setStartTime(startTime);
		newSimpleEvent.setEndTime(endTime);
		newSimpleEvent.setDescription(description);
		newSimpleEvent.setCompetition(competition);
		
		simpleEventRepository.save(newSimpleEvent);
		
	}

}
