package hu.unideb.inf.dandy.szd.web.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.unideb.inf.dandy.szd.services.BreakerServices;
import hu.unideb.inf.dandy.szd.services.feedback.FeedbackCodes;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private BreakerServices breakerServices;

	@RequestMapping(method = RequestMethod.POST, params = { "name" })
	public String registerNewBreaker(@RequestParam(name = "name") String name,
			@RequestParam(name = "bname") String bname, @RequestParam(name = "password") String password,
			@RequestParam(name = "password_again") String passwordAgain, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "birthday") String birthday) throws NumberFormatException, ParseException {

		List<FeedbackCodes> feedback = breakerServices.createBreaker(name, bname, password, passwordAgain, birthday, Long.parseLong(gender));
		for(FeedbackCodes fb : feedback){
			System.out.println(fb);
		}

		return "index";
	}
}
