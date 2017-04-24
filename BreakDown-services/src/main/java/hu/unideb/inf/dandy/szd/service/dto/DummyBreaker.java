package hu.unideb.inf.dandy.szd.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DummyBreaker {

	private Long id;
	private String name;
	private String username;
	private Role role;
	private boolean isOrganizer;
}
