package hu.unideb.inf.dandy.szd.services.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEventEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.DiskJockeyEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.LocationEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEventEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakEventRepository;
import hu.unideb.inf.dandy.szd.jpa.repo.CompetitionRepository;
import hu.unideb.inf.dandy.szd.jpa.repo.DiskJockeyRepository;
import hu.unideb.inf.dandy.szd.jpa.repo.LocationRepository;
import hu.unideb.inf.dandy.szd.jpa.repo.SimpleEventRepository;
import hu.unideb.inf.dandy.szd.service.dto.Competition;
import hu.unideb.inf.dandy.szd.service.dto.Event;
import hu.unideb.inf.dandy.szd.services.NewCompetitionServices;

@Service
public class NewCompetitionServicesImpl implements NewCompetitionServices {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CompetitionRepository competitionRepository;
	
	@Autowired
	private SimpleEventRepository simpleEventRepository;
	
	@Autowired
	private BreakEventRepository breakEventRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private DiskJockeyRepository diskJockeyRepository;
	
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyy-MM-dd");
	
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
	@Transactional(propagation=Propagation.REQUIRED)
	public Competition createCompetition(String name, String compdate, Integer postalcode, String city, String street,
			String houseNumber, String description, List<String> diskjockeys, String events) throws IOException, ParseException{
		System.out.println(dateFormatter.parseObject(compdate));
		if(dateFormatter.parse(compdate).before(new Date())){
			return null;
		}
		String[] eventArray = events.split("},");
		List<Event> eventList = new ArrayList<>();
		for(int i = 0;i < eventArray.length-1;i++){
			eventArray[i] += "}";
		}
		for(String event : eventArray){
			JsonNode eventNode = new ObjectMapper().readTree(event);
			eventList.add(modelMapper.map(eventNode, Event.class));
		}
		CompetitionEntity newCompetitionEntity = new CompetitionEntity();
		List<BreakEventEntity> breakEvents = new ArrayList<>();
		List<SimpleEventEntity> simpleEvents = new ArrayList<>();
		for(Event event : eventList){
			if(event.isBreakevent()){
				BreakEventEntity breakEventEntity = new BreakEventEntity();
				breakEventEntity.setName(event.getTitle());
				breakEventEntity.setStartTime(new Timestamp(event.getStartTime()));
				breakEventEntity.setEndTime(new Timestamp(event.getEndTime()));
				breakEventEntity.setDescription(event.getDescription());
				breakEventEntity.setCompetition(newCompetitionEntity);
				breakEventRepository.save(breakEventEntity);
				breakEvents.add(breakEventEntity);
				
			}else{
				SimpleEventEntity simpleEventEntity = new SimpleEventEntity();
				simpleEventEntity.setName(event.getTitle());
				simpleEventEntity.setStartTime(new Timestamp(event.getStartTime()));
				simpleEventEntity.setEndTime(new Timestamp(event.getEndTime()));
				simpleEventEntity.setDescription(event.getDescription());
				simpleEventRepository.save(simpleEventEntity);
				simpleEvents.add(simpleEventEntity);
			}
		}
		List<DiskJockeyEntity> diskjockeyList = new ArrayList<>();
		for(String diskjockeyName : diskjockeys){
			DiskJockeyEntity diskjockeyEntity = new DiskJockeyEntity();
			diskjockeyEntity.setName(diskjockeyName);
			diskJockeyRepository.save(diskjockeyEntity);
			diskjockeyList.add(diskjockeyEntity);
		}
		
		newCompetitionEntity.setName(name);
		newCompetitionEntity.setBreakEvents(breakEvents);
		newCompetitionEntity.setSimpleEvents(simpleEvents);
		newCompetitionEntity.setDescription(description);
		newCompetitionEntity.setDiskJockeys(diskjockeyList);
		newCompetitionEntity.setOrganizer("ADMIN");
		LocationEntity locationEntity = new LocationEntity();
		locationEntity.setCompetition(newCompetitionEntity);
		locationEntity.setPostalCode(postalcode);
		locationEntity.setCity(city);
		locationEntity.setStreet(street);
		locationEntity.setHouseNumber(houseNumber);
		newCompetitionEntity.setLocation(locationEntity);
		locationRepository.save(locationEntity);
		
		newCompetitionEntity.setStartTime(new Timestamp(dateFormatter.parse(compdate).getTime()));
		Long realEndTime = 0L;
		for(SimpleEventEntity se : simpleEvents){
			if(se.getEndTime().getTime() > realEndTime){
				realEndTime = se.getEndTime().getTime();
			}
		}

		for(BreakEventEntity be : breakEvents){
			if(be.getEndTime().getTime() > realEndTime){
				realEndTime = be.getEndTime().getTime();
			}
		}
		newCompetitionEntity.setEndTime(new Timestamp(realEndTime));
		competitionRepository.save(newCompetitionEntity);
		
		return modelMapper.map(newCompetitionEntity, Competition.class);
	}

}
