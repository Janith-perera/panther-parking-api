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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="carparkuseraccout")
public class CarparkUserAccount {
	@Id
	@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="cp_account_id")
	private int accountId;
	
	@Basic(optional=false)
	@Column(name ="username")
	private String username;
	
	@Basic(optional=false)
	@Column(name ="password")
	private String password;
	
	@Basic(optional=false)
	@Column(name ="hashcode")
	private String hashCode;
	
	@Basic()
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cp_user_id", unique = true)
	private CarparkUser cpUser;
	
	@Column(name ="account_type")
	private String accountType;
	
	@ManyToOne
    @JoinColumn(name="carpark", nullable=false)
	private Carpark carpark;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
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

	public CarparkUser getCPUser() {
		return cpUser;
	}

	public void setCpUser(CarparkUser cPUserID) {
		cpUser = cPUserID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Carpark getCarpark() {
		return carpark;
	}

	public void setCarpark(Carpark carpark) {
		this.carpark = carpark;
	}
	
	
	
}
