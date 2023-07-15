package com.deepu.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepu.vehicle.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	

}
