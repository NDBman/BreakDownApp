package hu.unideb.inf.dandy.szd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.LoginBreaker;
import hu.unideb.inf.dandy.szd.services.BreakerServices;
import hu.unideb.inf.dandy.szd.web.response.UserDoesntExistsException;

@RestController
public class LoginController {

	@Autowired
	private BreakerServices breakerServices;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Breaker login(@RequestBody LoginBreaker loginBreaker){
		Breaker  breaker = breakerServices.legitAccount(loginBreaker.getEmail(), loginBreaker.getPassword());
		if(breaker == null){
			throw new UserDoesntExistsException();
		}
		return breaker;
		
	}
}
