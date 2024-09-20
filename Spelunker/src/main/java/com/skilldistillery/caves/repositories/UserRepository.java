package com.skilldistillery.caves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.caves.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPasswordAndEnabledTrue(String username, String password);
}
