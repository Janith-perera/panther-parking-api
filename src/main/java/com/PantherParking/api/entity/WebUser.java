package com.PantherParking.api.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="WEBUSER")
public class WebUser {
	
	@Id
	@Basic(optional=false)
	@Column(name ="web_user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int webUserId;
	
	@Basic(optional=false)
	@Column(name ="name")
	private String name;
	
	@Column(name ="address")
	private String Address;
	
	@Basic(optional=false)
	@Column(name ="nic")
	private String nic;
	
	@OneToMany(mappedBy="webUser")
	private List<SlotBooking> slotBooking;
//	
	@OneToMany(mappedBy="webUser")
	private List<Vehicle> vehicle;
	
	
	
	
	
	
	public int getWebUserId() {
		return webUserId;
	}
	public void setWebUserId(int webUserId) {
		this.webUserId = webUserId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public List<SlotBooking> getSlotBooking() {
		return slotBooking;
	}
	public void setSlotBooking(List<SlotBooking> slotBooking) {
		this.slotBooking = slotBooking;
	}
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	
}
