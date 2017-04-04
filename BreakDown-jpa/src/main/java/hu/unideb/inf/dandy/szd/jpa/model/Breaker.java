package hu.unideb.inf.dandy.szd.jpa.model;

import java.sql.Date;
import java.util.Set;

import hu.unideb.inf.dandy.szd.jpa.entity.GenderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Breaker {

	private Long id;
	private String name;
	private String username;
	private String password;
	private boolean enabled;
	private Role role;
	private String email;
	
	private Comptetition currentCompetition;
	private Set<Comptetition> pastCompetitions;
	private Set<BreakEvent> winnedEvents;
	private GenderEntity gender;
	private Date birthday;
	private Set<Location> interedtesCities;
}
