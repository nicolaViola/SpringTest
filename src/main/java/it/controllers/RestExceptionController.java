package it.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.model.MyData;
import it.model.MyError;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class RestExceptionController {
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public MyError handle(IllegalArgumentException ex){
		System.out.println("handle");
		return new MyError(HttpStatus.NOT_FOUND, "mio errore");
	}

}
