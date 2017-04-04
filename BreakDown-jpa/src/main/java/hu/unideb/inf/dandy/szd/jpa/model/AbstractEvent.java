package hu.unideb.inf.dandy.szd.jpa.model;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEvent {

	private Long id;
	private String name;
	private Timestamp startTime;
	private Timestamp endTime;
	private String descirption;
	
}
