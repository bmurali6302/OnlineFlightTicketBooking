package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightbooking.dto.FlightDto;
import com.flightbooking.entity.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer>{
	//@Query("SELECT f from Flight f WHERE f.departureLocation=?1 and f.arrivalLocation=?2")
	//public List<Flight> findFlightsByDepartureLocationAndArrivalLocation(@Param("departureLocation")String departureLocation,@Param("arrivalLocation")String arrivalLocation);
	public List<Flight> findFlightsByDepartureLocationAndArrivalLocation(String departureLocation,String arrivalLocation);

}
