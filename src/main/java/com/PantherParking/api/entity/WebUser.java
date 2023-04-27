package com.PantherParking.api.entity;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

public class WebUser {
	
	@Id
	@Basic(optional=false)
	@Column(name ="WEBUSERID")
	private String webUserId;
	
	@Basic(optional=false)
	@Column(name ="NAME")
	private String name;
	
	@Column(name ="ADDRESS")
	private String Address;
	
	@Basic(optional=false)
	@Column(name ="NIC")
	private String nic;
	
	
	public String getWebUserId() {
		return webUserId;
	}
	public void setWebUserId(String webUserId) {
		this.webUserId = webUserId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	
	
}
