package hu.unideb.inf.dandy.szd.services.impl;

import java.sql.Timestamp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEventEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.SimpleEventRepository;
import hu.unideb.inf.dandy.szd.service.dto.SimpleEvent;
import hu.unideb.inf.dandy.szd.services.SimpleEventServices;

@Service
@Transactional
public class SimpleEventServicesImpl implements SimpleEventServices {

	@Autowired
	private SimpleEventRepository simpleEventRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SimpleEventEntity createSimpleEvent(String name, Long startTime, Long endTime, String description,
			CompetitionEntity competition) {
		SimpleEventEntity newSimpleEvent = new SimpleEventEntity();

		newSimpleEvent.setName(name);
		newSimpleEvent.setStartTime(new Timestamp(startTime));
		newSimpleEvent.setEndTime(new Timestamp(endTime));
		newSimpleEvent.setDescription(description);
		newSimpleEvent.setCompetition(competition);

		return simpleEventRepository.save(newSimpleEvent);

	}

	@Override
	public SimpleEventEntity save(SimpleEvent simpleEvent) {
		return simpleEventRepository.save(modelMapper.map(simpleEvent, SimpleEventEntity.class));
	}

}
