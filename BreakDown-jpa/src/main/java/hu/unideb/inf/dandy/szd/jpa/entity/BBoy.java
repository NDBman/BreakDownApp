package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BBoy extends BaseName {

	private String password;
	private List<Privileges> privileges;
	@OneToMany
	private List<Competition> competitions;
	private Gender gender;
	
	public BBoy(){
		privileges = new ArrayList<>();
		privileges.add(Privileges.PARTICIPATE);
	}
	
}
