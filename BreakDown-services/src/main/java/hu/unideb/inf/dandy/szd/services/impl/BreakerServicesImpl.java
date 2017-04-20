package hu.unideb.inf.dandy.szd.services.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		System.out.println(breaker.getRole());
		breakerRepository.save(modelMapper.map(breaker, BreakerEntity.class));
		System.out.println(modelMapper.map(breaker, BreakerEntity.class).getRole());
		return breaker;
	}

	@Override
	public boolean matchingEmails(Breaker breaker) {
		return breakerRepository.findByEmail(breaker.getEmail()) != null;
	}

	@Override
	@Transactional
	public Breaker legitAccount(String email, String password) {
		Long id;
		if(breakerRepository.findByEmail(email) != null & breakerRepository.findByPassword(password) != null){
			if((id = breakerRepository.findByEmail(email).getId()) == breakerRepository.findByPassword(password).getId()){
				return modelMapper.map(breakerRepository.findOne(id), Breaker.class);
			}
		}
		return null;
	}

}
