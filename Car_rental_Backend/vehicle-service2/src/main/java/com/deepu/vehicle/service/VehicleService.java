package com.deepu.vehicle.service;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.deepu.vehicle.entity.Vehicle;

public interface VehicleService {
	public void saveVehicle(@RequestBody Vehicle vehicle);
	public List<Vehicle> getAllVehicle();
	public Optional<Vehicle> getByIdVehicle(@PathVariable("id") Integer id) ;
	public void deleteVehicleById(@PathVariable Integer id);
	public ResponseEntity<?> editVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id);
}