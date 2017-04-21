package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DiskJockeyEntity extends BaseName {

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="competition", referencedColumnName="id")
	private CompetitionEntity competition;
}
