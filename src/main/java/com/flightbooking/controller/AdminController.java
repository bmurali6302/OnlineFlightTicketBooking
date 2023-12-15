package com.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dto.UpdateFlightDetailsDto;
import com.flightbooking.dto.UpdateFlightDto;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.FlightDetails;
import com.flightbooking.service.AdminService;	
	@RestController
	@RequestMapping("/admin")
	public class AdminController {
		@Autowired
	    AdminService adminService;
	 
	    @PutMapping("/updateflight/{adminId}/{flightId}")
	    public UpdateFlightDto updateFlight(@PathVariable int adminId, @PathVariable int flightId, @RequestBody Flight updatedFlight) {
	        return adminService.updateFlight(adminId, flightId, updatedFlight);
	    }
	    @PutMapping("/updateflightdetails/{adminId}/{flightDetailsId}")
	    public UpdateFlightDetailsDto updateFlightDetails(@PathVariable int adminId, @PathVariable int flightDetailsId,
	            @RequestBody FlightDetails updatedFlightDetails) {
	        return adminService.updateFlightDetails(adminId, flightDetailsId, updatedFlightDetails);
	    }
	



}
