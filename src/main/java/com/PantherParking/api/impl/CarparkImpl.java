package com.PantherParking.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.PantherParking.api.Response.CarparkResponse;
import com.PantherParking.api.Response.CarparkResponseDTO;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.repository.CarparkRepository;
import com.PantherParking.api.repository.ParkingSlotRepository;
import com.PantherParking.api.service.CarparkService;

@Service
public class CarparkImpl implements CarparkService{

	@Autowired
	private CarparkRepository cpRepo;
	
	 private final ParkingSlotRepository parkingSlotRepository ;

	 @Autowired
	 public CarparkImpl  (ParkingSlotRepository parkingSlotRepository) {
		 this.parkingSlotRepository = parkingSlotRepository;
	 }
	
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
	 
	 @Override
	 public List< CarparkResponseDTO> getCarparksByLocation(){
		 List< CarparkResponseDTO> cpResList =new  ArrayList<CarparkResponseDTO>();
		 for(Carpark cp:  cpRepo.findAll()) {
			 CarparkResponseDTO cpRes =new  CarparkResponseDTO();
			 cpRes.setCarparkID(cp.getCarparkID());
			 cpRes.setCarparkName(cp.getCarparkName());
			 cpRes.setContactNumber(cp.getContactNumber());
			 cpRes.setLocationLattitude(cp.getLocationLattitude());
			 cpRes.setLocationLongitude(cp.getLocationLongitude());
			 cpRes.setFreeSlotCount(parkingSlotRepository.getAvailableSlotsCountByCarparkId(cp.getCarparkID(), true));
			 
			 
			 cpResList.add(cpRes);
		 }
		 return cpResList; 
	 }

	@Override
	public CarparkResponseDTO getCarparksById(int id) {
		Optional <Carpark> opCp = cpRepo.findById(id);
		if(opCp.isPresent()) {
			Carpark cp = opCp.get();
			CarparkResponseDTO  cpRes =new CarparkResponseDTO ();
			cpRes.setCarparkID(cp.getCarparkID());
			cpRes.setCarparkName(cp.getCarparkName());
			cpRes.setContactNumber(cp.getContactNumber());
			cpRes.setLocationLattitude(cp.getLocationLattitude());
			cpRes.setLocationLongitude(cp.getLocationLongitude());
			cpRes.setFreeSlotCount(parkingSlotRepository.getAvailableSlotsCountByCarparkId(id, true));
			
			return cpRes;
		}
			
		return null;
	}
}
