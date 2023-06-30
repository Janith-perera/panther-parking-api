package com.PantherParking.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.PantherParking.api.entity.Vehicle;

public interface VehicleRpository extends CrudRepository<Vehicle, Integer> {
	
}
