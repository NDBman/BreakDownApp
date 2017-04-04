package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.jpa.model.Breaker;

public interface BreakerServices {

	public BreakerEntity createBreaker(BreakerEntity breaker);
	
	public boolean matchingEmails(BreakerEntity breaker);
	
	public Breaker legitAccount(String username, String password);
}
