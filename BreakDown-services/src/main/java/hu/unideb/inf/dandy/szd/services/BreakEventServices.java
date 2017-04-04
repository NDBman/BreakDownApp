package hu.unideb.inf.dandy.szd.services;

import java.sql.Timestamp;

import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;

public interface BreakEventServices {

	public void createBreakEvent(String name, Timestamp startTime, Timestamp endTime, String description, CompetitionEntity competition);
}
