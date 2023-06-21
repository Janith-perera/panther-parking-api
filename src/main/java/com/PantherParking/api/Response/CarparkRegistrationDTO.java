package com.PantherParking.api.Response;

import com.PantherParking.api.entity.Carpark;

public class CarparkRegistrationDTO {
	private Carpark carpark;
	private CarparkUserRegistrationDTO  user;
	private CarparkUserAccountDto account;
	
	public Carpark getCarpark() {
		return carpark;
	}
	public void setCarpark(Carpark carpark) {
		this.carpark = carpark;
	}
	public CarparkUserRegistrationDTO getUser() {
		return user;
	}
	public void setUser(CarparkUserRegistrationDTO user) {
		this.user = user;
	}
	public CarparkUserAccountDto getAccount() {
		return account;
	}
	public void setAccount(CarparkUserAccountDto account) {
		this.account = account;
	}
	
	
	
	
	
}
