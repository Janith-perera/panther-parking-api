package com.PantherParking.api.entity;

import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
@Table(name="PARKINGSLOT")
public class ParkingSlot {
	@Id
	@Basic(optional=false)
	@Column(name ="slot_id")
	private String SlotID;
	
	@Column(name ="status")
	private String Status;
	
	@Column(name ="type")
	private String Type;
	
	@Column(name ="availability")
	private boolean isAvalable;
	
	@ManyToOne
    @JoinColumn(name="carpark", nullable=false)
	private Carpark carpark;
	
	@OneToMany(mappedBy="ParkingId")
	private List<Parking> parkings; 
 	
	public Carpark getCarpark() {
		return carpark;
	}
	public void setCarpark(Carpark carpark) {
		this.carpark = carpark;
	}
	public String getSlotID() {
		return SlotID;
	}
	public void setSlotID(String slotID) {
		SlotID = slotID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public boolean isAvalable() {
		return isAvalable;
	}
	public void setAvalable(boolean isAvalable) {
		this.isAvalable = isAvalable;
	}
	
	
}
