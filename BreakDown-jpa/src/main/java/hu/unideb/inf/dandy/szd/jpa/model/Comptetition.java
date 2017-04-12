package hu.unideb.inf.dandy.szd.jpa.model;

import java.util.Set;

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
public class Comptetition extends AbstractEvent{

	private Set<DiskJockey> diskJockeys;
	private Set<Breaker> organizers;
	private Set<BreakEvent> breakEvents;
	private Set<SimpleEvent> simpleEvents;
	private Set<Breaker> competitors;
	private String description;
	private Location location;
}
