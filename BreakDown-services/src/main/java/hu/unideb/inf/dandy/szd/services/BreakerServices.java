package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.jpa.entity.Breaker;

public interface BreakerServices {

	public Breaker createBreaker(Breaker breaker);
	
	public boolean matchingEmails(Breaker breaker);
}
