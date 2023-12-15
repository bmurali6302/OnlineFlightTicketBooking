package com.flightbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.flightbooking.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findByEmail(String email);
	User findByPassword(String password);
	//Optional<User> findByEmail(String email);
//	User findByEmailAndPassword(String email);
	//Optional<User> fingByEmail(String email);
	//UserDto userDashboard(int userId);
	User findByUserId(int userId);
	Optional<User> findById(int userId);
}
