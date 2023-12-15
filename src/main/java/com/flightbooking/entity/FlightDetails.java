package com.flightbooking.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="flight_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "flightDetailsId")
public class FlightDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="flightdetails_id")
	private int flightDetailsId;
	@Column(name="economy_fare")
	private double economyFare;
	@Column(name="premium_fare")
	private double premiumFare;
	@Column(name="business_fare")
	private double businessFare;
	@Column(name="total_economyseats")
	private int totalEconomySeats;
	@Column(name="total_premiumseats")
	private int totalPremiumSeats;
	@Column(name="total_businessseats")
	private int totalBusinessSeats;
	@Column(name="remaining_economyseats")
	private int remainingEconomySeats;
	@Column(name="remaining_premiumseats")
	private int remainingPremiumSeats;
	@Column(name="remaining_businessseats")
	private int remainingBusinessSeats;
	
	@OneToOne(mappedBy = "flightDetails")
//	@JoinColumn(name= "flight_id")
	//@JsonManagedReference
	private Flight flight;
	
	public FlightDetails() {
		
	}

	/*@Override
	public String toString() {
		return "FlightDetails [flightDetailsId=" + flightDetailsId + ", economyFare=" + economyFare + ", premiumFare="
				+ premiumFare + ", businessFare=" + businessFare + ", totalEconomySeats=" + totalEconomySeats
				+ ", totalPremiumSeats=" + totalPremiumSeats + ", totalBusinessSeats=" + totalBusinessSeats
				+ ", remainingEconomySeats=" + remainingEconomySeats + ", remainingPremiumSeats="
				+ remainingPremiumSeats + ", remainingBusinessSeats=" + remainingBusinessSeats + ", flight=" + flight
				+ "]";
	}*/

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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public FlightDetails(int flightDetailsId, double economyFare, double premiumFare, double businessFare,
			int totalEconomySeats, int totalPremiumSeats, int totalBusinessSeats, int remainingEconomySeats,
			int remainingPremiumSeats, int remainingBusinessSeats, Flight flight) {
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
		this.flight = flight;
	}
	
}
