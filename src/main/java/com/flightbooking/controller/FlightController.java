package com.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dto.FlightDto;
import com.flightbooking.entity.Flight;
import com.flightbooking.service.FlightService;
@RestController
@RequestMapping("/flight")
@Controller
public class FlightController {
	@Autowired
	FlightService flightService;
	
	  @PostMapping("/add")
	    public ResponseEntity<Flight> addFlight(@RequestBody Flight newFlight) {
		  System.out.println(newFlight.getFlightDetails());
	        Flight addedFlight = flightService.addFlight(newFlight);
	        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
	    }
	 /* @PutMapping("/update/{flightId}")
	  public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight,@PathVariable("flightId") int flightId){
		return new ResponseEntity<Flight>(flightService.updateById(flight, flightId),HttpStatus.OK);
		  
	  }*/
	  @GetMapping("/getflightsbylocations/{departureLocation}/{arrivalLocation}")
	  public ResponseEntity<List<FlightDto>> getFlightsByLocation(@PathVariable String departureLocation,@PathVariable String arrivalLocation){
		return new ResponseEntity<List<FlightDto>> (flightService.findFlightsByLocations(departureLocation, arrivalLocation),HttpStatus.OK);
		  
	  }
	 

}
