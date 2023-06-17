package com.PantherParking.api.entity;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="PRAKING")
public class Parking {
	
	@Id
	@Basic(optional=false)
	@Column(name ="parking_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ParkingId;
	
	@Basic(optional=false)
	@Column(name ="arrived_date")
	@Temporal(TemporalType.DATE)
	private Date arrivedDate;
	
	@Basic(optional=false)
	@Column(name ="arrived_time")
	@Temporal(TemporalType.TIME)
	private Time arrivedTime;
	
	@Column(name ="leaved_date")
	@Temporal(TemporalType.DATE)
	private Date leavedDate;
	
	@Column(name ="leaved_time")
	@Temporal(TemporalType.TIME)
	private Time leavedTime;
	
	@ManyToOne
    @JoinColumn(name="slot_id", nullable=false)
	private ParkingSlot parkingSlotId;
	
	@OneToOne(mappedBy = "parking", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ParkingPayments parkingPayment;
	
	public int getParkingId() {
		return ParkingId;
	}
	public void setParkingId(int parkingId) {
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
	public ParkingSlot getParkingSlotId() {
		return parkingSlotId;
	}
	public void setParkingSlotId(ParkingSlot parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}
	public ParkingPayments getParkingPayment() {
		return parkingPayment;
	}
	public void setParkingPayment(ParkingPayments parkingPayment) {
		this.parkingPayment = parkingPayment;
	}
	
	
}
