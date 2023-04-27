package com.PantherParking.api.entity;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name="PRAKING")
public class Parking {
	
	@Id
	@Basic(optional=false)
	@Column(name ="PARKINGID")
	private String ParkingId;
	
	@Basic(optional=false)
	@Column(name ="ARRIVEDDATE")
	@Temporal(TemporalType.DATE)
	private Date arrivedDate;
	
	@Basic(optional=false)
	@Column(name ="ARRIVEDTIME")
	@Temporal(TemporalType.TIME)
	private Time arrivedTime;
	
	@Basic(optional=false)
	@Column(name ="LEAVEDDATE")
	@Temporal(TemporalType.DATE)
	private Date leavedDate;
	
	@Basic(optional=false)
	@Column(name ="LEAVEDTIME")
	@Temporal(TemporalType.TIME)
	private Time leavedTime;
	
	@ManyToOne
    @JoinColumn(name="PARKINGSLOTID", nullable=false)
	private ParkingSlot parkingSlotId;
	
	
	
	
	public String getParkingId() {
		return ParkingId;
	}
	public void setParkingId(String parkingId) {
		ParkingId = parkingId;
	}
	public Date getArrivedDate() {
		return arrivedDate;
	}
	public void setArrivedDate(Date arrivedDate) {
		this.arrivedDate = arrivedDate;
	}
	public Time getArrivedTime() {
		return arrivedTime;
	}
	public void setArrivedTime(Time arrivedTime) {
		this.arrivedTime = arrivedTime;
	}
	public Date getLeavedDate() {
		return leavedDate;
	}
	public void setLeavedDate(Date leavedDate) {
		this.leavedDate = leavedDate;
	}
	public Time getLeavedTime() {
		return leavedTime;
	}
	public void setLeavedTime(Time leavedTime) {
		this.leavedTime = leavedTime;
	}
	
	

}
