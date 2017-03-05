package hu.unideb.inf.dandy.szd.web.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.unideb.inf.dandy.szd.jpa.entity.Gender;
import hu.unideb.inf.dandy.szd.services.BreakerServices;

@Controller
@RequestMapping("/")
public class BreadDownAppController {
	
	@Autowired
	private BreakerServices breakerServices;
	
	@RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Test Greeting.");
        return "index";
    }
	
	@RequestMapping(value="greet", method = RequestMethod.POST)
	public String greet(){
		return "greet";
	}
	
	@RequestMapping(value="back", method= RequestMethod.POST)
	public String goBack(){
		return "index";
	}
	
	@RequestMapping(value="newBreaker", method= RequestMethod.POST)
	public String newBreaker(@RequestParam(name= "username") String name, @RequestParam(name="password") String password){
		breakerServices.createBreaker(name, password, new Timestamp(1L), Gender.MALE);
		return "index";
	}
}
