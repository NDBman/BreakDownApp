package hu.unideb.inf.dandy.szd.jpa.model;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleEvent extends AbstractEvent{

	private Comptetition competition;
}
