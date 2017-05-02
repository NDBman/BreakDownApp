package hu.unideb.inf.dandy.szd.service.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DummyBreaker {

	private Long id;
	private String name;
	private String username;
	private Role role;
	private String email;
	private boolean isOrganizer;

	private List<Winner> wins = new ArrayList<>();
	
	public DummyBreaker() {
		wins = new ArrayList<Winner>();
	}
	
}
