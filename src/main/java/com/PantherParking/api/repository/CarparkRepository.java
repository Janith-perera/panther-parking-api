package com.PantherParking.api.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.PantherParking.api.Response.CarparkResponse;
import  com.PantherParking.api.entity.Carpark;

public interface CarparkRepository extends JpaRepository <Carpark,Integer> {
	
//	public Carpark save(Carpark c);
//	
//	Page<Carpark> findAll();
	
	@Query("SELECT c.carparkName as name,c.contactNumber as contactNumber FROM Carpark c WHERE c.carparkID=1")
	public CarparkResponse getCarParks();
	
	
	
	

}
