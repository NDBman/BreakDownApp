package hu.unideb.inf.dandy.szd.web.controller;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.unideb.inf.dandy.szd.service.dto.Breaker;
import hu.unideb.inf.dandy.szd.service.dto.Role;
import hu.unideb.inf.dandy.szd.services.BreakerServices;
import hu.unideb.inf.dandy.szd.services.GenderServices;
import hu.unideb.inf.dandy.szd.web.response.EmailAlreadyExistsException;

@RestController
public class RegistrationController {
	
	@Autowired
	private BreakerServices breakerServices;
	
	@Autowired
	private GenderServices genderServices;
	
	private DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd");

	@RequestMapping(value="/reg", method=RequestMethod.POST)
	public Breaker registrateBreaker(@RequestParam(required = true) String name, @RequestParam(required = true) String username,
									@RequestParam(required = true) String email, @RequestParam(required = true) String password,
									@RequestParam(required = true) String birthday, @RequestParam(required = true) Long gender) throws ParseException{
		Breaker breaker = Breaker.builder()
						.name(name)
						.username(username)
						.email(email)
						.password(password)
						.birthday(dateFormatter.parse(birthday, Locale.US))
						.gender(genderServices.getGender(gender))
						.role(Role.USER)
						.build();
		if(breakerServices.matchingEmails(breaker)){
			throw new EmailAlreadyExistsException();
		}
		return breakerServices.createBreaker(breaker);
		
	}
}
