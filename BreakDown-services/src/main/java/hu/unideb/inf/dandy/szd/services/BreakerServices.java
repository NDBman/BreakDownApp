package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.service.dto.Breaker;

public interface BreakerServices {

	public Breaker createBreaker(Breaker breaker);
	
	public boolean matchingEmails(Breaker breaker);
	
	public Breaker legitAccount(String username, String password);
	
	public BreakerEntity findByEmail(String email);
	
	public BreakerEntity save(BreakerEntity breakerEntity);
	
	public BreakerEntity findOne(Long id);
}
