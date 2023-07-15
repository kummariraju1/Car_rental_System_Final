package com.deepu.user.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deepu.user.entity.User;
import com.deepu.user.repository.UserRepository;
//import com.deepu.user.repository.UserRepository;
import com.deepu.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserRepository userRepository;
  
  @Override
	public String saveUser(User user) {
	  List l=userRepository.findAll();
	  ObjectMapper mapper = new ObjectMapper();
	  Boolean b=false;
	  for(int i =0 ; i<l.size(); i++) {
		  User u = mapper.convertValue(l.get(i), User.class);
		 
		  if(u.getFirstname().equals(user.getFirstname()) && u.getLastname().equals(user.getLastname()) && u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
		  {
			  b=true;
			  break;
		  }
	  }
	  
	  if(b==true) {
		return "Registered";
	  }
	  else
	  {
	 userRepository.save(user);
	 return "not";
	
	  }
	}
  
  @Override
  public List<User> getAllUser(){
		
		return userRepository.findAll();
	}
  
  @Override
  public Optional<User> getByIdUser(Integer id)  {
	
		  return userRepository.findById(id);
	}
  @Override
  public void deleteUserById(Integer id) {
		
		userRepository.deleteById(id);
	}
  @Override
	public ResponseEntity<?> editUser(User user, Integer id) {
		User user2 = userRepository.findById(id).get();
		user2.setFirstname(user.getFirstname());
		user2.setLastname(user.getLastname());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
	}
	
}
