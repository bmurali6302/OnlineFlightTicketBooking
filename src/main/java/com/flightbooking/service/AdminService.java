package com.flightbooking.service;

import com.flightbooking.dto.UpdateFlightDetailsDto;
import com.flightbooking.dto.UpdateFlightDto;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.FlightDetails;

public interface AdminService {
	UpdateFlightDto updateFlight(int adminId, int flightId, Flight updatedFlight);
	UpdateFlightDetailsDto updateFlightDetails(int adminId, int flightDetailsId, FlightDetails updatedFlightDetails);	

}
