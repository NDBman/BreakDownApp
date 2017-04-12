package hu.unideb.inf.dandy.szd.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakerRepository;
import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@Service
public class BreakerServicesImpl implements BreakerServices{


	@Autowired
	private BreakerRepository breakerRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Breaker createBreaker(Breaker breaker) {
		breakerRepository.save(modelMapper.map(breaker, BreakerEntity.class));
		return breaker;
	}

	@Override
	public boolean matchingEmails(Breaker breaker) {
		return breakerRepository.findByEmail(breaker.getEmail()) != null;
	}

	@Override
	@Transactional
	public Breaker legitAccount(String email, String password) {
		Long id = breakerRepository.findByEmail(email).getId();
		if(id == breakerRepository.findByPassword(password).getId()) {
			return modelMapper.map(breakerRepository.findOne(id), Breaker.class);
		}
		return null;
	}

}
