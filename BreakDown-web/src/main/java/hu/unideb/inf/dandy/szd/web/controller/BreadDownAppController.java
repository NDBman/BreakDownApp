package hu.unideb.inf.dandy.szd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BreadDownAppController {

	@RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Test Greeting.");
        return "index";
    }
	
	@RequestMapping(value="greet", method = RequestMethod.POST)
	public String greet(){
		return "greet";
	}
	
}
