package hu.unideb.inf.dandy.szd.services;

import java.util.List;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakEvent;
import hu.unideb.inf.dandy.szd.jpa.entity.Breaker;
import hu.unideb.inf.dandy.szd.jpa.entity.DiskJockey;
import hu.unideb.inf.dandy.szd.jpa.entity.Location;
import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEvent;

public interface CompetitionServices {

	public void createCompetition(List<Breaker> organizers, List<DiskJockey> diskJockeys, List<BreakEvent> breakEvents,
			List<SimpleEvent> simpleEvents, Location location);
}
