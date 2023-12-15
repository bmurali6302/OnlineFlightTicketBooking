package com.flightbooking.exception;

public class EntityNotFoundException extends RuntimeException{
	String message;

	public EntityNotFoundException(String message) {
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
		return "EntityNotFoundException [message=" + message + "]";
	}
	

}
