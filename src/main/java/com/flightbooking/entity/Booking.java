package com.flightbooking.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookingId")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column(name = "booking_number")
	private long bookingNumber;
	
	@Column(name = "booking_date")
	private Date bookingDate;
	
	@Column(name = "travel_date")
	private Date travelDate;
	@Column(name = "noOf_seats_booked")
	private int noOfSeats;
	
	@Column(name = "seat_type")
	private String seatType;
	
	@Column(name = "total_cost")
	private double totalCost;
	// extra add bel
	
	@ManyToOne
	@JoinColumn(name = "user_id")//, referencedColumnName = "user_id")
	//@JsonBackReference  ///(value = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "flight_id")
	//@JsonBackReference //(value = "flight_id")
	private Flight flight;

	public Booking() {

	}

	

	public Booking(int bookingId, long bookingNumber, Date bookingDate, Date travelDate, int noOfSeats, String seatType,
			double totalCost, User user, Flight flight) {
		super();
		this.bookingId = bookingId;
		this.bookingNumber = bookingNumber;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.noOfSeats = noOfSeats;
		this.seatType = seatType;
		this.totalCost = totalCost;
		this.user = user;
		this.flight = flight;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Flight getFlight() {
		return flight;
	}



	public void setFlight(Flight flight) {
		this.flight = flight;
	}



	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingNumber=" + bookingNumber + ", bookingDate=" + bookingDate
				+ ", travelDate=" + travelDate + ", noOfSeats=" + noOfSeats + ", seatType=" + seatType + ", totalCost="
				+ totalCost + ", user=" + user.getUserId() + ", flight=" + flight + "]";
	}
	



	/*@Override
	public String toString() {
		return "Booking [id=" + bookingId + ", bookingNumber=" + bookingNumber + ", bookingDate=" + bookingDate
				+ ", travelDate=" + travelDate + ", seatType=" + seatType + ", totalCost=" + totalCost + ", user="
				+ user.getUserId() + ", flight=" + flight + "]";
	}*/

}