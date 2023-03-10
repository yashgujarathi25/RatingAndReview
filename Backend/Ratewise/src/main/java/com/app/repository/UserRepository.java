package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByIsActive(Boolean active);
	
	User findByEmailAndPassword(String email, String password);
	
	List<User> findByPremium(Boolean active);
}
