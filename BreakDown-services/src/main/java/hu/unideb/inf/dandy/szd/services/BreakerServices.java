package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;

public interface BreakerServices {

	public Breaker createBreaker(Breaker breaker);
	
	public boolean matchingEmails(Breaker breaker);
	
	public Breaker legitAccount(String username, String password);
}
