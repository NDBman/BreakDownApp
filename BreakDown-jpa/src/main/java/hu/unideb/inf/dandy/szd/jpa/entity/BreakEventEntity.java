package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BreakEventEntity extends AbstractEventEntity {

	@ManyToMany(mappedBy="winnedEvents")
	private Set<BreakerEntity> winners;
	@ManyToOne
	@JoinColumn(name="competition", referencedColumnName="id")
	private CompetitionEntity competition;
}
