package com.flightbooking.exception;

public class InvalidNameException extends RuntimeException{
	String message;
	public InvalidNameException() {
		
	}
	public InvalidNameException(String message) {
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
		return "InvalidNameException [message=" + message + "]";
	}
	

}
