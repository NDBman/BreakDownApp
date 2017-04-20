package hu.unideb.inf.dandy.szd.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Competition extends AbstractEvent{

	@JsonIgnore
	private List<DiskJockey> diskJockeys;
	private String organizer;
	@JsonIgnore
	private List<BreakEvent> breakEvents;
	@JsonIgnore
	private List<SimpleEvent> simpleEvents;
	private List<Breaker> competitors;
	private String description;
	private Location location;
}
