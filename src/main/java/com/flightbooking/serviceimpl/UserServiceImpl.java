package com.flightbooking.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flightbooking.dto.UserDto;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.User;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.exception.InvalidEmailException;
import com.flightbooking.exception.InvalidNameException;
import com.flightbooking.exception.InvalidPasswordException;
import com.flightbooking.exception.PasswordMismatchException;
import com.flightbooking.exception.UserAlreadyExistException;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightRepository;
//import com.flightbooking.repository.AddressRepository;
import com.flightbooking.repository.UserRepository;
import com.flightbooking.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private BookingRepository bookingRepository;
	
	public User userRegistration(User user) throws UserAlreadyExistException,InvalidEmailException,InvalidPasswordException,InvalidNameException{
		User isExist=userRepository.findByEmail(user.getEmail());
		if(isExist!=null) {
			throw new UserAlreadyExistException("User is already exist");
		}
		else {
			if(!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
			{
				throw new InvalidEmailException("Invalid_email");
			}
			if(!user.getUserName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$")|| !user.getFirstName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$")||!user.getLastName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$") ) {
				throw new InvalidNameException("Invalid_Name");
				
			}
			if(!user.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")) {
				throw new InvalidPasswordException("Invalid_password");
			}
		}
		return userRepository.save(user);
		
	}

	@Override
	public String userLogin(String email, String password) throws InvalidPasswordException{
		User user=userRepository.findByEmail(email);
		System.out.println(user);
		if(user!=null && user.getPassword().equals(password)) 
			return "Login Successfully";
		throw new InvalidPasswordException("Invalid_password");
		
	}

	/*@Override
	public String resetPassword(String email,String password) {
		User user =userRepository.findByEmail(email);
		if(user!=null && user.getEmail().equals(email)) {
			user.setPassword(password);
			userRepository.save(user);
			return "Password reset successfully";
		}else if(!user.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")){
			throw new InvalidPasswordException("Invalid_password");
		}
		else {
			throw new InvalidEmailException("Invalid_Email");
		}
		
	}*/
	
	@Override
	public String forgotPassword(UserDto userDto) {
		User user=userRepository.findByEmail(userDto.getEmail());
		if(user ==null) {
			throw new InvalidEmailException("Invalid_Email");
		}else if(!userDto.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")||!userDto.getConfirmPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")){
			throw new InvalidPasswordException("Invalid_password");
		}
		else {
			user.setPassword(userDto.getPassword());
			userRepository.save(user);
			return "Password Reset Successful";
		}
	}
	@Override
	public UserDto userDashboard(int userId) {
		if(userRepository.existsById(userId)) {
		User user =userRepository.findByUserId(userId);
		Booking book=bookingRepository.getById(user.getUserId());
		UserDto newUser=new UserDto();
		newUser.setUserId(user.getUserId());
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setAge(user.getAge());
		newUser.setGender(user.getGender());
		newUser.setMobileNo(user.getMobileNo());
		newUser.setUserName(user.getUserName());
		//newUser.setDepartureLocation(flight.getDepartureLocation());
		newUser.setBookingId(book.getBookingId());
		newUser.setBookingNumber(book.getBookingNumber());
		newUser.setBookingDate(book.getBookingDate());
		newUser.setTravelDate(book.getTravelDate());
		newUser.setNoOfSeats(book.getNoOfSeats());
		newUser.setSeatType(book.getSeatType());
		return newUser;
		}else {
			throw new UserNotFoundException("User id is not found");
		}
	}

	/*@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public User updateById( User user,int userId) {
		Optional<User> update=userRepository.findById(userId);
		if(update==null) {
			throw new UserNotFoundException("User id is not found"+userId);
		}else {
			return userRepository.save(user);
		}	
	}	
}