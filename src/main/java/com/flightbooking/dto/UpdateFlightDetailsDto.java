package com.flightbooking.dto;

import jakarta.persistence.Column;

public class UpdateFlightDetailsDto {
	
	private int flightDetailsId;
	private double economyFare;
	private double premiumFare;
	private double businessFare;
	private int totalEconomySeats;
	private int totalPremiumSeats;
	private int totalBusinessSeats;
	private int remainingEconomySeats;
	private int remainingPremiumSeats;
	private int remainingBusinessSeats;
	public UpdateFlightDetailsDto() {
		
	}
	public UpdateFlightDetailsDto(int flightDetailsId, double economyFare, double premiumFare, double businessFare,
			int totalEconomySeats, int totalPremiumSeats, int totalBusinessSeats, int remainingEconomySeats,
			int remainingPremiumSeats, int remainingBusinessSeats) {
		super();
		this.flightDetailsId = flightDetailsId;
		this.economyFare = economyFare;
		this.premiumFare = premiumFare;
		this.businessFare = businessFare;
		this.totalEconomySeats = totalEconomySeats;
		this.totalPremiumSeats = totalPremiumSeats;
		this.totalBusinessSeats = totalBusinessSeats;
		this.remainingEconomySeats = remainingEconomySeats;
		this.remainingPremiumSeats = remainingPremiumSeats;
		this.remainingBusinessSeats = remainingBusinessSeats;
	}
	public int getFlightDetailsId() {
		return flightDetailsId;
	}
	public void setFlightDetailsId(int flightDetailsId) {
		this.flightDetailsId = flightDetailsId;
	}
	public double getEconomyFare() {
		return economyFare;
	}
	public void setEconomyFare(double economyFare) {
		this.economyFare = economyFare;
	}
	public double getPremiumFare() {
		return premiumFare;
	}
	public void setPremiumFare(double premiumFare) {
		this.premiumFare = premiumFare;
	}
	public double getBusinessFare() {
		return businessFare;
	}
	public void setBusinessFare(double businessFare) {
		this.businessFare = businessFare;
	}
	public int getTotalEconomySeats() {
		return totalEconomySeats;
	}
	public void setTotalEconomySeats(int totalEconomySeats) {
		this.totalEconomySeats = totalEconomySeats;
	}
	public int getTotalPremiumSeats() {
		return totalPremiumSeats;
	}
	public void setTotalPremiumSeats(int totalPremiumSeats) {
		this.totalPremiumSeats = totalPremiumSeats;
	}
	public int getTotalBusinessSeats() {
		return totalBusinessSeats;
	}
	public void setTotalBusinessSeats(int totalBusinessSeats) {
		this.totalBusinessSeats = totalBusinessSeats;
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
