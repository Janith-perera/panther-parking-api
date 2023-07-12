package com.PantherParking.api.request.parkingslots;

import java.sql.Time;

public class SlotBookingRequestDTO {
 
    private int timeDurationTime;
    private int vehicleId;
    private int webUserId;
    private int carparkId;
    
    
    
	public int getCarparkId() {
		return carparkId;
	}
	public void setCarparkId(int carparkId) {
		this.carparkId = carparkId;
	}
	public int getTimeDurationTime() {
		return timeDurationTime;
	}
	public void setTimeDurationTime(int timeDurationTime) {
		this.timeDurationTime = timeDurationTime;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getWebUserId() {
		return webUserId;
	}
	public void setWebUserId(int webUserId) {
		this.webUserId = webUserId;
	}
    
    
}
