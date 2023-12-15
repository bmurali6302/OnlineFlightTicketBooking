package com.flightbooking.exception;

public class AdminNotFoundException extends RuntimeException{
	
	private String message;
	public AdminNotFoundException() {
	}
 
	public AdminNotFoundException(String message) {
		super();
		this.message = message;
	}
 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
 
	@Override
	public String toString() {
		return "AdminNotFoundException [message=" + message + "]";
	}


}
