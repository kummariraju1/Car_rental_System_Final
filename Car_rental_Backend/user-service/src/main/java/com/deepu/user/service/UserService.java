package com.deepu.user.service;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deepu.user.entity.User;
import com.deepu.user.exception.UserNotFoundException;




public interface UserService {
	public String saveUser(@RequestBody User user);
	public List<User> getAllUser();
	public  Optional<User>getByIdUser(@PathVariable("id") Integer id) throws UserNotFoundException;
	public void deleteUserById(@PathVariable Integer id);
	public ResponseEntity<?> editUser(@RequestBody User user, @PathVariable Integer id);
}


