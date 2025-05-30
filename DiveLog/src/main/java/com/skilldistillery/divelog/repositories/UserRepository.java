package com.skilldistillery.divelog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.divelog.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}
