package com.PantherParking.api.service.carpark;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.PantherParking.api.Response.CarparkUserRegistrationDTO;
import com.PantherParking.api.entity.CarparkUser;
import com.PantherParking.api.entity.CarparkUserAccount;

@Service
public interface CarparkUserService {
	CarparkUser registerCarparkUser(CarparkUserRegistrationDTO registrationDTO);

	CarparkUserAccount addAccount(CarparkUserAccount account);
	
	Optional<CarparkUser> getCpUserById(int userId);

	boolean isUsernameAvailable(String username);

	CarparkUserAccount findByUsername(String username);
}
