package com.deepu.vehicle;


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

import com.deepu.vehicle.entity.Vehicle;
import com.deepu.vehicle.repository.VehicleRepository;
import com.deepu.vehicle.serviceimpl.VehicleServiceImpl;


@SpringBootTest
class VehicleServiceApplicationTests {
	
	@MockBean
	private VehicleRepository vehicleRepository;
    
	@Autowired
	private VehicleServiceImpl vehicleServiceImpl;
	@Test
	public void addVehicle() {
		Vehicle v = new Vehicle();
		v.setId(1);
		v.setCompany("Abcdef");
		v.setVariant("what");
		v.setPrice(0.00);
		when(vehicleRepository.save(v)).thenReturn(v);
		assertEquals(v,vehicleServiceImpl.saveVehicle(v));
		
	}
	
	@Test
	public void getAllVehicle() {
		Vehicle v = new Vehicle();
		v.setId(1);
		v.setCompany("khwjowqh");
		v.setVariant("quegd");
		v.setPrice(0.7536);
		when(vehicleRepository.findAll()).thenReturn(Stream.of(v).collect(Collectors.toList()));
		assertEquals(1,vehicleServiceImpl. getAllVehicle().size());
	}
	
	@Test
	public void getById() {
		int id = 1;
		Vehicle v = new Vehicle();
		v.setId(1);
		v.setCompany("hdgf");
		v.setVariant("gwqfdku");
		v.setPrice(488.83);
		doReturn(Optional.of(v)).when(vehicleRepository).findById(id);
		Optional<Vehicle> vech=vehicleServiceImpl.getByIdVehicle(id);
		assertEquals(Optional.of(v),vech);
	}
	
	@Test
	public void deleteById() {
		Vehicle v = new Vehicle();
		v.setId(1);
		v.setCompany("hdgf");
		v.setVariant("gwqfdku");
		v.setPrice(488.83);
		vehicleServiceImpl.deleteVehicleById(1);
		verify(vehicleRepository,times(1)).deleteById(1);
		
	}
		
	

}
