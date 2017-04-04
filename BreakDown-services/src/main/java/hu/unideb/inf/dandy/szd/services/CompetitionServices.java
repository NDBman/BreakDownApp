package hu.unideb.inf.dandy.szd.services;

import java.util.Set;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEventEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.DiskJockeyEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.LocationEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEventEntity;

public interface CompetitionServices {

	public void createCompetition(Set<BreakerEntity> organizers, Set<DiskJockeyEntity> diskJockeys, Set<BreakEventEntity> breakEvents,
			Set<SimpleEventEntity> simpleEvents, LocationEntity location);
}
