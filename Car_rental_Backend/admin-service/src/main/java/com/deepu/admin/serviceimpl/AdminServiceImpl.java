package com.deepu.admin.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deepu.admin.entity.Admin;
import com.deepu.admin.repository.AdminRepository;
import com.deepu.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	  private AdminRepository adminRepository;
	  @Override
		public Admin saveAdmin(Admin admin) {
			
			return adminRepository.save(admin);
		}
	  @Override
	    public List<Admin> getAllAdmin() {
			
			return adminRepository.findAll();
		}
}
