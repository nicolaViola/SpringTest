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
	
//  http://localhost:8081/SpringTest/welcome
	@RequestMapping(value = "/doSomething", method = RequestMethod.GET)
	public void doSomething(Model model) {
		System.out.println("doSomething!");
	}
	
	@RequestMapping(value = "/xsecure", method = RequestMethod.GET)
	public void xsecure(Model model) {
		System.out.println("xsecure!");
	}
	
	
//	@RequestMapping(value = "/myLogin", method = RequestMethod.GET)
//	public void myLogin(Model model) {
//		System.out.println("myLogin!");
//	}

}
