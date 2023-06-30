package com.PantherParking.api.impl.webuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PantherParking.api.entity.Vehicle;
import com.PantherParking.api.entity.WebUser;
import com.PantherParking.api.entity.WebUserAccount;
import com.PantherParking.api.repository.VehicleRpository;
import com.PantherParking.api.repository.WebUserRepository;
import com.PantherParking.api.repository.WebuserAccountRepository;
import com.PantherParking.api.service.webuser.WebUserService;

@Service
public class WebUserImple implements WebUserService {
	
	@Autowired
	private WebuserAccountRepository wbuAcRepo; 
	
	@Autowired
	private WebUserRepository wbUserRepo;
	
	private VehicleRpository vRepo;
	
	@Override
	public WebUserAccount getWebuserByUsername(String username) {
		return wbuAcRepo.findByUsername(username);
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		
		return !wbuAcRepo.existsByUsername(username) ;
	}

	@Override
	public WebUser addNewWebUser(WebUser wb) {
		
		return wbUserRepo.save(wb);
	}

	@Override
	public WebUserAccount addAccount(WebUserAccount account) {
	
		return wbuAcRepo.save(account);
	}

	@Override
	public Vehicle addNewVehicle(Vehicle vehicle) {
		return vRepo.save(vehicle);
	}

	@Override
	public WebUser getWebuserById(int id) {
		if(wbuAcRepo.findById(id).isPresent())
			return  wbUserRepo.findById(id).get();
		else
			return null;
	}
	
	
	
	

}
