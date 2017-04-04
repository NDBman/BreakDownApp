package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name= "roles")
public class RoleEntity extends BaseId{

	@Enumerated(EnumType.STRING)
	private RoleTypeEntity roleType;
}