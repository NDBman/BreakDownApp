package hu.unideb.inf.dandy.szd.services.impl;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.unideb.inf.dandy.szd.service.dto.Comptetition;
import hu.unideb.inf.dandy.szd.service.dto.Event;
import hu.unideb.inf.dandy.szd.services.NewCompetitionServices;

@Service
public class NewCompetitionServicesImpl implements NewCompetitionServices {
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Event createEvent(String eventname, Integer startTimeHour, Integer startTimeMinute,
			Integer endTimeHour, Integer endTimeMinute, String description, boolean isbreakevent) {
		Timestamp startTime = new Timestamp(TimeUnit.HOURS.toMillis(startTimeHour - 1) + TimeUnit.MINUTES.toMillis(startTimeMinute));
		Timestamp endTime = new Timestamp(TimeUnit.HOURS.toMillis(endTimeHour -1) + TimeUnit.MINUTES.toMillis(endTimeMinute));
		if(endTime.getTime() <= startTime.getTime()){
			return null;
		}
		Event event = new Event();
		event.setTitle(eventname);
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		event.setDescription(description);
		event.setBreakevent(isbreakevent);
		return event;
		
	}

	@Override
	public Comptetition createCompetition(String name, String compdate, Integer postalcode, String city, String street,
			Integer houseNumber, String description, List<String> diskjockeys, List<String> events) throws IOException {
		List<Event> eventEvents = new ArrayList<>();
		System.out.println(events);
		for(String event : events){
			System.out.println(event);
			JsonNode eventNode = new ObjectMapper().readTree(event);
			eventEvents.add(modelMapper.map(eventNode, Event.class));
			System.out.println(modelMapper.map(eventNode, Event.class).getTitle());
		}
		return null;
	}

}
