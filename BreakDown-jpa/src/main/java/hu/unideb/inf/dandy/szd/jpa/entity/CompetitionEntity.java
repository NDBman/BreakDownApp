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
public class CompetitionEntity extends AbstractEventEntity {

	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition")
	private List<DiskJockeyEntity> diskJockeys;
	
	private String organizer;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition")
	private List<BreakEventEntity> breakEvents;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition")
	private List<SimpleEventEntity> simpleEvents;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="currentCompetition")
	private List<BreakerEntity> competitors;
	
	private String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	private LocationEntity location;
}
