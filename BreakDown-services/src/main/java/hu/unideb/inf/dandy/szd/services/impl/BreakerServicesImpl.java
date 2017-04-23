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
@Transactional
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
	public Breaker legitAccount(String email, String password) {
		Long id;
		if((id= breakerRepository.findByEmail(email).getId()) != null){
			if(breakerRepository.findOne(id).getPassword().equals(password)){
				return modelMapper.map(breakerRepository.findOne(id),Breaker.class);
			}
		}
		return null;
	}

	@Override
	public BreakerEntity findByEmail(String email) {
		if(email == null){
			return null;
		}
		return breakerRepository.findByEmail(email);
	}

	@Override
	public BreakerEntity save(BreakerEntity breakerEntity) {
		return breakerRepository.save(breakerEntity);
	}

	@Override
	public BreakerEntity findOne(Long id) {
		return breakerRepository.findOne(id);
	}

}
