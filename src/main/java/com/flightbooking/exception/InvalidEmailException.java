package com.flightbooking.exception;

public class InvalidEmailException extends RuntimeException{
	String message;
	public InvalidEmailException() {
		
	}
	public InvalidEmailException(String message) {
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
		return "InvalidEmailException [message=" + message + "]";
	}
	
	

}
