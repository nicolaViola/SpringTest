package it.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.servicies.ITrackerService;

@Controller
public class TrackerController {
	
	@Autowired
	private ITrackerService trackerService;
	
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
	public void doSomething(Model model) throws Exception{
		try{
			System.out.println("doSomething!");
			trackerService.getDataStream();
			trackerService.getDataStream2();
			System.out.println("done!");
		}catch(Exception e ){
			System.out.println("eccezione");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void admin(Model model) {
		System.out.println("admin!");
	}
	
	@RequestMapping(value = "/xsecure", method = RequestMethod.GET)
	public void xsecure(Model model) {
		System.out.println("xsecure!");
	}
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public void logout(Model model) {
//		System.out.println("logout!");
//	}
	
	
	
	


}
