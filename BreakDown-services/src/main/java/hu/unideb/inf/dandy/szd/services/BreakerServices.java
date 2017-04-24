package hu.unideb.inf.dandy.szd.services;

import java.util.List;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.DummyBreaker;

public interface BreakerServices {

	public Breaker createBreaker(Breaker breaker);
	
	public boolean matchingEmails(Breaker breaker);
	
	public Breaker legitAccount(String username, String password);
	
	public BreakerEntity findByEmail(String email);
	
	public BreakerEntity save(BreakerEntity breakerEntity);
	
	public BreakerEntity findOne(Long id);
	
	public Breaker modifyData(Long id, String name, String username, String password, List<String> cities);
	
	public String getBreakerUsername(Long id);
	
	public List<DummyBreaker> getAllDummyBreakers();
	
	public DummyBreaker setRoleForBreaker(Long breakerId, boolean organizer, String email, String password);
}
