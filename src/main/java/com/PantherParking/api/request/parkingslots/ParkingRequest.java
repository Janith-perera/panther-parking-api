package com.PantherParking.api.request.parkingslots;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ParkingRequest {
	
	
    @NotNull(message = "parkingSlotsIds cannot be empty")
    private String[] parkingUsedSlotsIds;
    
    @NotNull(message = "parking free SlotsIds cannot be empty")
    private String[] parkingFreeSlotsIds;

    @NotNull(message = "freeSlotCount cannot be null")
    private Integer freeSlotCount;

	public String[] getParkingUsedSlotsIds() {
		return parkingUsedSlotsIds;
	}

	public void setParkingUsedSlotsIds(String[] parkingUsedSlotsIds) {
		this.parkingUsedSlotsIds = parkingUsedSlotsIds;
	}

	public String[] getParkingFreeSlotsIds() {
		return parkingFreeSlotsIds;
	}

	public void setParkingFreeSlotsIds(String[] parkingFreeSlotsIds) {
		this.parkingFreeSlotsIds = parkingFreeSlotsIds;
	}

	public Integer getFreeSlotCount() {
		return freeSlotCount;
	}

	public void setFreeSlotCount(Integer freeSlotCount) {
		this.freeSlotCount = freeSlotCount;
	}


    
}
