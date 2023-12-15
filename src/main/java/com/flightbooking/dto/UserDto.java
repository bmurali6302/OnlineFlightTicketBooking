package com.flightbooking.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;

public class UserDto {
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private long mobileNo;
	private String email;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	@JsonProperty(access=Access.WRITE_ONLY)
    private String confirmPassword;
	//private String departureLocation;
	private int bookingId;
	private long bookingNumber;
	private Date bookingDate;
	private Date travelDate;
	private int noOfSeats;	
	private String seatType;
	//private String updateUrl;
	//private String bookFlightsUrl;
	public UserDto() {	
	}
	public UserDto(int userId,String userName, String firstName, String lastName, int age, String gender, long mobileNo,
			String email, String password,int bookingId,long bookingNumber,Date bookingDate,Date travelDate,int noOfSeats,String seatType, String updateUrl) {
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		//this.departureLocation=departureLocation;
		this.bookingId=bookingId;
		this.bookingNumber=bookingNumber;
		this.bookingDate=bookingDate;
		this.travelDate=travelDate;
		this.noOfSeats=noOfSeats;
		this.seatType=seatType;
		
		
		//this.updateUrl = updateUrl;
		//this.updateUrl = "https://localhost:8092/user/dashboard/"+this.userId;
		//this.bookFlightsUrl = "https://localhost:8092/user/bookFlights";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
		//this.updateUrl = "https://localhost:8092/user/dashboard/"+this.userId;
		//this.bookFlightsUrl = "https://localhost:8092/user/bookFlights";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public String getUpdateUrl() {
		return updateUrl;
	}
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
	public String getBookFlightsUrl() {
		return bookFlightsUrl;
	}
	public void setBookFlightsUrl(String bookFlightsUrl) {
		this.bookFlightsUrl = bookFlightsUrl;
	}*/
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	/*public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}*/
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
	
}
