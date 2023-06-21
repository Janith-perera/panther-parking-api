package com.PantherParking.api.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.PantherParking.api.Response.CarparkResponse;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.repository.CarparkRepository;
import com.PantherParking.api.service.CarparkService;

@Service
public class CarparkImpl implements CarparkService{

	@Autowired
	private CarparkRepository cpRepo;
	
	@Override
	public Carpark  addNewCarpark(Carpark cp) {
		return cpRepo.save(cp);
	}

	@Override
	public String updateCarpark() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Carpark> allCarparks() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 @Override
	 public Optional < Carpark > findById(int id) {
	        return cpRepo.findById(id);
	 }
	 
	 @Override
	 public CarparkResponse getAll(){
		return cpRepo.getCarParks(); 
	 }

}
