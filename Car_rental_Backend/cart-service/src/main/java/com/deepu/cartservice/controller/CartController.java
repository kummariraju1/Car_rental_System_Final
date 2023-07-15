package com.deepu.cartservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deepu.cartservice.entity.Cart;
import com.deepu.cartservice.exception.CartItemNotFoundexception;
import com.deepu.cartservice.repository.CartRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/savevehicle/{id}/{uid}")
	public void getById(@PathVariable Integer id, @PathVariable Integer uid)
	{
		 Cart vehicle2 =restTemplate.getForObject("http://localhost:8102/getvehicle/"+id, Cart.class);
		 vehicle2.setUserid(uid);
		cartRepository.save(vehicle2);
	}
	
	@GetMapping("/getall/{uid}")
	public List<Cart> getAll(@PathVariable("uid") Integer uid) 
	{
	   return cartRepository.findByCarId(uid);
	}
	
	@DeleteMapping("/deleteCart/{id}")
	public void deleteById(@PathVariable Integer id) 
	{
		Optional<Cart> c=cartRepository.findById(id);
		if(c.isPresent()) {
			cartRepository.deleteById(id);
		}
		else {
			throw new CartItemNotFoundexception();
		}
	}

	
	@DeleteMapping("/deleteall/{id}")
	public void deleteAll(@PathVariable Integer id) 
	{
	 cartRepository.deleteByUserId(id);  
	}
}