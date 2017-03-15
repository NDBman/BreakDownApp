package hu.unideb.inf.dandy.szd.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEvent;
import hu.unideb.inf.dandy.szd.jpa.entity.Breaker;
import hu.unideb.inf.dandy.szd.jpa.entity.Competition;
import hu.unideb.inf.dandy.szd.jpa.entity.DiskJockey;
import hu.unideb.inf.dandy.szd.jpa.entity.Location;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEvent;
import hu.unideb.inf.dandy.szd.services.CompetitionServices;

@Service
public class CompetitionServicesImpl implements CompetitionServices{

	@Override
	public void createCompetition(List<Breaker> organizers, List<DiskJockey> diskJockeys, List<BreakEvent> breakEvents,
			List<SimpleEvent> simpleEvents, Location location) {
		Competition newCompetition = new Competition();
		newCompetition.setOrganizers(organizers);
		newCompetition.setDiskJockeys(diskJockeys);
		newCompetition.setBreakEvents(breakEvents);
		newCompetition.setSimpleEvents(simpleEvents);
		newCompetition.setLocation(location);
	}

}
