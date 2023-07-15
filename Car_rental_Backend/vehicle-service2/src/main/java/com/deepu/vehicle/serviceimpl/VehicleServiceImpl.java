package com.deepu.vehicle.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deepu.vehicle.entity.Vehicle;
import com.deepu.vehicle.repository.VehicleRepository;
import com.deepu.vehicle.service.VehicleService;


@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public void saveVehicle(Vehicle vehicle) {
		if (vehicle.getPrice()>0)
		{
			vehicleRepository.save(vehicle);
		}
		
		
	}
	
	@Override
    public List<Vehicle> getAllVehicle() {
		
		return vehicleRepository.findAll();
	}
	
	@Override
    public Optional<Vehicle> getByIdVehicle(Integer id){
		return vehicleRepository.findById(id);
		
	}
	
	@Override
    public void deleteVehicleById(Integer id) {
		
		vehicleRepository.deleteById(id);
	}
	
	@Override
	public ResponseEntity<?> editVehicle(Vehicle vehicle, Integer id) {
		Vehicle vehicle2 = vehicleRepository.findById(id).get();
		vehicle2.setCompany(vehicle.getCompany());
		vehicle2.setPrice(vehicle.getPrice());
		vehicle2.setVariant(vehicle.getVariant());
		return new ResponseEntity<>(vehicleRepository.save(vehicle2), HttpStatus.CREATED);
	}
	

}
