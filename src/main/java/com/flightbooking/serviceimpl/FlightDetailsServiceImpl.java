package com.flightbooking.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.entity.Flight;
import com.flightbooking.entity.FlightDetails;
import com.flightbooking.repository.FlightDetailsRepository;
import com.flightbooking.service.FlightDetailsService;
@Service
public class FlightDetailsServiceImpl implements FlightDetailsService{
	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	@Override
	public FlightDetails addFlight(FlightDetails flightDetails) {
	
		return flightDetailsRepository.save(flightDetails);
	}

}
