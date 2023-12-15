package com.flightbooking.exception;

public class UserNotFoundException extends RuntimeException{
	
	private String message;
	public UserNotFoundException() {
		
	}
	public UserNotFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public String toString() {
		return "UserNotFoundException:"+message;
	}


}
