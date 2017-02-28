package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseName {

	private String password;
	private List<Privileges> privileges;
	
	private List<Competition> competitions;
	
	public User(){
		privileges = new ArrayList<>();
		privileges.add(Privileges.PARTICIPATE);
	}
	
}
