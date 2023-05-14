package com.PantherParking.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.PantherParking.api.entity.Carpark;

@Service
public interface CarparkService {
	
	public String addNewCarpark();
	
	public String updateCarpark();
	
	public Page<Carpark> allCarparks();
	
	
}
