package it.controllers.c2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.model.MyData;

@RestController
@RequestMapping("/rest2")
public class MyRestoController2 {
	
	@RequestMapping(value = "/test3/{userName}", method = RequestMethod.GET)
	public MyData/*ResponseEntity<MyData> */ getMyDataButException(@PathVariable("userName") String user){
		System.out.println("entro");
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
		throw new IllegalArgumentException("questo è un mio error");
	}
}
