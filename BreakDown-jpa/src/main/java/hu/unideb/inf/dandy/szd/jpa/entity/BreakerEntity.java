package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreakerEntity extends BaseId {

	private String name;
	private String username;
	private String password;
	private Long role;
	@Column(unique=true)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="currentCompetition", referencedColumnName="id")
	private CompetitionEntity currentCompetition;
	@OneToMany
	private List<CompetitionEntity> pastCompetitions;
	@ManyToMany
	private List<BreakEventEntity> winnedEvents;
	private Long gender;
	private Date birthday;
	@OneToMany
	private Set<LocationEntity> interestedCities;
	
}
