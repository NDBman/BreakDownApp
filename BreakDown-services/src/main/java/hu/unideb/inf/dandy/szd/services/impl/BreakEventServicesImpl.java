package hu.unideb.inf.dandy.szd.services.impl;

import java.sql.Timestamp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEventEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakEventRepository;
import hu.unideb.inf.dandy.szd.service.dto.BreakEvent;
import hu.unideb.inf.dandy.szd.services.BreakEventServices;

@Service
@Transactional
public class BreakEventServicesImpl implements BreakEventServices {

	@Autowired
	private BreakEventRepository breakEventRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BreakEventEntity createBreakEvent(String name, Long startTime, Long endTime, String description,
			CompetitionEntity competition) {
		BreakEventEntity newBreakEvent = new BreakEventEntity();

		newBreakEvent.setName(name);
		newBreakEvent.setStartTime(new Timestamp(startTime));
		newBreakEvent.setEndTime(new Timestamp(endTime));
		newBreakEvent.setDescription(description);
		newBreakEvent.setCompetition(competition);

		return breakEventRepository.save(newBreakEvent);
	}

	@Override
	public BreakEventEntity save(BreakEvent breakEvent) {
		return breakEventRepository.save(modelMapper.map(breakEvent, BreakEventEntity.class));
	}

}
