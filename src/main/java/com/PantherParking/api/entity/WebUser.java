package com.PantherParking.api.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name="WEBUSER")
public class WebUser {
	
	@Id
	@Basic(optional=false)
	@Column(name ="web_user_id")
	private String webUserId;
	
	@Basic(optional=false)
	@Column(name ="name")
	private String name;
	
	@Column(name ="address")
	private String Address;
	
	@Basic(optional=false)
	@Column(name ="nic")
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
