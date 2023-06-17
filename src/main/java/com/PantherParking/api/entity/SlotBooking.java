package com.PantherParking.api.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="SLOTBOOKING")
public class SlotBooking {
	
	@Id
	@Basic(optional=false)
	@Column(name ="booking_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@Basic(optional=false)
	@Column(name ="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Basic(optional=false)
	@Column(name ="start_time")
	@Temporal(TemporalType.TIME)
	private Time startTime;
	
	@Basic(optional=false)
	@Column(name ="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="slot")
	private ParkingSlot slot;
	
	@ManyToOne
	@JoinColumn(name="carpark")
	private Carpark carpark;
	
	

	public ParkingSlot getSlot() {
		return slot;
	}

	public void setSlot(ParkingSlot slot) {
		this.slot = slot;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
