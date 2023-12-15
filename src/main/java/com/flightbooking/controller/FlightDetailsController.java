package com.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.entity.Flight;
import com.flightbooking.entity.FlightDetails;
import com.flightbooking.service.FlightDetailsService;

@RestController
@RequestMapping("/flightdetails")
public class FlightDetailsController {
	
	@Autowired
	FlightDetailsService flightDetailsService;
	@PostMapping("/add")
    public ResponseEntity<FlightDetails> addFlight(@RequestBody FlightDetails newFlight) {
        FlightDetails addedFlight = flightDetailsService.addFlight(newFlight);
        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
    }

}
