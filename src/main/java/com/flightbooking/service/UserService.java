package com.flightbooking.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flightbooking.dto.UserDto;
//import com.flightbooking.dto.UserDto;
import com.flightbooking.entity.User;
import com.flightbooking.exception.UserNotFoundException;
@Service
public interface UserService {
	public User userRegistration(User user);
	public String userLogin(String email,String password);
   // public String resetPassword(String email,String password);
    //String forgotPassword(String email,String password);
    public String forgotPassword(UserDto userDto);
    public UserDto userDashboard(int userId);
   // public List<User> getUsers();
    public User updateById(User user,int userId);
   //public Optional<User> findById(int userId);
  //  public User booking(User user,int flightId);

}
