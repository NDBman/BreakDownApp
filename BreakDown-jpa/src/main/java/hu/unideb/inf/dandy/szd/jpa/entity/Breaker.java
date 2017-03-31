package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="users")
public class Breaker extends BaseName {

	@Column(name="username")
	private String bboyName;
	private String password;
	private boolean enabled;
	@OneToOne
	private Role role;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="currentCompetition", referencedColumnName="id")
	private Competition currentCompetition;
	@OneToMany
	private List<Competition> pastCompetitions;
	@ManyToMany
	private List<BreakEvent> winnedEvents;
	private Gender gender;
	private Date birthday;
	@OneToMany
	private List<Location> interestedCities;
	
}
