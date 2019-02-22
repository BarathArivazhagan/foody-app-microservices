package com.barath.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.barath.app.model.User;
import com.barath.app.service.UserService;

@RestController
public class UserController {
	
	private final UserService userService;	
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(value="/user")
	public User createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}
	
	
	
	@PostMapping(value="/user/login")
	public ResponseEntity<Object> login(@RequestParam("email") String email, @RequestParam("password") String password){
		
		if( StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
			return ResponseEntity.badRequest().body("Username/password  cannot be empty");
		}
		if(this.userService.validateUser(email, password)) {
			return ResponseEntity.ok().body("Login successful");
		}
		return   ResponseEntity.badRequest().body("Invalid username/password ");
	}


}
