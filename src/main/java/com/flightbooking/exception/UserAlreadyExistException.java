package com.flightbooking.exception;

public class UserAlreadyExistException extends RuntimeException{
	private String message;
	public UserAlreadyExistException() {
		super();
		this.message = message;
	}
	public UserAlreadyExistException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public String toString() {
		return "UserNotFoundException:"+message;
	}


}
