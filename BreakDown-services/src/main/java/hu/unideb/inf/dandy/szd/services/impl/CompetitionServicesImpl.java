package hu.unideb.inf.dandy.szd.services.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEventEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.LocationEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEventEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.CompetitionRepository;
import hu.unideb.inf.dandy.szd.service.dto.BreakEvent;
import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.Competition;
import hu.unideb.inf.dandy.szd.service.dto.Event;
import hu.unideb.inf.dandy.szd.service.dto.SimpleEvent;
import hu.unideb.inf.dandy.szd.services.BreakEventServices;
import hu.unideb.inf.dandy.szd.services.BreakerServices;
import hu.unideb.inf.dandy.szd.services.CompetitionServices;
import hu.unideb.inf.dandy.szd.services.LocationServices;
import hu.unideb.inf.dandy.szd.services.SimpleEventServices;

@Service
@Transactional
public class CompetitionServicesImpl implements CompetitionServices {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CompetitionRepository competitionRepository;

	@Autowired
	private BreakEventServices breakEventServices;

	@Autowired
	private SimpleEventServices simpleEventServices;

	@Autowired
	private LocationServices locationServices;

	@Autowired
	private BreakerServices breakerServices;

	private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

	@Override
	public Event createEvent(String eventname, Integer startTimeHour, Integer startTimeMinute, Integer endTimeHour,
			Integer endTimeMinute, String description, boolean isbreakevent) {
		Long startTime = TimeUnit.HOURS.toMillis(startTimeHour - 1) + TimeUnit.MINUTES.toMillis(startTimeMinute);
		Long endTime = TimeUnit.HOURS.toMillis(endTimeHour - 1) + TimeUnit.MINUTES.toMillis(endTimeMinute);
		if (endTime <= startTime) {
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
	public Competition createCompetition(String name, String compdate, Integer postalcode, String city, String street,
			String houseNumber, String description, List<String> diskjockeys, String events)
			throws IOException, ParseException {
		if (dateFormatter.parse(compdate).before(new Date())) {
			return null;
		}
		String[] eventArray = events.split("},");
		List<Event> eventList = new ArrayList<>();
		for (int i = 0; i < eventArray.length - 1; i++) {
			eventArray[i] += "}";
		}
		for (String event : eventArray) {
			JsonNode eventNode = new ObjectMapper().readTree(event);
			eventList.add(modelMapper.map(eventNode, Event.class));
		}
		CompetitionEntity newCompetition = new CompetitionEntity();
		List<BreakEventEntity> breakEvents = new ArrayList<>();
		List<SimpleEventEntity> simpleEvents = new ArrayList<>();
		for (Event event : eventList) {
			if (event.isBreakevent()) {
				BreakEventEntity breakEvent = breakEventServices.createBreakEvent(event.getTitle(),
						event.getStartTime(), event.getEndTime(), event.getDescription(), newCompetition);
				breakEvents.add(breakEvent);

			} else {
				SimpleEventEntity simpleEvent = simpleEventServices.createSimpleEvent(event.getTitle(),
						event.getStartTime(), event.getEndTime(), event.getDescription(), newCompetition);
				simpleEvents.add(simpleEvent);
			}
		}
		List<String> diskjockeyList = new ArrayList<>();
		for (String diskjockeyName : diskjockeys) {
			diskjockeyList.add(diskjockeyName);
		}

		newCompetition.setName(name);
		newCompetition.setBreakEvents(breakEvents);
		newCompetition.setSimpleEvents(simpleEvents);
		newCompetition.setDiskJockeys(diskjockeyList);
		newCompetition.setDescription(description);
		newCompetition.setOrganizer("ADMIN");

		LocationEntity location = locationServices.createLocation(postalcode, city, street, houseNumber,
				newCompetition);
		newCompetition.setLocation(location);

		newCompetition.setStartTime(new Timestamp(dateFormatter.parse(compdate).getTime()));
		Long realEndTime = 0L;
		for (SimpleEventEntity se : simpleEvents) {
			if (se.getEndTime().getTime() > realEndTime) {
				realEndTime = se.getEndTime().getTime();
			}
		}

		for (BreakEventEntity be : breakEvents) {
			if (be.getEndTime().getTime() > realEndTime) {
				realEndTime = be.getEndTime().getTime();
			}
		}
		newCompetition.setEndTime(new Timestamp(realEndTime));

		return modelMapper.map(competitionRepository.save(newCompetition), Competition.class);
	}

	@Override
	@Transactional
	public List<Competition> getAllCompetitions() {
		List<CompetitionEntity> compEntites = competitionRepository.findAll();
		List<Competition> competitons = new ArrayList<>();
		for (CompetitionEntity compEntity : compEntites) {
			competitons.add(modelMapper.map(compEntity, Competition.class));
		}
		return competitons;
	}

	@Override
	@Transactional
	public Competition getCompetitionById(Long id) {
		return modelMapper.map(competitionRepository.findOne(id), Competition.class);
	}

	@Override
	public List<Event> getAllEvents(Long competitionId) {
		Competition competition = modelMapper.map(competitionRepository.findOne(competitionId), Competition.class);
		List<Event> eventList = new ArrayList<>();
		for (BreakEvent be : competition.getBreakEvents()) {
			eventList.add(modelMapper.map(be, Event.class));
		}
		for (SimpleEvent se : competition.getSimpleEvents()) {
			eventList.add(modelMapper.map(se, Event.class));
		}
		return eventList;
	}

	@Override
	public Breaker signUpOrDownUserForCompetition(Long compId, String email) {
		if (compId == null) {
			return null;
		}
		CompetitionEntity competitionEntity = competitionRepository.findOne(compId);
		BreakerEntity breakerEntity = breakerServices.findByEmail(email);
		if (competitionEntity.getCompetitorIds().contains(breakerEntity.getId())) {
			competitionEntity.getCompetitorIds().remove(breakerEntity.getId());
			breakerEntity.getCompetitions().remove(competitionEntity);
			competitionRepository.save(competitionEntity);
			breakerServices.save(breakerEntity);
			return modelMapper.map(breakerEntity, Breaker.class);
		}
		breakerEntity.getCompetitions().add(competitionEntity);
		competitionEntity.getCompetitorIds().add(breakerEntity.getId());
		breakerServices.save(breakerEntity);
		competitionRepository.save(competitionEntity);
		return modelMapper.map(breakerEntity, Breaker.class);
	}

	@Override
	public List<Competition> getAllCompetitionsInCity(String city) {
		List<CompetitionEntity> competitionEntities = competitionRepository.findAll().stream()
				.filter(c -> c.getLocation().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		List<Competition> competitions = new ArrayList<>();
		for(CompetitionEntity ce : competitionEntities){
			competitions.add(modelMapper.map(ce, Competition.class));
		}
		return competitions;
	}

}
