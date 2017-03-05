package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public enum Rank {

	ADMIN, ORGANIZER, USER;
}