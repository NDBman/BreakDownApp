package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Organizer extends User{

	public Organizer(){
		getPrivileges().add(Privileges.ORGANIZE_COMPETITION);
	}
}
