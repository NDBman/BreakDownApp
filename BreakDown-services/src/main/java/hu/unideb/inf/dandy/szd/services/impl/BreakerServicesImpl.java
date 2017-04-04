package hu.unideb.inf.dandy.szd.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.RoleEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.RoleTypeEntity;
import hu.unideb.inf.dandy.szd.jpa.model.Breaker;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakerRepository;
import hu.unideb.inf.dandy.szd.jpa.repo.RoleRepository;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@Service
public class BreakerServicesImpl implements BreakerServices{


	@Autowired
	private BreakerRepository breakerRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BreakerEntity createBreaker(BreakerEntity breaker) {
		RoleEntity role = new RoleEntity();
		role.setRoleType(RoleTypeEntity.USER);
		roleRepository.save(role);
		breaker.setRole(role);
		breaker.setEnabled(true);
		return breakerRepository.save(breaker);
	}

	@Override
	public boolean matchingEmails(BreakerEntity breaker) {
		return breakerRepository.findByEmail(breaker.getEmail()) != null;
	}

	@Override
	@Transactional
	public Breaker legitAccount(String username, String password) {
		Long id = breakerRepository.findByUsername(username).getId();
		if(id == breakerRepository.findByPassword(password).getId()) {
			return modelMapper.map(breakerRepository.findOne(id), Breaker.class);
		}
		return null;
	}

}
