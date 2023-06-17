package com.PantherParking.api.impl.carpark;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PantherParking.api.Response.CarparkUserRegistrationDTO;
import com.PantherParking.api.entity.CarparkUser;
import com.PantherParking.api.entity.CarparkUserAccount;
import com.PantherParking.api.repository.CarparkUserAccountRepository;
import com.PantherParking.api.repository.CarparkUserRepository;
import com.PantherParking.api.service.carpark.CarparkUserService;


@Service
public class CarparkUserServiceImple implements CarparkUserService {
	
	@Autowired
    private  CarparkUserRepository carparkUserRepository;
	
	@Autowired
	private CarparkUserAccountRepository carparkUSerAccountRepository;

   
	@Override
    public CarparkUser registerCarparkUser(CarparkUserRegistrationDTO registrationDTO) {
        CarparkUser carparkUser = new CarparkUser();
        carparkUser.setName(registrationDTO.getName());
        carparkUser.setNic(registrationDTO.getNic());
        carparkUser.setDob(registrationDTO.getDob());


        return carparkUserRepository.save(carparkUser);
    }


	@Override
	public CarparkUserAccount addAccount(CarparkUserAccount account) {
		return carparkUSerAccountRepository.save(account);
	}

}
