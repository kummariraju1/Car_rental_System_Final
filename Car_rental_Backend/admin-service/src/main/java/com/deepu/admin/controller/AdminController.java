package com.deepu.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepu.admin.AdminServiceApplication;
import com.deepu.admin.entity.Admin;
import com.deepu.admin.service.AdminService;
import org.slf4j.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class AdminController {
	@Autowired
	private AdminService adminService;
	private static final Logger logger=LoggerFactory.getLogger(AdminServiceApplication.class);
	
	@PostMapping("/saveAdmin")
	public Admin saveAdmin(@RequestBody Admin admin) {
		logger.info("save admin data");
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/")
	public List<Admin> getAllAdmin() {
		logger.info("get all admins data");
		return adminService.getAllAdmin();
	}
}