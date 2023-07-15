package com.deepu.vehicle.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepu.vehicle.VehicleServiceApplication;
import com.deepu.vehicle.entity.Vehicle;
import com.deepu.vehicle.service.VehicleService;
//import com.google.common.base.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	private static final Logger logger=LoggerFactory.getLogger(VehicleServiceApplication.class);
	
	
	@PostMapping("/saveVehicle")
	public void saveVehicle(@RequestBody Vehicle vehicle) {
		logger.info("save vehicle data");
		vehicleService.saveVehicle(vehicle);
	}
	@GetMapping("/")
	public List<Vehicle> getAllVehicle() {
		logger.info("get all vehicles data");
		return vehicleService.getAllVehicle();
	}
	@GetMapping("/getvehicle/{id}")
	public Optional<Vehicle> getByIdVehicle(@PathVariable("id") Integer id ) {
		logger.info("get vehicle through id");
		return vehicleService.getByIdVehicle(id);
	}
	@DeleteMapping("/deleteVehicle/{id}")
	public void deleteVehicle(@PathVariable Integer id) {
		logger.info("delete vehicle through id");
		vehicleService.deleteVehicleById(id);
	}
	@PutMapping("/editVehicle/{id}")
	public ResponseEntity<?> editVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id ) {
		logger.info("edit vehicle through id");
		return vehicleService.editVehicle(vehicle, id);
	}
	
	
	

}
