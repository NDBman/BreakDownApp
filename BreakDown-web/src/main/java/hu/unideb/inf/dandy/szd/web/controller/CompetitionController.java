package hu.unideb.inf.dandy.szd.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.unideb.inf.dandy.szd.service.dto.Competition;
import hu.unideb.inf.dandy.szd.service.dto.Event;
import hu.unideb.inf.dandy.szd.services.CompetitionServices;
import hu.unideb.inf.dandy.szd.web.response.TimeIntervalIsNegativeException;
import hu.unideb.inf.dandy.szd.web.response.TooEarlyDateExcpetion;

@RestController
@RequestMapping("/")
public class CompetitionController {

	@Autowired
	private CompetitionServices competitionServices;
	
	@RequestMapping(value = "newcomp/newevent", method = RequestMethod.POST)
	public Event createNewEvent(@RequestParam(required = true) String eventname,
			@RequestParam(required = true) Integer startTimeHour,
			@RequestParam(required = true) Integer startTimeMinute, @RequestParam(required = true) Integer endTimeHour,
			@RequestParam(required = true) Integer endTimeMinute, @RequestParam(required = true) String description,
			@RequestParam boolean isbreakevent) {
		if (null == competitionServices.createEvent(eventname, startTimeHour, startTimeMinute, endTimeHour,
				endTimeMinute, description, isbreakevent)) {
			throw new TimeIntervalIsNegativeException();
		}
		return competitionServices.createEvent(eventname, startTimeHour, startTimeMinute, endTimeHour,
				endTimeMinute, description, isbreakevent);
	}

	@RequestMapping(value= "newcomp/createcomp", method = RequestMethod.POST)
	public Competition createCompetition(@RequestParam(required = true) String name,
			@RequestParam(required = true) String compdate, @RequestParam(required = true) Integer postalcode,
			@RequestParam(required = true) String city, @RequestParam(required = true) String street,
			@RequestParam(required = true) String housenumber, @RequestParam String description,
			@RequestParam List<String> diskjockeys, @RequestParam(required=true) String events) throws IOException, ParseException {
		Competition competition = competitionServices.createCompetition(name, compdate, postalcode, city, street, housenumber, description, diskjockeys, events);
		if(competition == null){
			throw new TooEarlyDateExcpetion();
		}
		return competition;
	}
	
	@GetMapping(value="comps")
	public List<Competition> getAllCompetitions(){
		return competitionServices.getAllCompetitions();
	}
}
