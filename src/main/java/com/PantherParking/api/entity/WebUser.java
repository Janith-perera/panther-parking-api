package com.PantherParking.api.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;

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
