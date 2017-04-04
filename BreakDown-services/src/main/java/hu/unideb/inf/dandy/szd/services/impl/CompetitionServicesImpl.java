package hu.unideb.inf.dandy.szd.services.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEventEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.DiskJockeyEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.LocationEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEventEntity;
import hu.unideb.inf.dandy.szd.services.CompetitionServices;

@Service
public class CompetitionServicesImpl implements CompetitionServices{

	@Override
	public void createCompetition(Set<BreakerEntity> organizers, Set<DiskJockeyEntity> diskJockeys, Set<BreakEventEntity> breakEvents,
			Set<SimpleEventEntity> simpleEvents, LocationEntity location) {
		CompetitionEntity newCompetition = new CompetitionEntity();
		newCompetition.setOrganizers(organizers);
		newCompetition.setDiskJockeys(diskJockeys);
		newCompetition.setBreakEvents(breakEvents);
		newCompetition.setSimpleEvents(simpleEvents);
		newCompetition.setLocation(location);
	}

}
