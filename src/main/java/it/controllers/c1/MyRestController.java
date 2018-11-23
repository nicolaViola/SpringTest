package it.controllers.c1;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import it.model.MyData;
import it.model.MyError;

@RestController
@RequestMapping("/rest")
public class MyRestController {
	
	//@GetMapping
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@RequestMapping(value = "/test/nonTrovato/{userName}", method = RequestMethod.GET)
	public void nonTrovato(@PathVariable("userName") String user) throws Exception{
		//return new MyData(user, "ciao ciao");
		throw new RuntimeException();
		//System.out.println("nonTrovato");
	}
	
	
	
	
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
	
	
	//esempio per far ritornare un formato xmlhttps://howtodoinjava.com/spring-restful/spring-rest-hello-world-xml-example/
	//curl --header "Accept: application/json" http://localhost:8081/SpringTest/rest/test2/xxx
	@RequestMapping(value = "/test2/{userName}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody MyData/*ResponseEntity<MyData> */ getMyData(@PathVariable("userName") String user){
		System.out.println("entro");
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
		return new MyData(user, "ciao2 ciao2");
	}
	
	//esempio per far ritornare un formato xmlhttps://howtodoinjava.com/spring-restful/spring-rest-hello-world-xml-example/
	//curl --header "Accept: application/json" http://localhost:8081/SpringTest/rest/testWithResponseEntity/xxx
	@RequestMapping(value = "/testWithResponseEntity/{userName}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<MyData> getMyDataWithResponseEntity(@PathVariable("userName") String user){
		System.out.println("entro");
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
		MyData myData = new MyData(user, "Aggiungo uno stato");
		ResponseEntity<MyData> responseEntity = new ResponseEntity<MyData>(myData, HttpStatus.OK);
		
		return responseEntity;
	}
	
	//esempio per far ritornare un formato xmlhttps://howtodoinjava.com/spring-restful/spring-rest-hello-world-xml-example/
	//curl --header "Accept: application/json" http://localhost:8081/SpringTest/rest/testWithResponseEntityError/xxx
	@RequestMapping(value = "/testWithResponseEntityError/{userName}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<?> getMyDataWithResponseEntityError(@PathVariable("userName") String user){
		System.out.println("entro");
		ResponseEntity<MyError> responseEntity = new ResponseEntity<MyError>(new MyError("s", "elemento non trovato"), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	//curl -i -X PUT -H "Content-Type: application/json" "Accept: application/json" -d '{"owner":"xxx","comment":"ciao2 ciao2"}' http://localhost:8081/SpringTest/rest/test2/xxx
	//invio un json e mi ritorna un xml
	@RequestMapping(value = "/test2/{userName}", method = RequestMethod.PUT, /*consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},*/ produces = {MediaType.APPLICATION_JSON_VALUE})
	public MyData updateMyData(@RequestBody MyData myData/*, UriComponentsBuilder uriComponentsBuilder*/){
		System.out.println("entro");
		
		//URI uri = uriComponentsBuilder.path("/rest/testContent/").port(3).build().toUri();
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
		myData.setComment("sono stato modificato");
		
		return myData;
	}
	
	//curl -i -X PUT -H "Content-Type: application/json" "Accept: application/json" -d '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><employee owner="xxx" comment="sono stato modificato"/>' http://localhost:8081/SpringTest/rest/testX/xxx
		//invio un json e mi ritorna un xml
		@RequestMapping(value = "/testX/{userName}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
		public MyData updateMyDataFromXml(@RequestBody MyData myData){
			System.out.println("entro");
			
			
			//return new ResponseEntity<MyData>(HttpStatus.CREATED);
			myData.setComment("sono stato modificato");
			
			return myData;
		}
		
		
	//curl http://localhost:8081/SpringTest/rest/testContent/xxx
	@RequestMapping(value = "/testContent/{userName}", method = RequestMethod.GET)
	public MyData  getMyDataWithContentNegotiation(@PathVariable("userName") String user){
		System.out.println("entro");
		return new MyData(user, "uso il content negotiation");
	}
	
	
	@RequestMapping(value = "/test2/{userName}", method = RequestMethod.DELETE)
	public void/*ResponseEntity<MyData> */ deleteMyData(@PathVariable("userName") String user){
		System.out.println("entro");
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
		//return new MyData(user, "ciao2 ciao2");
	}
	
	
	//curl --header "Accept: application/json" http://localhost:8081/SpringTest/rest/test3/ss
	@RequestMapping(value = "/test3/{userName}", method = RequestMethod.GET)
	public MyData/*ResponseEntity<MyData> */ getMyDataButException(@PathVariable("userName") String user){
		System.out.println("entro");
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
		throw new IllegalArgumentException("questo è un mio error");
	}
	
	//curl --header "Accept: application/json" http://localhost:8081/SpringTest/rest/testObject/xxx
	@RequestMapping(value = "/testObject/{userName}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public MyData getMyDataObject(@PathVariable("userName") String user){
		System.out.println("entro");
		//return new ResponseEntity<MyData>(HttpStatus.CREATED);
		MyData myData = new MyData(user, "Aggiungo uno stato");
		//ResponseEntity<MyData> responseEntity = new ResponseEntity<MyData>(myData, HttpStatus.OK);
		
		return myData;
	}
	
	//curl -i -X POST -H "Content-Type: application/json" "Accept: application/json" -d '{"owner":"xxx","comment":"ciao2 ciao2"}' http://localhost:8081/SpringTest/rest/testObject/xxx
		//invio un json e mi ritorna un xml
		@RequestMapping(value = "/testObject/{userName}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
		public MyData updateMyDataPost(@RequestBody MyData myData){
			System.out.println("entro");
			
			//URI uri = uriComponentsBuilder.path("/rest/testContent/").port(3).build().toUri();
			//return new ResponseEntity<MyData>(HttpStatus.CREATED);
			myData.setComment("sono stato modificato");
			
			return myData;
		}
	
	
	
	
	
	
}
