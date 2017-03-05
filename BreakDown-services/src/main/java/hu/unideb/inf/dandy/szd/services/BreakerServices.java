package hu.unideb.inf.dandy.szd.services;

import java.sql.Timestamp;

import hu.unideb.inf.dandy.szd.jpa.entity.Gender;

public interface BreakerServices {

	public void createBreaker(String name, String password, Timestamp birthday, Gender gender);
}
