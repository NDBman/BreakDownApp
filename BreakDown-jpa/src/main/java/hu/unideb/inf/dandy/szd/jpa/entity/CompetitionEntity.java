package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompetitionEntity extends AbstractEventEntity {

	@OneToMany
	private Set<DiskJockeyEntity> diskJockeys;
	
	@OneToMany
	private Set<BreakerEntity> organizers;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition")
	private Set<BreakEventEntity> breakEvents;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition")
	private Set<SimpleEventEntity> simpleEvents;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="currentCompetition")
	private Set<BreakerEntity> competitors;
	
	private String description;
	
	@OneToOne
	private LocationEntity location;
}
