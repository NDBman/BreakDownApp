package hu.unideb.inf.dandy.szd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.Breaker;
import hu.unideb.inf.dandy.szd.jpa.entity.Role;
import hu.unideb.inf.dandy.szd.jpa.entity.RoleType;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakerRepository;
import hu.unideb.inf.dandy.szd.jpa.repo.RoleRepository;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@Service
public class BreakerServicesImpl implements BreakerServices{


	@Autowired
	private BreakerRepository breakerRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Breaker createBreaker(Breaker breaker) {
		Role role = new Role();
		role.setRoleType(RoleType.USER);
		roleRepository.save(role);
		breaker.setRole(role);
		breaker.setEnabled(true);
		return breakerRepository.save(breaker);
	}

	@Override
	public boolean matchingEmails(Breaker breaker) {
		return breakerRepository.findByEmail(breaker.getEmail()) != null;
	}

}
