package com.PantherParking.api.Response;

public class CarparkResponseDTO {
	private int carparkID;
	private String carparkName;
	private String locationLattitude;
	private String locationLongitude;
	private String contactNumber;
	private int freeSlotCount;
	
	public int getCarparkID() {
		return carparkID;
	}
	public void setCarparkID(int carparkID) {
		this.carparkID = carparkID;
	}
	public String getCarparkName() {
		return carparkName;
	}
	public void setCarparkName(String carparkName) {
		this.carparkName = carparkName;
	}
	public String getLocationLattitude() {
		return locationLattitude;
	}
	public void setLocationLattitude(String locationLattitude) {
		this.locationLattitude = locationLattitude;
	}
	public String getLocationLongitude() {
		return locationLongitude;
	}
	public void setLocationLongitude(String locationLongitude) {
		this.locationLongitude = locationLongitude;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getFreeSlotCount() {
		return freeSlotCount;
	}
	public void setFreeSlotCount(int freeSlotCount) {
		this.freeSlotCount = freeSlotCount;
	}
	
}
