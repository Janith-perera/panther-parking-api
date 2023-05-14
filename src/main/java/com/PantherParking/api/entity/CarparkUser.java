package com.PantherParking.api.entity;
import java.sql.Date;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name = "carparkUser")
public class CarparkUser {
	@Id
	@Basic(optional=false)
	@Column(name ="cp_user_id")
	private String CPUserID;
	
	@Basic(optional=false)
	@Column(name ="name")
	private String name;
	
	@Column(name ="nic")
	private String nic;
	
	@Column(name ="dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	public String getCPUserID() {
		return CPUserID;
	}
	public void setCPUserID(String cPUserID) {
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
