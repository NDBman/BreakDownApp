package hu.unideb.inf.dandy.szd.services.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEventEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakEventRepository;
import hu.unideb.inf.dandy.szd.services.BreakEventServices;

@Service
@Transactional
public class BreakEventServicesImpl implements BreakEventServices {

	@Autowired
	private BreakEventRepository breakEventRepository;
	
	@Override
	public void createBreakEvent(String name, Timestamp startTime, Timestamp endTime, String description,
			CompetitionEntity competition) {
		BreakEventEntity newBreakEvent = new BreakEventEntity();
		
		newBreakEvent.setName(name);
		newBreakEvent.setStartTime(startTime);
		newBreakEvent.setEndTime(endTime);
		newBreakEvent.setDescription(description);
		newBreakEvent.setCompetition(competition);
		
		breakEventRepository.save(newBreakEvent);
	}

}
