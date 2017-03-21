package hu.unideb.inf.dandy.szd.web.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.unideb.inf.dandy.szd.services.BreakerServices;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private BreakerServices breakerServices;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="reg", method=RequestMethod.POST)
	public String registrate(@RequestParam(name = "name") String name,
			@RequestParam(name = "breaker_name") String bname, @RequestParam(name = "password") String password,
			@RequestParam(name = "password_a") String passwordAgain, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "birthday") String birthday) throws NumberFormatException, ParseException{
		System.out.println(birthday);
		breakerServices.createBreaker(name, bname, password, passwordAgain, birthday, Long.parseLong(gender));
		
		return "index";
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLogin(){
		return "login";
	}

	@RequestMapping("logout")
	public String logOut(){
		return "logout";
	}
}
