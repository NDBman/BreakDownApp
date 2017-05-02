package hu.unideb.inf.dandy.szd.services;

import java.util.List;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.Competition;
import hu.unideb.inf.dandy.szd.service.dto.DummyBreaker;

public interface BreakerServices {

	Breaker createBreaker(Breaker breaker);
	
	boolean matchingEmails(Breaker breaker);
	
	Breaker legitAccount(String username, String password);
	
	BreakerEntity findByEmail(String email);
	
	BreakerEntity save(BreakerEntity breakerEntity);
	
	BreakerEntity findOne(Long id);
	
	Breaker modifyData(Long id, String name, String username, String password, List<String> cities);
	
	String getBreakerUsername(Long id);
	
	List<DummyBreaker> getAllDummyBreakers();
	
	DummyBreaker setRoleForBreaker(Long breakerId, boolean organizer, String email, String password);
	
	List<Competition> getAllCompsOrganizedByUser(Long id);
	
	List<DummyBreaker> getAllBreakerSignedToComp(Long compId);
}
