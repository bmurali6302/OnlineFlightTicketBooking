package com.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	Admin findByEmail(String email);
	Admin findById(int adminId);

}
