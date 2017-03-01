package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Competition extends AbstractEvent {

	@Column(length=500)
	private List<String> djs;
	private List<Organizer> organizers;
	private List<Event> events;
	private int competitorNumber;
}
