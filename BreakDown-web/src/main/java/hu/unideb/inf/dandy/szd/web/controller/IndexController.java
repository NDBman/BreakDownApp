package hu.unideb.inf.dandy.szd.web.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.unideb.inf.dandy.szd.services.BreakerServices;
import hu.unideb.inf.dandy.szd.services.feedback.FeedbackCodes;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private BreakerServices breakerServices;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="index")
	public String indexToo(){
		return "index";
	}
	
	@RequestMapping(value="reg", method=RequestMethod.POST)
	public String registrate(@RequestParam(name = "name") String name,
			@RequestParam(name = "breaker_name") String bname, @RequestParam(name = "password") String password,
			@RequestParam(name = "password_a") String passwordAgain, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "birthday") String birthday, ModelMap model) throws NumberFormatException, ParseException{
		List<FeedbackCodes> feedbackCodes = breakerServices.createBreaker(name, bname, password, passwordAgain, birthday, Long.parseLong(gender));
		
		if(feedbackCodes.contains(FeedbackCodes.PASS))
			return "index";
		
		for(FeedbackCodes fbc : feedbackCodes){
			if(fbc == FeedbackCodes.NOT_MATCHING_PASSWORDS)
				model.addAttribute("password", "nomatch");
			if(fbc == FeedbackCodes.USERNAME_ALREADY_EXIST)
				model.addAttribute("username", "exists");
			if(fbc == FeedbackCodes.NULL_NAME)
				model.addAttribute("name", "null");
			if(fbc == FeedbackCodes.NULL_BBOYNAME)
				model.addAttribute("username", "null");
			if(fbc == FeedbackCodes.NULL_PASSWORD)
				model.addAttribute("password", "null");
			if(fbc == FeedbackCodes.NULL_PASSWORD_AGAIN)
				model.addAttribute("password_again", "null");
			if(fbc == FeedbackCodes.NULL_BIRTHDAY)
				model.addAttribute("birthday", "null");
				
		}
		return "redirect:index?regerror";
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoLogin(){
		return "login";
	}

	@RequestMapping("logout")
	public String logOut(){
		return "logout";
	}
}
