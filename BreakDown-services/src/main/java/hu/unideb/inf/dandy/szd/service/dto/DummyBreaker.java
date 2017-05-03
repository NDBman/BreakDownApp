package hu.unideb.inf.dandy.szd.service.dto;

import java.util.Date;
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
	private List<Competition> competitions;
	private Gender gender;
	private Date birthday;
	private List<Long> plannedComps;
	private List<String> interestedCities;
	
	private List<Winner> wins;
	
	
}
