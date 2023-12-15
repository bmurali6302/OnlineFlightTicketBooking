package com.flightbooking.globalhandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.flightbooking.exception.AdminNotFoundException;
import com.flightbooking.exception.BookingIdNotFoundException;
import com.flightbooking.exception.EntityNotFoundException;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.exception.InvalidEmailException;
import com.flightbooking.exception.InvalidNameException;
import com.flightbooking.exception.InvalidPasswordException;
import com.flightbooking.exception.NoAvailableSeatsException;
import com.flightbooking.exception.PasswordMismatchException;
import com.flightbooking.exception.UserAlreadyExistException;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.exception.FlightDetailsNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> UserNotFoundException(UserNotFoundException ex) {
		System.out.println(ex);
		return new ResponseEntity<String>("User not found",HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<String> UserAlreadyExistException(UserAlreadyExistException ex) {
		System.out.println(ex);
		return new ResponseEntity<String>("User is already registered",HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<String> InvalidEmailException(InvalidEmailException ex){
		System.out.println(ex);
		return new ResponseEntity<String>("Invalid email format",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<String> InvalidPasswordException(InvalidPasswordException ex){
		System.out.println(ex);
		return new ResponseEntity<String> ("Invalid password format",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<String> InvalidNameException(InvalidNameException ex){
		System.out.println(ex);
		return new ResponseEntity<String> ("InvalidNameException",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<String> PasswordMismatchException(PasswordMismatchException ex){
		System.out.println(ex);
		return new ResponseEntity<String> ("PasswordMismatchException",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<String> FlightNotFoundException(FlightNotFoundException ex){
		System.out.println(ex);
		return  new ResponseEntity<String> ("FlightNotFoundException",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoAvailableSeatsException.class)
	public ResponseEntity<String> NoAvailableSeatsException(NoAvailableSeatsException ex){
		System.out.println(ex);
		return new ResponseEntity<String> ("NoAvailableSeatsException",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> EntityNotFoundException(EntityNotFoundException ex){
		System.out.println(ex);
		return new ResponseEntity<String> ("EntityNotFoundException",HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(BookingIdNotFoundException.class)
	public ResponseEntity<String> BookingIdNotFoundException(BookingIdNotFoundException ex){
		System.out.println(ex);
		return new ResponseEntity<String> ("BookingIdNotFoundException",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> AdminNotFoundException(AdminNotFoundException ex){
		System.out.println(ex);
		return new ResponseEntity<String> ("AdminNotFoundException",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(FlightDetailsNotFoundException.class)
	public ResponseEntity<String> FlightDetailsNotFoundException(FlightDetailsNotFoundException ex){
		System.out.println(ex);
		return new ResponseEntity<String> ("FlightDetailsNotFoundException",HttpStatus.BAD_REQUEST);
	}
}


//public class GlobalExceptionHandler {
//	
//	@ExceptionHandler(UserAlreadyExistException.class)
//	public ResponseEntity<ErrorInfo> handleUserAlreadyExists(UserAlreadyExistException userAlreadyExistsException)
//	{
//        ErrorInfo erroInfo = new ErrorInfo();
//        erroInfo.setErrormessage(userAlreadyExistsException.getMessage());
//        erroInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
//        erroInfo.setLocalDateTime(LocalDateTime.now());
//        return new ResponseEntity<ErrorInfo>(erroInfo, HttpStatus.BAD_REQUEST);
//	}
//	
//}