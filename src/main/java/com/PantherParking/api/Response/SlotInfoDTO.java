package com.PantherParking.api.Response;

import java.sql.Date;
import java.sql.Time;

public class SlotInfoDTO {
	private int slotId;
    private String status;
    private String type;
    private boolean isAvailable;
    private boolean isBookedNow;
    private String slotRefNumber;
    private Date fromDate;
    private Time fromTime;
    
    
    
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean isBookedNow() {
		return isBookedNow;
	}
	public void setBookedNow(boolean isBookedNow) {
		this.isBookedNow = isBookedNow;
	}
	public String getSlotRefNumber() {
		return slotRefNumber;
	}
	public void setSlotRefNumber(String  slotRefNumber) {
		this.slotRefNumber = slotRefNumber;
	}
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Time getFromTime() {
		return fromTime;
	}
	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}
	
	

    
}

