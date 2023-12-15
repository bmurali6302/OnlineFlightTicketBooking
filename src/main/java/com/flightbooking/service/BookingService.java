package com.flightbooking.service;

import org.springframework.stereotype.Service;

import com.flightbooking.dto.BookingDto;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.User;
@Service
public interface BookingService {
	public BookingDto addBooking(Booking booking);
	public String deleteBookingById(int bookingId);
	public String updateBooking(int bookingId, Booking booking);
	

}
