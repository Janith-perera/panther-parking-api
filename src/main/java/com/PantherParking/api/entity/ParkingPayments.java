package com.PantherParking.api.entity;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name="PARKINGPAYMENTS")
public class ParkingPayments {
	
	@Id
	@Basic(optional=false)
	@Column(name ="PAYMENTID")
	private String paymentId;
	
	@Basic(optional=false)
	@Column(name ="STATUS")
	private String status;
	
	@Basic(optional=false)
	@Column(name ="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Basic(optional=false)
	@Column(name ="AMOUNT")
	private double amount;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "PARKINGID")
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
