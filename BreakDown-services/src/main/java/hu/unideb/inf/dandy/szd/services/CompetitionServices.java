package hu.unideb.inf.dandy.szd.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.Competition;
import hu.unideb.inf.dandy.szd.service.dto.Event;

public interface CompetitionServices {

	public Event createEvent(String eventname, Integer startTimeHour, Integer startTimeMinute, Integer endTimeHour,
			Integer endTimeMinute, String description, boolean isbreakevent);

	public Competition createCompetition(String name, String compdate, Integer postalcode, String city, String street,
			String houseNumber, String description, List<String> diskjockeys, String events, Long oranizerId) throws IOException, ParseException;
	
	public List<Competition> getAllCompetitions();
	
	public Competition getCompetitionById(Long id);
	public List<Event> getAllEvents(Long competitionId);
	
	public Breaker signUpOrDownUserForCompetition(Long compId, String email);
	
	public List<Competition> getAllCompetitionsInCity(String city);
	
	public void deleteComp(Long id);
	
	public List<String> getAllCompetitorNames(Long id);
}
