package hu.unideb.inf.dandy.szd.web.controller;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.services.BreakerServices;
import hu.unideb.inf.dandy.szd.services.GenderServices;

@Controller
public class RegistrationController {
	
	@Autowired
	private BreakerServices breakerServices;
	
	@Autowired
	private GenderServices genderServices;
	
	private DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd");

	@RequestMapping(value="/reg", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BreakerEntity> registrateBreaker(@RequestParam(required = true) String name, @RequestParam(required = true) String username,
									@RequestParam(required = true) String email, @RequestParam(required = true) String password,
									@RequestParam(required = true) String birthday, @RequestParam(required = true) Long gender) throws ParseException{
		BreakerEntity breaker = BreakerEntity.builder()
						.name(name)
						.username(username)
						.email(email)
						.password(password)
						.birthday(dateFormatter.parse(birthday, Locale.US))
						.gender(genderServices.getGender(gender))
						.build();
		if(breakerServices.matchingEmails(breaker)){
			return new ResponseEntity<BreakerEntity>(breaker, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<BreakerEntity>(breakerServices.createBreaker(breaker),HttpStatus.OK);
		
	}
}
