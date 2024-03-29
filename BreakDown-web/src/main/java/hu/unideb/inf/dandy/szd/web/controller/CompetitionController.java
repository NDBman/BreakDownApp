package hu.unideb.inf.dandy.szd.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.Competition;
import hu.unideb.inf.dandy.szd.service.dto.Event;
import hu.unideb.inf.dandy.szd.services.CompetitionServices;
import hu.unideb.inf.dandy.szd.web.response.NoEventsException;
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
			@RequestParam(required = true) Integer endTimeMinute, @RequestParam(required = false) String description,
			@RequestParam boolean isbreakevent) {
		if (null == competitionServices.createEvent(eventname, startTimeHour, startTimeMinute, endTimeHour,
				endTimeMinute, description, isbreakevent)) {
			throw new TimeIntervalIsNegativeException();
		}
		return competitionServices.createEvent(eventname, startTimeHour, startTimeMinute, endTimeHour, endTimeMinute,
				description, isbreakevent);
	}

	@RequestMapping(value = "newcomp/createcomp", method = RequestMethod.POST)
	public ResponseEntity<Competition> createCompetition(@RequestParam(required = true) Long orgId,
			@RequestParam(required = true) String name, @RequestParam(required = true) String compdate,
			@RequestParam(required = true) Integer postalcode, @RequestParam(required = true) String city,
			@RequestParam(required = true) String street, @RequestParam(required = true) String housenumber,
			@RequestParam(required= false) String description, @RequestParam(required=false) List<String> diskjockeys,
			@RequestParam(required = false) String events) throws IOException, ParseException {
		
		Competition competition = null;
		try{
		competition = competitionServices.createCompetition(name, compdate, postalcode, city, street,
				housenumber, description, diskjockeys, events, orgId);
		}catch(NoEventsException e){
			return new ResponseEntity<Competition>(competition, HttpStatus.FORBIDDEN);
		}catch(TooEarlyDateExcpetion e){
			return new ResponseEntity<Competition>(competition, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Competition>(competition, HttpStatus.OK);
	}

	@GetMapping(value = "comps")
	public List<Competition> getAllCompetitions() {
		return competitionServices.getAllCompetitions();
	}

	@GetMapping("comp/{id}")
	public Competition getComp(@PathVariable("id") Long id) {
		return competitionServices.getCompetitionById(id);
	}

	@GetMapping("comp/{id}/events")
	public List<Event> getCompEvents(@PathVariable("id") Long id) {
		return competitionServices.getAllEvents(id);
	}

	@PostMapping("comp/{id}/signup")
	public Breaker signUpOrDownUserForCompetition(@PathVariable("id") Long id,
			@RequestParam(required = true) String email) {
		return competitionServices.signUpOrDownUserForCompetition(id, email);
	}

	@GetMapping("comps/{city}")
	public List<Competition> getCompetitionsInCity(@PathVariable("city") String city) {
		return competitionServices.getAllCompetitionsInCity(city);
	}
	
	@DeleteMapping("comp/{id}/delete")
	public void deleteComp(@PathVariable("id") Long id){
		competitionServices.deleteComp(id);
	}
	
	@GetMapping("comp/{id}/competitors")
	public List<String> getCompetitors(@PathVariable("id") Long id){
		return competitionServices.getAllCompetitorNames(id);
	}

	@PostMapping("comp/{compId}/finish")
	public Competition finishCompetition(@PathVariable("compId") Long compId, @RequestParam List<Long> winnerIds,
			@RequestParam List<String> winnerDescriptions) {
		return competitionServices.finishCompetition(compId, winnerIds, winnerDescriptions);
	}
}
