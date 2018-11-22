package it.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.controllers.c2.MyRestoController2;
import it.model.MyData;
import it.model.MyError;

//@ControllerAdvice(assignableTypes = {MyRestoController2.class})
//@ControllerAdvice(basePackages = {"it.controllers.c1"})
@ControllerAdvice
public class RestExceptionProcessor {
	
	@ExceptionHandler
	//@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public MyData exception(Exception e){
		e.printStackTrace();
		return new MyData("nic", e.getMessage());
	}

//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	@ExceptionHandler({IllegalArgumentException.class})
//	public ResponseEntity<MyError>  handleNotFound(){
//		return new ResponseEntity<MyError>(new MyError("x", "non trovo"), HttpStatus.NOT_FOUND);
//	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({IllegalArgumentException.class})
	public @ResponseBody MyError  handleNotFound(){
		return new MyError("x", "non trovo");
	}
}
