package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Competition extends AbstractEvent {

	@OneToMany
	private List<DiskJockey> diskJockeys;
	
	@OneToMany
	private List<Breaker> organizers;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition")
	private List<BreakEvent> breakEvents;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition")
	private List<SimpleEvent> simpleEvents;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="currentCompetition")
	private List<Breaker> competitors;
	
	@OneToOne
	private Location location;
}
