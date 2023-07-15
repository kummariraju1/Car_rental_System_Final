package com.deepu.admin.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deepu.admin.entity.Admin;


public interface AdminService {
	public Admin saveAdmin(@RequestBody Admin admin);
	public List<Admin> getAllAdmin();
	
}
