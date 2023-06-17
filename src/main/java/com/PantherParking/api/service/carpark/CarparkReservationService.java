package com.PantherParking.api.service.carpark;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PantherParking.api.entity.SlotBooking;

@Service
public interface CarparkReservationService {
	
	public List<SlotBooking> viewReservations(int cpId);

	List<SlotBooking> viewReservations(String status, int cpId);

	SlotBooking updateStatus(int bookingId, String newStatus);
}
