package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BreakEvent extends AbstractEvent {

	@ManyToMany(mappedBy="winnedEvents")
	private List<Breaker> winners;
	@ManyToOne
	@JoinColumn(name="competition", referencedColumnName="id")
	private Competition competition;
}
