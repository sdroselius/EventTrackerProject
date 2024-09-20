package com.skilldistillery.caves.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.caves.entities.User;
import com.skilldistillery.caves.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User authenticate(String username, String password) {
		return userRepo.findByUsernameAndPasswordAndEnabledTrue(username, password);
	}

	@Override
	public User register(User user) {
		user.setEnabled(true);
		user.setRole("USER");
		return userRepo.saveAndFlush(user);
	}

}
