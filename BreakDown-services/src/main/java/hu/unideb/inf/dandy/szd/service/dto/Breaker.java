package hu.unideb.inf.dandy.szd.service.dto;

import java.util.Date;
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
public class Breaker {

	private Long id;
	private String name;
	private String username;
	private String password;
	private Role role;
	private String email;
	
	private List<Competition> competitions;
	private List<BreakEvent> winnedEvents;
	private Gender gender;
	private Date birthday;
	private List<Long> plannedComps;
	private List<String> interestedCities;
}
