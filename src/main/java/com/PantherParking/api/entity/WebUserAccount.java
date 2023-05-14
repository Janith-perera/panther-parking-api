package com.PantherParking.api.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="WevbUser")
public class WebUserAccount {
	
	@Id
	@Basic(optional=false)
	@Column(name ="web_user_acount_id")
	private int accountId;
	
	@Basic(optional=false)
	@Column(name ="username")
	private String username;
	
	@Basic(optional=false)
	@Column(name ="password")
	private String password;
	
	@Column(name ="hashcode")
	private String hashcode;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "webuser_id")
	private WebUser webUser;
	

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashvode() {
		return this.hashcode;
	}

	public void setHashvode(String hashcode) {
		this.hashcode = hashcode;
	}
	
	
	
}
