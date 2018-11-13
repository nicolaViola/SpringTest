package it.model;

import org.springframework.http.HttpStatus;

public class MyError {
	
	private HttpStatus status;
	
	private String msg;

	public MyError(HttpStatus status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}
	
	
	

}
