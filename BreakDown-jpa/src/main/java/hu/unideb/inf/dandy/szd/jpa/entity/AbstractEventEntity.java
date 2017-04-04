package hu.unideb.inf.dandy.szd.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEventEntity extends BaseName{

	private Timestamp startTime;
	private Timestamp endTime;
	private String description;
}
