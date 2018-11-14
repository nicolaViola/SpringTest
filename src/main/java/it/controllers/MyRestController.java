package it.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@GetMapping
	@RequestMapping(value = "/test/{userName}", method = RequestMethod.GET)
	public MyData getMyData(@PathVariable("userName") String user){
		return new MyData(user, "ciao ciao");
	}
	
	@RequestMapping(value = "/test2/{userName}", method = RequestMethod.GET)
	public MyData/*ResponseEntity<MyData> */ putMyData(@PathVariable("userName") String user){
		System.out.println("entro");
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
		return new MyData(user, "ciao2 ciao2");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public void/*ResponseEntity<MyData> */ postMyDataObject(/*@PathVariable("userName") String user*/  /*,  MyData myData*/){
		System.out.println("entro");
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
	}
	
	
	
	
	
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	@ExceptionHandler({IllegalArgumentException.class})
//	public void handleNotFound(){
//		System.out.println("hadle");
//	}

}
