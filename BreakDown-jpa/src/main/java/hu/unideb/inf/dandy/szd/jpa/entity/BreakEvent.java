package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BreakEvent extends AbstractEvent {

	@OneToMany
	private List<Breaker> winners;
}
