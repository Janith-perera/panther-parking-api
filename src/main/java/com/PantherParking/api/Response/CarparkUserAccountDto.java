package com.PantherParking.api.Response;

public class CarparkUserAccountDto {
    private String username;
    private String password;
    private String accountType;
    private int cpId;
    private int cpUserId;
    
    
	/**
	 * @return the cpId
	 */
	public int getCpId() {
		return cpId;
	}
	/**
	 * @param cpId the cpId to set
	 */
	public void setCpId(int cpId) {
		this.cpId = cpId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the cpUserId
	 */
	public int getCpUserId() {
		return cpUserId;
	}
	/**
	 * @param cpUserId the cpUserId to set
	 */
	public void setCpUserId(int cpUserId) {
		this.cpUserId = cpUserId;
	}
	
	

    
}