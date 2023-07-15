package com.deepu.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.deepu.admin.entity.Admin;
import com.deepu.admin.repository.AdminRepository;
import com.deepu.admin.serviceimpl.AdminServiceImpl;

@SpringBootTest
class AdminServiceApplicationTests {
	
	@MockBean
	private AdminRepository adminRepository;
    
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Test
	public void addAdmin() {
		Admin v = new Admin();
		v.setId(1);
		v.setName("uwg");
		v.setPassword("usaiuew");
		when(adminRepository.save(v)).thenReturn(v);
		assertEquals(v,adminServiceImpl.saveAdmin(v));
		
	}
	
	@Test
	public void getAllAdmin() {
		Admin v = new Admin();
		v.setId(1);
		v.setName("iriu");
		v.setPassword("usaiuew");
		when(adminRepository.findAll()).thenReturn(Stream.of(v).collect(Collectors.toList()));
		assertEquals(1,adminServiceImpl. getAllAdmin().size());
	}


}
