package com.PantherParking.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.Response.*;

@Service
public interface CarparkService {
	
	public Carpark addNewCarpark(Carpark cp);
	
	public String updateCarpark();
	
	public Page<Carpark> allCarparks();

	Optional<Carpark> findById(int id);

	CarparkResponse getAll();

	List< CarparkResponseDTO > getCarparksByLocation();
	
	

	CarparkResponseDTO getCarparksById(int id);
	
	
}
