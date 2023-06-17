package com.PantherParking.api.controller.Carpark;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PantherParking.api.Response.CarparkUserAccountDto;
import com.PantherParking.api.Response.CarparkUserRegistrationDTO;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.entity.CarparkUser;
import com.PantherParking.api.entity.CarparkUserAccount;
import com.PantherParking.api.service.CarparkService;
import com.PantherParking.api.service.carpark.CarparkUserService;

@CrossOrigin
@RestController
@RequestMapping("/pantherapi/carparkuser")
public class CarparkUserController {
	
	@Autowired
	private CarparkService cpService; 
	
	private final CarparkUserService carparkUserService;

	    public CarparkUserController(CarparkUserService carparkUserService) {
	        this.carparkUserService = carparkUserService;
	    }

	    @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody CarparkUserRegistrationDTO registrationDTO) {
	        CarparkUser registeredUser = carparkUserService.registerCarparkUser(registrationDTO);
	        if (registeredUser != null) {
	            return ResponseEntity.ok("User registered successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user");
	        }
	    }
	    
	    @PostMapping("/createAccount")
	    public ResponseEntity<String> createAccount(@RequestBody CarparkUserAccountDto accountDto) {
	        
	    	CarparkUserAccount account = new CarparkUserAccount();
	    	Optional<Carpark>  Ocp =cpService.findById(accountDto.getCpId());
			
			if (Ocp.isPresent()) {
				account.setUsername(accountDto.getUsername());
		        account.setPassword(accountDto.getPassword());
		        account.setAccountType(accountDto.getAccountType());
		        account.setCarpark(Ocp.get());
		        // carpark user needed
		        account.setHashCode("");
		        CarparkUserAccount createdAccount = carparkUserService.addAccount(account);

		        if (createdAccount != null) {
		            return ResponseEntity.ok("Account created successfully.");
		        } else {
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create account.");
		        }
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create account.");
	        

	        
	    }

}
