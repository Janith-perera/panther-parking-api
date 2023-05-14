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
	@Column(name ="vehicle_id")
	private String vehicleId;
	
	@Basic(optional=false)
	@Column(name ="type")
	private String vehicleType;
	
	@Column(name ="model")
	private String vehcileModel;
	
	@Basic(optional=false)
	@Column(name ="reg_number")
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
		return vehcileModel;
	}
	public void setVehcileModle(String vehcileModel) {
		this.vehcileModel = vehcileModel;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	
	
	
}
