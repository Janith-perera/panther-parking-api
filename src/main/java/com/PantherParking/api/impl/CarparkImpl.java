package com.PantherParking.api.impl;

import java.util.List;
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
	public String addNewCarpark(Carpark cp) {
//		Carpark cpObj = new Carpark();
//		cpObj.setCarparkName("Hello World");
//		cpObj.setLocationLattitude("0.333");
//		cpObj.setLocationLongitude("0.333");
		
		return Integer.toString(cpRepo.save(cp).getCarparkID());
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
