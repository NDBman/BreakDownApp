package hu.unideb.inf.dandy.szd.jpa.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Breaker extends BaseName {

	private String password;
	private Rank rank;
	
	@OneToMany
	private List<Competition> competitions;
	private Gender gender;
	private Timestamp birthday;
	
}
