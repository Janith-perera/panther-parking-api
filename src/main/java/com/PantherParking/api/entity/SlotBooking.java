package com.PantherParking.api.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="SLOTBOOKING")
public class SlotBooking {
	
	@Id
	@Basic(optional=false)
	@Column(name ="booking_id")
	private int bookingId;
	
	@Basic(optional=false)
	@Column(name ="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Basic(optional=false)
	@Column(name ="start_time")
	@Temporal(TemporalType.TIME)
	private Time StartTime;
	
	@Basic(optional=false)
	@Column(name ="status")
	private String Status;

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
		return StartTime;
	}

	public void setStartTime(Time startTime) {
		StartTime = startTime;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
