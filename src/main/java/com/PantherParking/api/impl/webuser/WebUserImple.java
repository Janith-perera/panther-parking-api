package com.PantherParking.api.impl.webuser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PantherParking.api.Response.VehicleDTOResponse;
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
	@Autowired
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
	
	
	@Override
	public List<VehicleDTOResponse> getVehicles(WebUser userId) {
		List<Vehicle> vhList = vRepo.findAllByWebUser(userId);
		
		List<VehicleDTOResponse> vhResList = new ArrayList<VehicleDTOResponse>();
		for(Vehicle vh : vhList  ) {
			VehicleDTOResponse vdr = new VehicleDTOResponse();
			vdr.setVehicleId(vh.getVehicleId());
			vdr.setBrand(vh.getVehcileBrand());
			vdr.setModel(vh.getVehcileModel());
			vdr.setType(vh.getVehicleType());
			vdr.setRegNumber(vh.getVehicleNumber());
			vhResList.add(vdr);
		}
		return vhResList ;
	}
	
	@Override
	public Vehicle getVehicleById(int vid) {
		Optional<Vehicle> vehicle =  vRepo.findById(vid);
		if(vehicle.isPresent())
			return vehicle.get();
		return null;
	}
	
	
	
	

}
