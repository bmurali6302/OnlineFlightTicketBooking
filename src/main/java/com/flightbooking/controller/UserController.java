package com.flightbooking.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dto.UserDto;
import com.flightbooking.entity.User;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public ResponseEntity<User> userRegistration(@RequestBody User users) {
		return new ResponseEntity<User>(userServiceImpl.userRegistration(users),HttpStatus.OK);
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody User loginRequest){
	     return new ResponseEntity<String>(userServiceImpl.userLogin(loginRequest.getEmail(),loginRequest.getPassword()),HttpStatus.OK);
	    
	}
	/*@PostMapping("/resetpassword")
	public ResponseEntity<String> resetPassword(String email,String password){
		return new ResponseEntity<String>(userServiceImpl.resetPassword(email, password),HttpStatus.OK);
	}*/
	
	@PostMapping("/forgotpassword")
	public ResponseEntity<String> forgotPassword(@RequestBody UserDto userDto){
		return new ResponseEntity<String> (userServiceImpl.forgotPassword(userDto),HttpStatus.OK);
		
	}
	
	@GetMapping("/dashboard/{userId}")
	public ResponseEntity<UserDto> userDashboard(@PathVariable("userId") int userId){
		return new ResponseEntity<UserDto>(userServiceImpl.userDashboard(userId),HttpStatus.OK);
	}
   /*	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userServiceImpl.getUsers(),HttpStatus.OK);
		
	}*/
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateById(@RequestBody User user,@PathVariable("userId")int userId){
		return new ResponseEntity<User>(userServiceImpl.updateById(user,userId),HttpStatus.OK);
	}
	
}	