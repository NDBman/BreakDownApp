package hu.unideb.inf.dandy.szd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@RestController
@RequestMapping("/")
public class ProfilController {
	
	@Autowired
	private BreakerServices breakerServices;

	@PostMapping("profil/modify")
	public Breaker modifyData(@RequestParam(required = true) Long userId, @RequestParam(required = true) String name,
			@RequestParam(required = true) String username, @RequestParam(required = true) String password,
			@RequestParam(required = false) List<String> cities) {
		return breakerServices.modifyData(userId, name, username, password, cities);
	}
}
