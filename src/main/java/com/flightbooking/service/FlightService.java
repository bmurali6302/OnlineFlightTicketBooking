package com.flightbooking.service;

import java.util.List;

import com.flightbooking.dto.FlightDto;
import com.flightbooking.entity.Flight;


public interface FlightService {
	public Flight addFlight(Flight flight);
	
	// public Flight updateById(Flight flight,int flightId);
	 
	 List<FlightDto> findFlightsByLocations(String departureLocation, String arrivalLocation);

}
