package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BreakEvent extends AbstractEvent {

	@ManyToMany(mappedBy="winnedEvents")
	private List<Breaker> winners;
}
