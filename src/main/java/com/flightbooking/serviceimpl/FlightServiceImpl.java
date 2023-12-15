package com.flightbooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dto.FlightDto;
import com.flightbooking.entity.Flight;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.repository.FlightDetailsRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;

   	public Flight addFlight(Flight flight) {
		flight.setFlightDetails(flightDetailsRepository.save(flight.getFlightDetails()));
		System.out.println(flight.getFlightDetails());
		return flightRepository.save(flight);
	}

	@Override
	public List<FlightDto> findFlightsByLocations(String departureLocation, String arrivalLocation) {
		List<Flight> flight = flightRepository.findFlightsByDepartureLocationAndArrivalLocation(departureLocation,
				arrivalLocation);
		if (flight.size() == 0) {
			throw new FlightNotFoundException("Flight is not available for given locations");
		}
		List<FlightDto> flightdtos = new ArrayList<>();

		for (Flight s : flight) {
			FlightDto flightdto = new FlightDto();
			flightdto.setFlightId(s.getFlightId());
			flightdto.setDepartureLocation(s.getDepartureLocation());
			flightdto.setArrivalLocation(s.getArrivalLocation());
			flightdto.setDepartureTime(s.getDepartureTime());
			flightdto.setArrivalTime(s.getArrivalTime());
			flightdto.setRemainingBusinessSeats(s.getFlightDetails().getRemainingBusinessSeats());
			flightdto.setRemainingPremiumSeats(s.getFlightDetails().getRemainingPremiumSeats());
			flightdto.setRemainingEconomySeats(s.getFlightDetails().getRemainingEconomySeats());
			flightdtos.add(flightdto);
		}
		return flightdtos;
	}

	/*@Override
	public Flight updateById(Flight flight, int flightId) {
		Flight flightUpdate = flightRepository.findById(flightId).get();
		if (flightUpdate == null) {
			throw new FlightNotFoundException("flight Id not found " + flightId);

		} else {
			return flightRepository.save(flightUpdate);
		}

	}*/

}
