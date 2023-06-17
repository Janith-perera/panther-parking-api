package com.PantherParking.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.PantherParking.api.Response.SlotInfoDTO;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.entity.ParkingSlot;

@Service
public interface ParkingSlotService {
    ParkingSlot addParkingSlot(ParkingSlot parkingSlot);
    ParkingSlot updateAvailability(int slotId, boolean isAvailable);
    ParkingSlot updateStatus(int slotId, String status);
    ParkingSlot updateBookedStatus(int slotId, boolean isBookedNow);
	
	Optional<ParkingSlot> updateSlotAvailabilityByCarparkAndRefNumber(Carpark carparkId, String slotRefNumber,boolean isAvailable);
	Optional<ParkingSlot> getIfAvailable(Carpark carpark, String slotRefNumber);
	Optional<ParkingSlot> getIfAvailable(Carpark carpark, String slotRefNumber, boolean avblStatus);
	int getFreeSlotCount(int cpid);
	int getUsedSlotCount(int cpid);
	int getAllSlotCont(int cpid);
	int getDisabledSlotCont(int cpid);
	List<SlotInfoDTO> getFreeParkingSlots(int cpid);
	List<SlotInfoDTO> getUsedParkingSlots(int cpid);
	List<SlotInfoDTO> getDisabledParkingSlots(int cpid);
}

