package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends Organizer {

	public Admin(){
		getPrivileges().add(Privileges.GIVE_PRIVILIGES);
	}
}
