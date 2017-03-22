package hu.unideb.inf.dandy.szd.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.Breaker;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakerRepository;

@Service("userDetailsService")
@Transactional
public class UserDetailsServicesImpl implements UserDetailsService {

	@Autowired
	private BreakerRepository breakerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Breaker breaker = breakerRepository.findByBboyName(username);
		if (breaker == null) {
			return new User("", "", true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_VIEWER")));
		}
		return new User(breaker.getBboyName(), breaker.getPassword(), breaker.isEnabled(), true, true, true,
				Arrays.asList(new SimpleGrantedAuthority(breaker.getRole().getRoleType().toString())));
	}

}
