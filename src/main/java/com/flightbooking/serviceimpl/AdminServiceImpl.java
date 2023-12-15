package com.flightbooking.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dto.UpdateFlightDetailsDto;
import com.flightbooking.dto.UpdateFlightDto;
import com.flightbooking.entity.Admin;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.FlightDetails;
import com.flightbooking.exception.AdminNotFoundException;
import com.flightbooking.exception.FlightDetailsNotFoundException;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.repository.AdminRepository;
import com.flightbooking.repository.FlightDetailsRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	@Override
	public UpdateFlightDto updateFlight(int adminId, int flightId, Flight updatedFlight) throws AdminNotFoundException,FlightNotFoundException{
		
		
		Admin admin= adminRepository.findById(adminId);
		if(admin==null) {
			throw new AdminNotFoundException("Admin not found with ID: " +adminId);
		}
		 Flight existingFlight = flightRepository.findById(flightId)
	                .orElseThrow(() -> new FlightNotFoundException("Flight not found with ID: " + flightId));
		 /* if (!admin.getFlight().contains(existingFlight)) {
	            throw new FlightNotFoundException("Flight not associated with the given admin");
	      }*/
		 
		 existingFlight.setDepartureLocation(updatedFlight.getDepartureLocation());
	     existingFlight.setArrivalLocation(updatedFlight.getArrivalLocation());
	     existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
	     existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
        
	      //  return flightRepository.save(existingFlight);
	     flightRepository.save(existingFlight);
	     UpdateFlightDto up=new UpdateFlightDto();
	     up.setFlightId(updatedFlight.getFlightId());
	     up.setDepartureLocation(updatedFlight.getDepartureLocation());
	     up.setArrivalLocation(updatedFlight.getArrivalLocation());
	     up.setDepartureTime(updatedFlight.getDepartureTime());
	     up.setArrivalTime(updatedFlight.getArrivalTime());
	     
		
		return up;
	}

	@Override
	public UpdateFlightDetailsDto updateFlightDetails(int adminId, int flightDetailsId, FlightDetails updatedFlightDetails) {
		   Admin admin = adminRepository.findById(adminId);
	        if(admin==null) {
	            throw new AdminNotFoundException("Admin not found with ID: " + adminId);
	        }
	        FlightDetails existingFlightDetails = flightDetailsRepository.findById(flightDetailsId)
	                .orElseThrow(() -> new FlightDetailsNotFoundException("FlightDetails not found with ID: " + flightDetailsId));

	    
	        existingFlightDetails.setEconomyFare(updatedFlightDetails.getEconomyFare());
	        existingFlightDetails.setPremiumFare(updatedFlightDetails.getPremiumFare());
	        existingFlightDetails.setBusinessFare(updatedFlightDetails.getBusinessFare());
	        existingFlightDetails.setTotalEconomySeats(updatedFlightDetails.getTotalEconomySeats());
	        existingFlightDetails.setTotalPremiumSeats(updatedFlightDetails.getTotalPremiumSeats());
	        existingFlightDetails.setTotalBusinessSeats(updatedFlightDetails.getTotalBusinessSeats());
	        existingFlightDetails.setRemainingEconomySeats(updatedFlightDetails.getRemainingEconomySeats());
	        existingFlightDetails.setRemainingBusinessSeats(updatedFlightDetails.getRemainingBusinessSeats());
	        existingFlightDetails.setRemainingPremiumSeats(updatedFlightDetails.getRemainingPremiumSeats());

	       // return flightDetailsRepository.save(existingFlightDetails);
	        flightDetailsRepository.save(existingFlightDetails);
	        UpdateFlightDetailsDto upd=new UpdateFlightDetailsDto();
	        upd.setFlightDetailsId(updatedFlightDetails.getFlightDetailsId());
	        upd.setTotalBusinessSeats(updatedFlightDetails.getTotalBusinessSeats());
	        upd.setTotalPremiumSeats(updatedFlightDetails.getTotalPremiumSeats());
	        upd.setTotalEconomySeats(updatedFlightDetails.getTotalEconomySeats());
	        upd.setRemainingBusinessSeats(updatedFlightDetails.getRemainingBusinessSeats());
	        upd.setRemainingPremiumSeats(updatedFlightDetails.getRemainingPremiumSeats());
	        upd.setRemainingEconomySeats(updatedFlightDetails.getRemainingEconomySeats());
	        upd.setBusinessFare(updatedFlightDetails.getBusinessFare());
	        upd.setPremiumFare(updatedFlightDetails.getPremiumFare());
	        upd.setEconomyFare(updatedFlightDetails.getEconomyFare());
	        
	        return upd;
	        
	    }	

}
