package hu.unideb.inf.dandy.szd.services;

import java.sql.Timestamp;

import hu.unideb.inf.dandy.szd.jpa.entity.Competition;

public interface BreakEventServices {

	public void createBreakEvent(String name, Timestamp startTime, Timestamp endTime, String description, Competition competition);
}
