package hu.unideb.inf.dandy.szd.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Entity
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEvent extends BaseName{

	private Timestamp startTime;
	private Timestamp endTime;
	private String description;
	@ManyToOne
	@JoinColumn(name="competition", referencedColumnName="id")
	private Competition competition;
}
