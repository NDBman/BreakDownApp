package hu.unideb.inf.dandy.szd.services;

import java.io.IOException;
import java.util.List;

import hu.unideb.inf.dandy.szd.service.dto.Comptetition;
import hu.unideb.inf.dandy.szd.service.dto.Event;

public interface NewCompetitionServices {

	public Event createEvent(String eventname, Integer startTimeHour, Integer startTimeMinute, Integer endTimeHour,
			Integer endTimeMinute, String description, boolean isbreakevent);

	public Comptetition createCompetition(String name, String compdate, Integer postalcode, String city, String street,
			Integer houseNumber, String description, List<String> diskjockeys, List<String> events) throws IOException;
}
