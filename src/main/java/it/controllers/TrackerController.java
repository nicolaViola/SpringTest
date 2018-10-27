package it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrackerController {
	
//  http://localhost:8081/SpringTest/noAuthorization
	@RequestMapping(value = "/noAuthorization", method = RequestMethod.GET)
	public void noAuthorization(Model model) {
		System.out.println("noAuthorization!");
	}
	
//  http://localhost:8081/SpringTest/welcome
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public void welcome(Model model) {
		System.out.println("Entro nel sistema!");
	}

}
