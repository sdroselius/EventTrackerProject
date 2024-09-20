package com.skilldistillery.caves.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.caves.entities.User;
import com.skilldistillery.caves.services.UserService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public User register(@RequestBody User user, HttpServletResponse res) {
		try {
			user = userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(403);
			user = null;
		}
		return user;
	}
	
	@PostMapping("login")
	public User authenticate(@RequestBody User user, HttpServletResponse res) {
		user = userService.authenticate(user.getUsername(), user.getPassword());
		if (user == null) {
			res.setStatus(401);
		}
		return user;
	}
}
