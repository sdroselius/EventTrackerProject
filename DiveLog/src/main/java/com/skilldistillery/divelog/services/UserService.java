package com.skilldistillery.divelog.services;

import com.skilldistillery.divelog.entities.User;

public interface UserService {
	User getUserByUsername(String username);
	User authenticate(User user);
}
