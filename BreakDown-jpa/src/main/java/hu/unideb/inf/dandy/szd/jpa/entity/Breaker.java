package hu.unideb.inf.dandy.szd.jpa.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Breaker extends BaseName {

	private String password;
	private Rank rank;
	
	@ManyToOne
	@JoinColumn(name="currentCompetition", referencedColumnName="id")
	private Competition currentCompetition;
	@OneToMany
	private List<Competition> pastCompetitions;
	@ManyToMany
	private List<BreakEvent> winnedEvents;
	private Gender gender;
	private Timestamp birthday;
	@OneToMany
	private List<Location> interestedCities;
	
}
