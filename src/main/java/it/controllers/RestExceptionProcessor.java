package it.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.controllers.c2.MyRestoController2;
import it.model.MyData;

//@ControllerAdvice(assignableTypes = {MyRestoController2.class})
//@ControllerAdvice(basePackages = {"it.controllers.c1"})
@ControllerAdvice
public class RestExceptionProcessor {
	
	@ExceptionHandler
	//@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public MyData exception(Exception e){
		return new MyData("nic", e.getMessage());
	}

}
