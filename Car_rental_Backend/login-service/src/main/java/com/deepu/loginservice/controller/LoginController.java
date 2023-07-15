package com.deepu.loginservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.deepu.loginservice.LoginServiceApplication;
import com.deepu.loginservice.model.Admin;
import com.deepu.loginservice.model.Admin1;
import com.deepu.loginservice.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
	
	@Autowired
	private RestTemplate restTemplate;
	private static final Logger logger=LoggerFactory.getLogger(LoginServiceApplication.class);
	
	@PostMapping("/uservalidation")
	public String uservalidation(@RequestBody Admin1 admin1)
	{
		logger.info("save as valid user data");
		String uname=admin1.getUname();
		String password=admin1.getPassword();
		List lobjs=restTemplate.getForObject("http://localhost:8099/all", List.class);
		ObjectMapper mapper=new ObjectMapper();
		Boolean b=false;
		
		int c=0;
		for(int i=0;i<lobjs.size();i++)
		{
			User user=mapper.convertValue(lobjs.get(i),User.class);
			 c=user.getId();
			if(user.getEmail().equals(uname) && user.getPassword().equals(password))
					{
				     b=true;
				    
				     break;
					}
			System.out.println(user);
		}
		String s = "";
		s=s+c;
		if(b==true)
		{
			return "valid"+s;
		}
		else
		{
			return "not valid";
		}
	}
	
	@PostMapping("/adminvalidation")
	public String adminvalidation(@RequestBody Admin1 admin1)
	{
		logger.info("save as valid admin data");
		String uname=admin1.getUname();
		String password=admin1.getPassword();
		List lobjs=restTemplate.getForObject("http://localhost:8100/", List.class);
		ObjectMapper mapper=new ObjectMapper();
		Boolean b=false;
		int a=0;
		for(int i=0;i<lobjs.size();i++)
		{
			Admin admin=mapper.convertValue(lobjs.get(i),Admin.class);
			if(admin.getName().equals(uname) && admin.getPassword().equals(password))
					{
				a=admin.getId();
				     b=true;
				     break;
					}
		}
		String f = "";
		f=f+a;
		if(b==true)
		{
			return "valid"+f;
		}
		else
		{
			return "not valid";
		}
	}

}
