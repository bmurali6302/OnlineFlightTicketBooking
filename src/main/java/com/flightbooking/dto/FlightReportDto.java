package com.flightbooking.dto;
 
import java.time.LocalDate;
import java.util.Date;
 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
 
import jakarta.persistence.Column;
 
public class FlightReportDto {
	private int flightId;
	private String departureLocation;
	private String arrivalLocation;
	private LocalDate departureTime;
	private LocalDate arrivalTime;
	private int bookingId;
	private long bookingNumber;
	private Date bookingDate;
	private Date travelDate;
	private int noOfSeats;
	private String seatType;
	private double totalCost;
	public FlightReportDto() {
	}
	public FlightReportDto(int flightId, String departureLocation, String arrivalLocation, LocalDate departureTime,
			LocalDate arrivalTime, int bookingId, long bookingNumber, Date bookingDate, Date travelDate, int noOfSeats,
			String seatType, double totalCost) {
		super();
		this.flightId = flightId;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.bookingId = bookingId;
		this.bookingNumber = bookingNumber;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.noOfSeats = noOfSeats;
		this.seatType = seatType;
		this.totalCost = totalCost;
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
 
	public int getBookingId() {
		return bookingId;
	}
 
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
 
	public long getBookingNumber() {
		return bookingNumber;
	}
 
	public void setBookingNumber(long bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
 
	public Date getBookingDate() {
		return bookingDate;
	}
 
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
 
	public Date getTravelDate() {
		return travelDate;
	}
 
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
 
	public int getNoOfSeats() {
		return noOfSeats;
	}
 
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
 
	public String getSeatType() {
		return seatType;
	}
 
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
 
	public double getTotalCost() {
		return totalCost;
	}
 
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
 
	@Override
	public String toString() {
		return "FlightReportDto [flightId=" + flightId + ", departureLocation=" + departureLocation
				+ ", arrivalLocation=" + arrivalLocation + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", bookingId=" + bookingId + ", bookingNumber=" + bookingNumber + ", bookingDate="
				+ bookingDate + ", travelDate=" + travelDate + ", noOfSeats=" + noOfSeats + ", seatType=" + seatType
				+ ", totalCost=" + totalCost + "]";
	}

}