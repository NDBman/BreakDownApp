package hu.unideb.inf.dandy.szd.service.dto;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEvent {

	private String name;
	private Timestamp startTime;
	private Timestamp endTime;
	private String descirption;
	
}
