package com.PantherParking.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.PantherParking.api.entity.Vehicle;
import com.PantherParking.api.entity.WebUser;

@Repository
public interface VehicleRpository extends CrudRepository<Vehicle, Integer> {

	List<Vehicle> findAllByWebUser(WebUser userId);

	
}
