package com.PantherParking.api.request.webuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PantherParking.api.entity.SlotBooking;
import com.PantherParking.api.repository.CarparkReservationRepository;
import com.PantherParking.api.service.webuser.WebUserSlotBookingService;

@Service
public class WebUserSlotBookingImpl implements WebUserSlotBookingService {

	@Autowired
	private CarparkReservationRepository cpReservationRepo;
		
	@Override
	public SlotBooking newSlotbooking(SlotBooking sb) {
		
		
		return cpReservationRepo.save(sb);
	}

}
