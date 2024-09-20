package com.skilldistillery.caves.services;

import com.skilldistillery.caves.entities.User;

public interface UserService {
	
	User authenticate(String username, String password);

	User register(User user);

}
