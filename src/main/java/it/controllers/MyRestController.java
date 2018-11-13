package it.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.model.MyData;

@RestController 
@RequestMapping("/rest")
public class MyRestController {
	
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	@GetMapping
	@RequestMapping(value = "/test")
	public Collection<MyData> /*ResponseEntity<String>*/ getData(@Value("{request.originalURL}") StringBuffer originalUrl){
		
		System.out.println(originalUrl);
		
		Collection<MyData> data = new ArrayList<>();
		
		MyData data1 = new MyData("admin", "ciao ciao");
		MyData data2 = new MyData("pippo", "eccomi");
		
		data.add(data1);
		data.add(data2);
		
		if(true)
			throw new IllegalArgumentException();
		
		return data;
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	@ExceptionHandler({IllegalArgumentException.class})
//	public void handleNotFound(){
//		System.out.println("hadle");
//	}

}
