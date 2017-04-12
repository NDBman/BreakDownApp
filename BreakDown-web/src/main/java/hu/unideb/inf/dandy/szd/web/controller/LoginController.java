package hu.unideb.inf.dandy.szd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.LoginBreaker;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@Controller
public class LoginController {

	@Autowired
	private BreakerServices breakerServices;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Breaker> login(@RequestBody LoginBreaker breaker){
		Breaker foundBreaker = breakerServices.legitAccount(breaker.getUsername(), breaker.getPassword());
		if(foundBreaker != null){
			return new ResponseEntity<Breaker>(foundBreaker, HttpStatus.OK);
		}
		return new ResponseEntity<Breaker>(foundBreaker,HttpStatus.NOT_ACCEPTABLE);
	}
}
