package hu.unideb.inf.dandy.szd.service.dto;

import java.util.List;

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

	private Long id;
	private List<String> diskJockeys;
	private String organizerId;
	private List<BreakEvent> breakEvents;
	private List<SimpleEvent> simpleEvents;
	private List<Long> competitorIds;
	private String description;
	private Location location;
	private boolean finished;
	private List<Winner> winners;
}
