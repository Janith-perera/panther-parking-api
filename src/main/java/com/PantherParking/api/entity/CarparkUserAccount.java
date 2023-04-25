package com.PantherParking.api.entity;
//import java.sql.Date;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

@Entity
@Table(name="carparkuseraccout")
public class CarparkUserAccount {
	@Id
	@Basic(optional=false)
	@Column(name ="CPAccountId")
	private String accountId;
	
	@Basic(optional=false)
	@Column(name ="username")
	private String username;
	
	@Basic(optional=false)
	@Column(name ="password")
	private String password;
	
	@Basic(optional=false)
	@Column(name ="hashcode")
	private String hashCode;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPUserID")
	private CarparkUser CPUserID;
	
	@Column(name ="accountType")
	private char accountType;
	
	@ManyToOne
    @JoinColumn(name="carpark", nullable=false)
	private Carpark carpark;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public Carpark getCarparkId() {
		return carpark;
	}

	public void setCarparkId(Carpark carpark) {
		this.carpark = carpark;
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

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public CarparkUser getCPUserID() {
		return CPUserID;
	}

	public void setCPUserID(CarparkUser cPUserID) {
		CPUserID = cPUserID;
	}

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}
	
}
