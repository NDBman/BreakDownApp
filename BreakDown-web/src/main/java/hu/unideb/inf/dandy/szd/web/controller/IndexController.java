package hu.unideb.inf.dandy.szd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="registration")
	public String gotoRegistration(){
		return "registration";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLogin(){
		return "login";
	}
	
	@RequestMapping(value="admin/secret", method=RequestMethod.GET)
	public String gotoSecret(){
		return "admin/secret";
	}
}
