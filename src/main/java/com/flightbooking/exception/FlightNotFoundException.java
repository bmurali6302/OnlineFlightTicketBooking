package com.flightbooking.exception;

public class FlightNotFoundException extends RuntimeException{
	String message;
	public FlightNotFoundException() {
		
	}
	public FlightNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
