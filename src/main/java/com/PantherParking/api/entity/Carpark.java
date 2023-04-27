package com.PantherParking.api.entity;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name = "carpark")
public class Carpark {
	
	@Id
	@Basic(optional=false)
	@Column(name ="CPUSERID")
	private String carparkID;

	@Column(name ="CARPARKNAME")
	private String carparkName;
	
	@Column(name ="LOCATIONLATTITUDE")
	private String locationLattitude;
	
	@Column(name ="LOCATIONLONGITUDE")
	private String locationLongitude;
	
	@OneToMany(mappedBy="carpark")
	private List<CarparkUserAccount> accounts;
	
	@OneToMany(mappedBy="carpark")
	private List<ParkingSlot> parkingslots;
	
	public String getCarparkID() {
		return carparkID;
	}

	public void setCarparkID(String carparkID) {
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
