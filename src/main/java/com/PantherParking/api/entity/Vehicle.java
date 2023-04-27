package com.PantherParking.api.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	@Id
	@Basic(optional=false)
	@Column(name ="VEHICLEID")
	private String vehicleId;
	
	@Basic(optional=false)
	@Column(name ="TYPE")
	private String vehicleType;
	
	@Column(name ="MODLE")
	private String vehcileModle;
	
	@Basic(optional=false)
	@Column(name ="REGNUMBER")
	private String vehicleNumber;
	
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehcileModle() {
		return vehcileModle;
	}
	public void setVehcileModle(String vehcileModle) {
		this.vehcileModle = vehcileModle;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	
	
	
}
