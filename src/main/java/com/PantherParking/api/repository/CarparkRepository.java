package com.PantherParking.api.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import  com.PantherParking.api.entity.Carpark;

public interface CarparkRepository extends CrudRepository <Carpark,Integer> {
	
	public Carpark save(Carpark c);
	
	Page<Carpark> findAll();


}
