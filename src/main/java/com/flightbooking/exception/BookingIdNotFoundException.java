package com.flightbooking.exception;

public class BookingIdNotFoundException extends RuntimeException{
	String message;
	public BookingIdNotFoundException() {
		
	}
	public BookingIdNotFoundException(String message) {
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
		return "BookingIdNotFoundException [message=" + message + "]";
	}
	

}
