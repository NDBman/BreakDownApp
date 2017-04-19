package hu.unideb.inf.dandy.szd.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

	private String title;
	private Long startTime;
	private Long endTime;
	private String description;
	private boolean breakevent;
	
}
