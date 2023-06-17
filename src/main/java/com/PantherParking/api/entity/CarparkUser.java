package com.PantherParking.api.entity;
import java.sql.Date;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "carparkUser")
public class CarparkUser {
	@Id
	@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="cp_user_id")
	private int CPUserID;
	
	@Basic(optional=false)
	@Column(name ="name")
	private String name;
	
	@Column(name ="nic")
	private String nic;
	
	@Column(name ="dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
//	@ManyToOne
//	@JoinColumn(name="carpark")
//	private Carpark carpark;
//	
//	public Carpark getCarpark() {
//		return carpark;
//	}
//	public void setCarpark(Carpark carpark) {
//		this.carpark = carpark;
//	}
	public int getCPUserID() {
		return CPUserID;
	}
	public void setCPUserID(int cPUserID) {
		CPUserID = cPUserID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}	
	
	
}
