package com.PantherParking.api.service.webuser;

import org.springframework.stereotype.Service;

import com.PantherParking.api.entity.SlotBooking;

@Service
public interface WebUserSlotBookingService {
	SlotBooking newSlotbooking(SlotBooking sb);
}
