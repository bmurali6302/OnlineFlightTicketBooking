package com.flightbooking.exception;
public class FlightDetailsNotFoundException extends RuntimeException {
	String message;
	public FlightDetailsNotFoundException() {
		
	}
	public FlightDetailsNotFoundException(String message) {
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
		return "FlightDetailsNotFoundException [message=" + message + "]";
	}
	

}
