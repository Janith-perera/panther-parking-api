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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PARKINGPAYMENTS")
public class ParkingPayments {
	
	@Id
	@Basic(optional=false)
	@Column(name ="payment_id")
	private String paymentId;
	
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
    @JoinColumn(name = "parking_")
	private Parking parking;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
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
	
	
	
	
}
