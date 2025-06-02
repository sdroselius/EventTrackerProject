package com.skilldistillery.divelog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.divelog.entities.User;
import com.skilldistillery.divelog.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User authenticate(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
