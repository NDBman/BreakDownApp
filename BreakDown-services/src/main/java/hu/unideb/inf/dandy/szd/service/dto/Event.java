package hu.unideb.inf.dandy.szd.service.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

	private String title;
	private Timestamp startTime;
	private Timestamp endTime;
	private String description;
	private boolean breakevent;
	
}
