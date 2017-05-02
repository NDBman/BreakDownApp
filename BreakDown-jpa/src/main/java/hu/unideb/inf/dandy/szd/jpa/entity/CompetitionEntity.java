package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompetitionEntity extends AbstractEventEntity {

	@ElementCollection
	private List<String> diskJockeys;
	
	private Long organizerId;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition")
	private List<BreakEventEntity> breakEvents;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="competition", fetch=FetchType.EAGER)
	private List<SimpleEventEntity> simpleEvents;
	
	@ElementCollection
	private List<Long> competitorIds;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<WinnerEntity> winners;
	
	private String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	private LocationEntity location;
	
	private boolean finished;
}
