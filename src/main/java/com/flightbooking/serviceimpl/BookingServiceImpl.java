package com.flightbooking.serviceimpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dto.BookingDto;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.FlightDetails;
import com.flightbooking.entity.User;
import com.flightbooking.exception.BookingIdNotFoundException;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.exception.NoAvailableSeatsException;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightDetailsRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.UserRepository;
import com.flightbooking.service.BookingService;
@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	FlightDetailsRepository flightDetailsRepository;
	
	@Override
	public BookingDto addBooking(Booking booking) throws UserNotFoundException,NoAvailableSeatsException{
		System.out.println(booking);
		System.out.println(booking.getUser());
		User user = userRepository.findByUserId(booking.getUser().getUserId());
		Optional<Flight> opflight = flightRepository.findById(booking.getFlight().getFlightId());
		if (user == null) {
			throw new UserNotFoundException("User with ID "+booking.getUser().getUserId() +" not found");
		}else if(opflight.isEmpty()){
			throw new FlightNotFoundException("Flight with ID " + booking.getFlight().getFlightId() + " not found");
		}else {
			Flight flight = opflight.get();
			LocalDate currentDate = LocalDate.now();
			if (flight.getArrivalTime().isAfter(currentDate) && flight.getDepartureTime().isAfter(currentDate)) {
                boolean seatBookingSuccess = updateSeatAvailability(booking, flight);
                if (seatBookingSuccess) {
                	booking.setFlight(flight);
                	booking.setUser(user);
                	System.out.println(user);
                	System.out.println(flight);
                	System.out.println(booking);
                    Booking savedBooking = bookingRepository.save(booking);
                    BookingDto bd=new BookingDto();
                    bd.setNoOfSeats(booking.getNoOfSeats());
                    bd.setUserId(user.getUserId());
                    bd.setUserName(user.getUserName());
                    bd.setFirstName(user.getFirstName());
                    bd.setLastName(user.getLastName());
                    bd.setMobileNo(user.getMobileNo());
                    bd.setEmail(user.getEmail());
                    bd.setGender(user.getGender());
                    bd.setAge(user.getAge());
                    bd.setBookingId(booking.getBookingId());
                    bd.setBookingNumber(booking.getBookingNumber());
                    bd.setBookingDate(booking.getBookingDate());
                    bd.setTravelDate(booking.getTravelDate());
                    bd.setSeatType(booking.getSeatType());
                    bd.setFlightId(flight.getFlightId());
                    bd.setTotalCost(booking.getTotalCost());
                    bd.setArrivalLocation(flight.getArrivalLocation());
                    bd.setDepartureLocation(flight.getDepartureLocation());
                    bd.setDepartureTime(flight.getDepartureTime());
                    bd.setArrivalTime(flight.getArrivalTime());
                  
                    return bd;
                    //return savedBooking;
                } else {
                    throw new NoAvailableSeatsException("No available seats for the selected seat type");
                }
            } else {
                throw new RuntimeException("Booking cannot be done for past flights");
            }
		}
	 }
	 
	  private boolean updateSeatAvailability(Booking booking, Flight flight) {
	        FlightDetails flightDetails = flight.getFlightDetails();
	        int NoOfBookedSeats=booking.getNoOfSeats();	    //    
	       String selectedSeatType = booking.getSeatType();
	        boolean seatsUpdated = false; //
	        switch (selectedSeatType) {
	            case "economy":
	                if (flightDetails.getRemainingEconomySeats() > 0 && flightDetails.getRemainingEconomySeats()>= NoOfBookedSeats ) {
	                    flightDetails.setRemainingEconomySeats(flightDetails.getRemainingEconomySeats()- NoOfBookedSeats);
	                    ///return true;
	                    seatsUpdated = true;
	                }
	                break;
	            case "business":
	                if (flightDetails.getRemainingBusinessSeats() > 0 && flightDetails.getRemainingBusinessSeats()>=NoOfBookedSeats) {
	                    flightDetails.setRemainingBusinessSeats(flightDetails.getRemainingBusinessSeats() - NoOfBookedSeats);
	                    //return true;
	                    seatsUpdated = true;
	                }
	                break;
	            case "premium":
	                if (flightDetails.getRemainingPremiumSeats() > 0 && flightDetails.getRemainingPremiumSeats()>=NoOfBookedSeats ) {
	                    flightDetails.setRemainingPremiumSeats(flightDetails.getRemainingPremiumSeats() - NoOfBookedSeats);
	                    //return true;
	                    seatsUpdated = true;
	                    
	                }
	                break;
	        
	 
	            default:
	                //return false;
	            	seatsUpdated = false;
	        }
	        if (seatsUpdated) {
	            // Update the flight details in the database
	            flightDetailsRepository.save(flightDetails);
	        }

	        return seatsUpdated;
	 
	        //return false;
	     
	    }

	
	  @Override
		public String deleteBookingById(int bookingId) {
			String msg="";
			Booking booking = bookingRepository.findById(bookingId)
		            .orElseThrow(() -> new BookingIdNotFoundException("Booking id is not found" + bookingId));
			Flight flight = booking.getFlight();
		    FlightDetails flightDetails = flight.getFlightDetails();
		    int canceledSeats = booking.getNoOfSeats();
		    switch (booking.getSeatType()) {
	        case "economy":
	            flightDetails.setRemainingEconomySeats(flightDetails.getRemainingEconomySeats() + canceledSeats);
	            break;
	        case "business":
	            flightDetails.setRemainingBusinessSeats(flightDetails.getRemainingBusinessSeats() + canceledSeats);
	            break;
	        case "premium":
	            flightDetails.setRemainingPremiumSeats(flightDetails.getRemainingPremiumSeats() + canceledSeats);
	            break;
	    }
		    flightDetailsRepository.save(flightDetails);
		    bookingRepository.deleteById(bookingId);
			return  msg="Booking successfully cancelled";

		    
		}	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	/*	@Override
		public String deleteBookingById(int bookingId) {
			String msg="";
			if(bookingRepository.existsById(bookingId))
			{
				bookingRepository.deleteById(bookingId);
				msg="Booking successfully deleted";
			}
			else
			{
				throw new BookingIdNotFoundException("Booking id is not found"+bookingId);
			}
			return msg;
			
		}*/
	  

		
		
		
		
		
		
		
		
		
		
		
		
		
		@Override
		public String updateBooking(int bookingId, Booking booking) {			
			if(bookingRepository.existsById(bookingId))
			{
				//booking.setBookingId(bookingId);
				bookingRepository.save(booking);
			}
			else
			{
				throw new BookingIdNotFoundException("Booking id is not found"+bookingId);
			}
			//return bookingRepository.save(booking);
			return "Update sucessfully";
		}
	

	}
	
	
/*private boolean updateSeatAvailability(Booking booking, Flight flight) {
    FlightDetails flightDetails = flight.getFlightDetails();
    String selectedSeatType = booking.getSeatType();
    boolean seatsUpdated = false;

    switch (selectedSeatType) {
        case "economy":
            if (flightDetails.getRemainingEconomySeats() > 0) {
                flightDetails.setRemainingEconomySeats(flightDetails.getRemainingEconomySeats() - 1);
                seatsUpdated = true;
            }
            break;
        case "business":
            if (flightDetails.getRemainingBusinessSeats() > 0) {
                flightDetails.setRemainingBusinessSeats(flightDetails.getRemainingBusinessSeats() - 1);
                seatsUpdated = true;
            }
            break;
        case "premium":
            if (flightDetails.getRemainingPremiumSeats() > 0) {
                flightDetails.setRemainingPremiumSeats(flightDetails.getRemainingPremiumSeats() - 1);
                seatsUpdated = true;
            }
            break;
        default:
            seatsUpdated = false;
    }

    if (seatsUpdated) {
        // Update the flight details in the database
        flightRepository.save(flightDetails);
    }

    return seatsUpdated;
}

*/






	
	/*public String addBooking(Booking booking) {
	Flight flight=flightRepository.findById(booking.getFlight().getFlightId()).get();
	userRepository.findById(booking.get)
	LocalDate fromDate=flight.getDepartureTime();		
	LocalDate toDate=flight.getArrivalTime();
	
	return null;
	
}*/
	
	/*@Override
	public Booking addBooking(Booking booking) {
		Flight flight=flightRepository.findById(booking.getFlight().getFlightId()).get();
		if(flight==null) {
			throw new UserNotFoundException("flight not found");
		}else {
			booking.setFlight(flight);
			return bookingRepository.save(booking);
		}
}*/

	/*@Override
	public Booking bookFlight(int userId, int flightId) {
        User user = userRepository.findById(userId);
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found with ID: " + flightId));

        Booking booking = new Booking();
      //  booking.setUser(user);
        booking.setFlight(flight);
        return bookingRepository.save(booking);
		//return null;
	}
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public Booking addBooking(Booking booking) {
		
		User user=userRepository.findById(booking.getUser().getUserId());//.get();
		if(user==null) {
			throw new UserNotFoundException("ID not found");
		}else {
			booking.setUser(user);
			System.out.println(booking);
		return bookingRepository.save(booking);
		}
		/*booking.setUser(user);
		Flight flight=flightRepository.findById(booking.getFlight().getId()).get();
		booking.setFlight(flight);
		
		return bookingRepository.save(booking);*/
		
		//}

