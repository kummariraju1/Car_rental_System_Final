package com.deepu.loginservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.deepu.loginservice.controller.LoginController;
import com.deepu.loginservice.model.Admin1;

	@SpringBootTest

	class LoginServiceApplicationTests {

	 

	    @Autowired

	    private LoginController logincontroller;

	    @Test 

	    public void uservalidation()

	    {

	        Admin1 a=new Admin1();

	        a.setUname("deepika@gmail.com");

	        a.setPassword("1234");

	        System.out.println(logincontroller.uservalidation(a));

	        assertEquals("valid20",logincontroller.uservalidation(a));


	    }

	    @Test

	    public void uservalidation1()

	    {

	        Admin1 a=new Admin1();

	        a.setUname("bunhjhjhjhl.com");

	        a.setPassword("bunnhhkjhkjkhy");

	        assertEquals("not valid",logincontroller.uservalidation(a));


	    }

	    @Test 

	    public void adminvalidation()

	    {

	        Admin1 a=new Admin1();

	        a.setUname("deepu");

	        a.setPassword("yjgdfj");

	        System.out.println(logincontroller.adminvalidation(a));

	        assertEquals("valid",logincontroller.adminvalidation(a));


	    }

	    @Test

	    public void adminvalidation1()

	    {

	        Admin1 a=new Admin1();

	        a.setUname("bunhjhjhjhl.com");

	        a.setPassword("bunny");

	        assertEquals("not valid",logincontroller.adminvalidation(a));


	    }


	 

	}
