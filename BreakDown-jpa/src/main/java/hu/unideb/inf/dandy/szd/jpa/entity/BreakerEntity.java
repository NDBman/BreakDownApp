package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreakerEntity extends BaseId {

	private String name;
	private String username;
	private String password;
	private boolean enabled;
	@OneToOne
	private RoleEntity role;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="currentCompetition", referencedColumnName="id")
	private CompetitionEntity currentCompetition;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<CompetitionEntity> pastCompetitions;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<BreakEventEntity> winnedEvents;
	private GenderEntity gender;
	private Date birthday;
	@OneToMany
	private Set<LocationEntity> interestedCities;
	
}
