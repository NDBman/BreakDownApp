package hu.unideb.inf.dandy.szd.service.dto;

import lombok.Builder;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BreakEvent extends AbstractEvent {
	
	private Set<Breaker> winners;
	private Comptetition competition;
}
