package hu.unideb.inf.dandy.szd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@RestController
@RequestMapping("/breaker/")
public class BreakerController {

	@Autowired
	private BreakerServices breakerServices;
	
	@GetMapping("{id}")
	public Breaker getBreakerUsername(@PathVariable("id") Long id){
		Breaker dummy = new Breaker();
		dummy.setUsername(breakerServices.getBreakerUsername(id));
		return dummy;
	}
	
}
