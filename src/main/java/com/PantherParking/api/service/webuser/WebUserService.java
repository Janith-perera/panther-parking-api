package com.PantherParking.api.service.webuser;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PantherParking.api.Response.VehicleDTOResponse;
import com.PantherParking.api.entity.Vehicle;
import com.PantherParking.api.entity.WebUser;
import com.PantherParking.api.entity.WebUserAccount;

@Service
public interface WebUserService {

	WebUserAccount getWebuserByUsername(String username);
	
	WebUser getWebuserById(int id);

	boolean isUsernameAvailable(String username);

	WebUser addNewWebUser(WebUser wb);

	WebUserAccount addAccount(WebUserAccount account);
	
	Vehicle addNewVehicle(Vehicle v);


	List<VehicleDTOResponse> getVehicles(WebUser userId);


	Vehicle getVehicleById(int vid);
}
