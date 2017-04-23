package hu.unideb.inf.dandy.szd.service.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

	private Long id;
	private String title;
	private Long startTime;
	private Long endTime;
	private String description;
	private boolean breakevent;
	private List<Breaker> breakers;
	
}
