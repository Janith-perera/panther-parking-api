package com.PantherParking.api.Response;

import java.sql.Date;
import java.sql.Time;

public class SlotBookingDTO {
	
	private int bookingId;
    private Date date;
    private Time startTime;
    private Time leaveTime;
    private String status;
    private int vehicleId;
    private int webUserId;
    private int slotId;
	
	public SlotBookingDTO(int bookingId, Date date, Time startTime,Time leaveTime, String status, int vehicleId, int webUserId) {
		super();
		this.bookingId = bookingId;
		this.date = date;
		this.startTime = startTime;
		this.leaveTime= leaveTime;
		this.status = status;
		this.vehicleId = vehicleId;
		this.webUserId = webUserId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	
	
	public Time getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Time leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

  
    
    

}
