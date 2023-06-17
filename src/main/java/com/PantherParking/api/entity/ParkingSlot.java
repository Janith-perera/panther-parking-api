package com.PantherParking.api.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="PARKINGSLOT")
public class ParkingSlot {
	@Id
	@Basic(optional=false)
	@Column(name ="slot_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int slotID;
	
	@Column(name ="status")
	private String status;
	
	@Column(name ="type")
	private String type;
	
	@Column(name ="availability")
	private boolean isAvailable;
	
	@Column(name ="reserve_status")
	private boolean isBookedNow;
	
	@Basic(optional=false)
	@Column(name ="slot_ref_number")
	private String slotRefNumber;
	
	
	@Column(name ="date_available")
	@Temporal(TemporalType.DATE)
	private Date dateAvailableFrom;
	

	@Column(name ="time_available")
	@Temporal(TemporalType.TIME)
	private Time timeAvailableFrom;
	

	@ManyToOne
    @JoinColumn(name="carpark", nullable=false)
	private Carpark carpark;
	
	@OneToMany(mappedBy="ParkingId")
	private List<Parking> parkings; 
 	
	@OneToMany(mappedBy="slot")
	private List<SlotBooking> slotsBookings;
	
	public boolean isBookedNow() {
		return isBookedNow;
	}
	
	public void setBookedNow(boolean isBookedNow) {
		this.isBookedNow = isBookedNow;
	}
	
	
	public List<Parking> getParkings() {
		return parkings;
	}
	public void setParkings(List<Parking> parkings) {
		this.parkings = parkings;
	}

	
	
	public List<SlotBooking> getSlotsBookings() {
		return slotsBookings;
	}

	public void setSlotsBookings(List<SlotBooking> slotsBookings) {
		this.slotsBookings = slotsBookings;
	}

	public Carpark getCarpark() {
		return carpark;
	}
	public void setCarpark(Carpark carpark) {
		this.carpark = carpark;
	}
	public int getSlotID() {
		return slotID;
	}
	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}
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
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getSlotRefNumber() {
		return slotRefNumber;
	}

	public void setSlotRefNumber(String slotRefNumber) {
		this.slotRefNumber = slotRefNumber;
	}

	public Date getDateAvailableFrom() {
		return dateAvailableFrom;
	}

	public void setDateAvailableFrom(Date dateAvailableFrom) {
		this.dateAvailableFrom = dateAvailableFrom;
	}

	public Time getTimeAvailableFrom() {
		return timeAvailableFrom;
	}

	public void setTimeAvailableFrom(Time timeAvailableFrom) {
		this.timeAvailableFrom = timeAvailableFrom;
	}
	
	
	
	
}
