package hu.unideb.inf.dandy.szd.jpa.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
	
	private Long id;
	private RoleType roleType;
}
