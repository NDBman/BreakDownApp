package hu.unideb.inf.dandy.szd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.Competition;
import hu.unideb.inf.dandy.szd.service.dto.DummyBreaker;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@RestController
@RequestMapping("/")
public class BreakerController {

	@Autowired
	private BreakerServices breakerServices;

	@GetMapping("breaker/{id}")
	public Breaker getBreakerUsername(@PathVariable("id") Long id) {
		Breaker dummy = new Breaker();
		dummy.setUsername(breakerServices.getBreakerUsername(id));
		return dummy;
	}

	@GetMapping("getallusers")
	public List<DummyBreaker> getAllDummyBreakers() {
		return breakerServices.getAllDummyBreakers();
	}

	@PostMapping("breaker/{id}/setrole")
	public DummyBreaker setBreakerRole(@PathVariable("id") Long id, @RequestParam(required = true) boolean org,
			@RequestParam(required = true) String password, @RequestParam(required = true) String email) {
		return breakerServices.setRoleForBreaker(id, !org, email, password);
	}
	
	@GetMapping("breaker/{id}/comps")
	public List<Competition> getAllCompsOrganizedByUser(@PathVariable("id") Long id){
		return breakerServices.getAllCompsOrganizedByUser(id);
	}
	
	@GetMapping("breaker/allfrom/comp/{compId}")
	public List<DummyBreaker> gettAllBreakerSignedUpToComp(@PathVariable("compId") Long compId){
		return breakerServices.getAllBreakerSignedToComp(compId);
	}
}
