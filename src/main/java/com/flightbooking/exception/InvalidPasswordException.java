package com.flightbooking.exception;

public class InvalidPasswordException extends RuntimeException{
	String message;
	public InvalidPasswordException() {
		
	}
	public InvalidPasswordException(String message) {
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
		return "InvalidPasswordException [message=" + message + "]";
	}
	

}
