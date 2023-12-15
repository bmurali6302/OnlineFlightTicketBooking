package com.flightbooking.exception;

public class PasswordMismatchException extends RuntimeException{
	String message;
	public PasswordMismatchException() {
		
	}
	public PasswordMismatchException(String message) {
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
		return "PasswordMismatchException [message=" + message + "]";
	}
	

}
