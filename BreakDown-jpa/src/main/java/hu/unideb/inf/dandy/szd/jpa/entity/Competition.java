package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Competition extends AbstractEvent {

	private String djs;
	@OneToMany
	private List<Breaker> organizers;
	@OneToMany
	private List<AbstractEvent> events;
	private List<Breaker> competitors;
}
