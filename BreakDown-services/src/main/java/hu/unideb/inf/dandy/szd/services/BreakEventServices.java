package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEventEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.service.dto.BreakEvent;

public interface BreakEventServices {

	public BreakEventEntity createBreakEvent(String name, Long startTime, Long endTime, String description, CompetitionEntity competition);
	public BreakEventEntity save(BreakEvent breakEvent);
}
