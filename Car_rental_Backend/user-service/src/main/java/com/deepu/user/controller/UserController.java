package com.deepu.user.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.deepu.user.exception.*;

import com.deepu.user.UserServiceApplication;
import com.deepu.user.entity.User;
import com.deepu.user.repository.UserRepository;
import com.deepu.user.service.UserService;
import org.slf4j.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	private static final Logger logger=LoggerFactory.getLogger(UserServiceApplication.class);
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody @Valid User user) {
		logger.info("save user data");
		return userService.saveUser(user);
	}
	
	@GetMapping("/all")
	public List<User> getAllUser() {
		logger.info("get all users data");
		return userService.getAllUser();
	}
	
	@GetMapping("/getuser/{id}")
	public Optional<User> getByIdUser(@PathVariable("id") Integer id ) throws UserNotFoundException {
		logger.info("save vehicle data");
		Optional<User> u=userRepository.findById(id);
		if(u.isPresent()) {
			return userService.getByIdUser(id);
		}
		else {
			throw new UserNotFoundException();
		}
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Integer id) throws UserNotFoundException {
		logger.info("get all user data");
		Optional<User> u=userRepository.findById(id);
		if(u.isPresent()) {
			userService.deleteUserById(id);
		}
		else {
			throw new UserNotFoundException();
		}
			
	}
	
	@PutMapping("/editUser/{id}")
	public ResponseEntity<?> editUser(@RequestBody User user, @PathVariable Integer id ) {
		logger.info("edit user data through id");
		Optional<User> u=userRepository.findById(id);
		return userService.editUser(user, id);
	}
	
	
}
