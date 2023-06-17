package com.PantherParking.api.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	@Id
	@Basic(optional=false)
	@Column(name ="vehicle_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;
	
	@Basic(optional=false)
	@Column(name ="type")
	private String vehicleType;
	
	@Column(name ="brand")
	private String vehcileBrand;
	
	@Column(name ="model")
	private String vehcileModel;
	
	@Basic(optional=false)
	@Column(name ="reg_number")
	private String vehicleNumber;
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
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
	public String getVehcileBrand() {
		return vehcileBrand;
	}
	public void setVehcileBrand(String vehcileBrand) {
		this.vehcileBrand = vehcileBrand;
	}
	public String getVehcileModel() {
		return vehcileModel;
	}
	public void setVehcileModel(String vehcileModel) {
		this.vehcileModel = vehcileModel;
	}
	
	
	
	
	
}
