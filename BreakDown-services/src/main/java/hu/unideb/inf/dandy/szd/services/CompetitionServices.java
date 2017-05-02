package hu.unideb.inf.dandy.szd.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.Competition;
import hu.unideb.inf.dandy.szd.service.dto.Event;

public interface CompetitionServices {

	Event createEvent(String eventname, Integer startTimeHour, Integer startTimeMinute, Integer endTimeHour,
			Integer endTimeMinute, String description, boolean isbreakevent);

	Competition createCompetition(String name, String compdate, Integer postalcode, String city, String street,
			String houseNumber, String description, List<String> diskjockeys, String events, Long oranizerId) throws IOException, ParseException;
	
	List<Competition> getAllCompetitions();
	
	Competition getCompetitionById(Long id);
	List<Event> getAllEvents(Long competitionId);
	
	Breaker signUpOrDownUserForCompetition(Long compId, String email);
	
	List<Competition> getAllCompetitionsInCity(String city);
	
	void deleteComp(Long id);
	
	List<String> getAllCompetitorNames(Long id);
	
	Competition finishCompetition(Long compId, List<Long> winnerIds, List<String> winnerDescriptions);
}
