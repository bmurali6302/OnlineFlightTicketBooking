package com.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dto.BookingDto;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.User;
import com.flightbooking.exception.EntityNotFoundException;
import com.flightbooking.exception.NoAvailableSeatsException;
import com.flightbooking.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingService bookingService;
	@PostMapping("/add")
	public ResponseEntity<BookingDto> addBooking(@RequestBody Booking booking) {
		return new ResponseEntity<BookingDto>(bookingService.addBooking(booking), HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<String> deleteBookingById(@PathVariable("bookingId") int bookingId){
		return new ResponseEntity<String> (bookingService.deleteBookingById(bookingId),HttpStatus.OK);
	}
	
	@PutMapping("/update/{bookingId}")
	public ResponseEntity<String> updateBooking(@PathVariable("bookingId") int bookingId,@RequestBody Booking booking){
		return new ResponseEntity<String>(bookingService.updateBooking(bookingId, booking),HttpStatus.OK);
		
	}


}


























/*
 * @PostMapping("/addbooking") public ResponseEntity<Booking>
 * addBooking(@RequestBody Booking booking){ return new
 * ResponseEntity<Booking>(bookingService.addBooking(booking),HttpStatus.CREATED
 * ); }
 */

/*
 * 
 * try { Booking addedBooking = bookingService.addBooking(booking, userId,
 * flightId); return new ResponseEntity<>(addedBooking, HttpStatus.CREATED); }
 * catch (EntityNotFoundException | NoAvailableSeatsException | RuntimeException
 * e) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
 */