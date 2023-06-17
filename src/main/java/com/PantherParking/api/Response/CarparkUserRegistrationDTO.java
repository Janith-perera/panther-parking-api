package com.PantherParking.api.Response;

import java.sql.Date;

public class CarparkUserRegistrationDTO {
    private String name;
    private String nic;
    private Date dob;

    // Constructor
    public CarparkUserRegistrationDTO(String name, String nic, Date dob) {
        this.name = name;
        this.nic = nic;
        this.dob = dob;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * @param nic the nic to set
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

    
    // Getters and Setters
    // ...
}
