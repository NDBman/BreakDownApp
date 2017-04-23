package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEventEntity;
import hu.unideb.inf.dandy.szd.service.dto.SimpleEvent;

public interface SimpleEventServices {

	public SimpleEventEntity createSimpleEvent(String name, Long startTime, Long endTime, String description, CompetitionEntity competition);
	public SimpleEventEntity save(SimpleEvent simpleEvent);
}
