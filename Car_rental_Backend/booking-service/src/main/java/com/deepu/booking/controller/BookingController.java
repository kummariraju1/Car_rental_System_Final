package com.deepu.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deepu.booking.BookingServiceApplication;
import com.deepu.booking.entity.Booking;
import com.deepu.booking.model.RequiredResponse;
import com.deepu.booking.model.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class BookingController {
	
	@Autowired
	private RestTemplate restTemplate;
	private static final Logger logger=LoggerFactory.getLogger(BookingServiceApplication.class);
	
	Integer bid=0;
	Double price=0.0;
	
	@PostMapping("/saveResponse/{uid}")
	public RequiredResponse saveResponse(@PathVariable("uid") Integer uid) {
		 price=0.00;
		logger.info("save booking items through user id");
		RequiredResponse b = new RequiredResponse();
	    List l = restTemplate.getForObject("http://localhost:8103/getall/"+uid, List.class);
	    		//List<Cart> l1 = new ArrayList<>();
	    ObjectMapper mapper = new ObjectMapper();
	    
	    for(int i = 0; i < l.size(); i++)
	    {
	    	Cart vehicle = mapper.convertValue(l.get(i), Cart.class);
	    	//l1.add(vehicle);
	    	price = price+vehicle.getPrice();
	     
	    }
	 
	
	   
	    bid=bid+1;
	    b.setBid(bid);
	    b.setUid(uid);
	    b.setFinalprice(price);
	    price=0.0;
	    return b;
	    
	}
			
	
}