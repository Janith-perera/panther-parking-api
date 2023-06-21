package com.PantherParking.api.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="WEBUSERACCOUNT")
public class WebUserAccount {
	
	@Id
	@Basic(optional=false)
	@Column(name ="web_user_acount_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	
	@Basic(optional=false)
	@Column(name ="username")
	private String username;
	
	@Basic(optional=false)
	@Column(name ="password")
	private String password;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "webuser_id")
	private WebUser webUser;
	

	public WebUser getWebUser() {
		return webUser;
	}

	public void setWebUser(WebUser webUser) {
		this.webUser = webUser;
	}

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


	
	
	
	
	
}
