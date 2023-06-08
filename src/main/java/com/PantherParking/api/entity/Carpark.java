package com.PantherParking.api.entity;

import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "carpark")
public class Carpark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="cp_user_id")
	private int carparkID;

	
	@Column(name ="carpark_name",unique=true)
	private String carparkName;
	
	@Column(name ="location_lattitude")
	private String locationLattitude;
	
	@Column(name ="location_longitude")
	private String locationLongitude;
	
	@Column(name ="contact_number")
	private String contactNumber;
	
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<ParkingSlot> getParkingslots() {
		return parkingslots;
	}

	public void setParkingslots(List<ParkingSlot> parkingslots) {
		this.parkingslots = parkingslots;
	}

	@OneToMany(mappedBy="carpark")
	private List<CarparkUserAccount> accounts;
	
	@OneToMany(mappedBy="carpark")
	private List<ParkingSlot> parkingslots;
	
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
	
	public List<CarparkUserAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<CarparkUserAccount> accounts) {
		this.accounts = accounts;
	}
	
}
