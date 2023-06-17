package com.PantherParking.api.entity;

import java.sql.Date;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PARKINGPAYMENTS")
public class ParkingPayments {
	
	@Id
	@Basic(optional=false)
	@Column(name ="payment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
	@Basic(optional=false)
	@Column(name ="status")
	private String status;
	 
	@Basic(optional=false)
	@Column(name ="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Basic(optional=false)
	@Column(name ="amount")
	private double amount;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "parking")
	private Parking parking;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}
	
	
	
	
	
	
}
