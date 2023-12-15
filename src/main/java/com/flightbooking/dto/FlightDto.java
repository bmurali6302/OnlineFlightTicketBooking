package com.flightbooking.dto;

import java.time.LocalDate;

public class FlightDto {
	private int flightId;
	private String departureLocation;
	private String arrivalLocation;
	private LocalDate departureTime;
	private LocalDate arrivalTime;
	private int remainingEconomySeats;
	private int remainingPremiumSeats;
	private int remainingBusinessSeats;
	public FlightDto() {
		
	}
	public FlightDto(int flightId, String departureLocation, String arrivalLocation, LocalDate departureTime,
			LocalDate arrivalTime, int remainingEconomySeats, int remainingPremiumSeats, int remainingBusinessSeats) {
		super();
		this.flightId = flightId;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.remainingEconomySeats = remainingEconomySeats;
		this.remainingPremiumSeats = remainingPremiumSeats;
		this.remainingBusinessSeats = remainingBusinessSeats;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public LocalDate getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDate getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getRemainingEconomySeats() {
		return remainingEconomySeats;
	}
	public void setRemainingEconomySeats(int remainingEconomySeats) {
		this.remainingEconomySeats = remainingEconomySeats;
	}
	public int getRemainingPremiumSeats() {
		return remainingPremiumSeats;
	}
	public void setRemainingPremiumSeats(int remainingPremiumSeats) {
		this.remainingPremiumSeats = remainingPremiumSeats;
	}
	public int getRemainingBusinessSeats() {
		return remainingBusinessSeats;
	}
	public void setRemainingBusinessSeats(int remainingBusinessSeats) {
		this.remainingBusinessSeats = remainingBusinessSeats;
	}
	
	
}
