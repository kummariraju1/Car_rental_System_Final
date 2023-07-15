package com.deepu.user;

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

import com.deepu.user.entity.User;
import com.deepu.user.repository.UserRepository;
import com.deepu.user.serviceimpl.UserServiceImpl;

@SpringBootTest
class UserServiceApplicationTests {

	@MockBean
	private UserRepository userRepository;
    
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Test
       public void addUser() {
		User v = new User();
		v.setId(1);
		v.setFirstname("Abcdef");
		v.setLastname("what");
		v.setEmail("ygwsfe");
		v.setPassword("usaiuew");
		when(userRepository.save(v)).thenReturn(v);
		assertEquals("not",userServiceImpl.saveUser(v));
		
	}
	
	@Test
	public void getAllUser() {
		User v = new User();
		v.setId(1);
		v.setFirstname("Abcdef");
		v.setLastname("what");
		v.setEmail("ygwsfe");
		v.setPassword("usaiuew");
		when(userRepository.findAll()).thenReturn(Stream.of(v).collect(Collectors.toList()));
		assertEquals(1,userServiceImpl. getAllUser().size());
	}
	
	@Test
	public void getById() {
		int id = 1;
		User v = new User();
		v.setId(1);
		v.setFirstname("Abcdef");
		v.setLastname("what");
		v.setEmail("ygwsfe");
		v.setPassword("usaiuew");
		doReturn(Optional.of(v)).when(userRepository).findById(id);
		Optional<User> vech=userServiceImpl.getByIdUser(id);
		assertEquals(Optional.of(v),vech);
	}
	
	@Test
	public void deleteById() {
		User v = new User();
		v.setId(1);
		v.setFirstname("Abcdef");
		v.setLastname("what");
		v.setEmail("ygwsfe");
		v.setPassword("usaiuew");
		userServiceImpl.deleteUserById(1);
		verify(userRepository,times(1)).deleteById(1);
		
	}
		
	




}
