package com.PantherParking.api.impl.carpark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PantherParking.api.entity.SlotBooking;
import com.PantherParking.api.repository.CarparkRepository;
import com.PantherParking.api.repository.CarparkReservationRepository;
import com.PantherParking.api.service.carpark.CarparkReservationService;

@Service
public class CarparkReservationImpl implements CarparkReservationService {
	
	@Autowired
	private CarparkRepository cpRepo;
	
	@Autowired
	private CarparkReservationRepository cpReservationRepo;
	
	@Override
	public List<SlotBooking> viewReservations(String status, int cpId) {
		return cpReservationRepo.findByStatus(status,cpId);
	}

	@Override
	public List<SlotBooking> viewReservations(int cpId) {
		return cpReservationRepo.findAllByCarparkId(cpId);
	}
	
	@Override
	public SlotBooking updateStatus(int bookingId, String newStatus) {
	      SlotBooking slotBooking = cpReservationRepo.findById(bookingId)
	                .orElseThrow(() -> new RuntimeException("Slot booking not found"));
	        
	      slotBooking.setStatus(newStatus);
	      return cpReservationRepo.save(slotBooking);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
