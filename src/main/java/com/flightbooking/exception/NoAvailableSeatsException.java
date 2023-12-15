package com.flightbooking.exception;

public class NoAvailableSeatsException extends RuntimeException {
	String message;

	public NoAvailableSeatsException(String message) {
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
