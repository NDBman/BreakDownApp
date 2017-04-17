package hu.unideb.inf.dandy.szd.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.unideb.inf.dandy.szd.service.dto.Comptetition;
import hu.unideb.inf.dandy.szd.service.dto.Event;
import hu.unideb.inf.dandy.szd.services.NewCompetitionServices;
import hu.unideb.inf.dandy.szd.web.response.TimeIntervalIsNegativeException;

@RestController
@RequestMapping("/newcomp")
public class NewCompetitionController {

	@Autowired
	private NewCompetitionServices newCompetitionServices;
	
	@RequestMapping(value = "/newevent", method = RequestMethod.POST)
	public Event createNewEvent(@RequestParam(required = true) String eventname,
			@RequestParam(required = true) Integer startTimeHour,
			@RequestParam(required = true) Integer startTimeMinute, @RequestParam(required = true) Integer endTimeHour,
			@RequestParam(required = true) Integer endTimeMinute, @RequestParam(required = true) String description,
			@RequestParam boolean isbreakevent) {
		if (null == newCompetitionServices.createEvent(eventname, startTimeHour, startTimeMinute, endTimeHour,
				endTimeMinute, description, isbreakevent)) {
			throw new TimeIntervalIsNegativeException();
		}
		return newCompetitionServices.createEvent(eventname, startTimeHour, startTimeMinute, endTimeHour,
				endTimeMinute, description, isbreakevent);
	}

	@RequestMapping(value= "/createcomp", method = RequestMethod.POST)
	public Comptetition createCompetition(@RequestParam(required = true) String name,
			@RequestParam(required = true) String compdate, @RequestParam(required = true) Integer postalcode,
			@RequestParam(required = true) String city, @RequestParam(required = true) String street,
			@RequestParam(required = true) Integer housenumber, @RequestParam String description,
			@RequestParam List<String> diskjockeys, @RequestParam(required=true) List<String> events) throws IOException {
		
		return newCompetitionServices.createCompetition(name, compdate, postalcode, city, street, housenumber, description, diskjockeys, events);
	}
}
