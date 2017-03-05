package hu.unideb.inf.dandy.szd.services.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.Breaker;
import hu.unideb.inf.dandy.szd.jpa.entity.Gender;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakerRepository;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@Service
public class BreakerServicesImpl implements BreakerServices{


	@Autowired
	private BreakerRepository breakerRepository;
	
	public void createBreaker(String name, String password, Timestamp birthday, Gender gender){
		Breaker newBreaker = new Breaker();
		newBreaker.setName(name);
		newBreaker.setPassword(password);
		newBreaker.setBirthday(birthday);
		newBreaker.setGender(gender);
		breakerRepository.save(newBreaker);
	}
	
	
}
