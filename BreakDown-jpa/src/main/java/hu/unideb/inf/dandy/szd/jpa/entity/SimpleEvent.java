package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SimpleEvent extends AbstractEvent {

	@ManyToOne
	@JoinColumn(name="competition", referencedColumnName="id")
	private Competition competition;
}
