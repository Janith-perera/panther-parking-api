package com.PantherParking.api.controller.Carpark;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PantherParking.api.Response.CarparkRegistrationDTO;
import com.PantherParking.api.Response.CarparkUserAccountDto;
import com.PantherParking.api.Response.CarparkUserRegistrationDTO;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.entity.CarparkUser;
import com.PantherParking.api.entity.CarparkUserAccount;
import com.PantherParking.api.request.parkingslots.LoginRequest;
import com.PantherParking.api.service.CarparkService;
import com.PantherParking.api.service.carpark.CarparkUserService;
import com.PantherParking.api.util.PasswordUtils;

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
	    	Optional<CarparkUser> cpUser= carparkUserService.getCpUserById(accountDto.getCpUserId());
	    	boolean isAvailable = carparkUserService.isUsernameAvailable(accountDto.getUsername());
	    	
			if (Ocp.isPresent() && cpUser.isPresent() && isAvailable ) {
				account.setUsername(accountDto.getUsername());
		        account.setPassword(PasswordUtils.hashPassword(accountDto.getPassword()));
		        account.setAccountType(accountDto.getAccountType());
		        account.setCarpark(Ocp.get());
		        account.setCpUser(cpUser.get());
		        
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
	    
	    @GetMapping("/check-username/{username}")
	    public ResponseEntity<Boolean> checkUsernameAvailability(@PathVariable String username) {
	        boolean isAvailable = carparkUserService.isUsernameAvailable(username);
	        return ResponseEntity.ok(isAvailable);
	    }
	    
	    
	    
	    @GetMapping("/dohash/{password}")
	    public String doHash(@PathVariable String password) {
	    	return PasswordUtils.hashPassword(password);
	    }
	    
	    
	    @PostMapping("/register-car-park-user")
	    public ResponseEntity<String> registerCarparkUser(@RequestBody CarparkRegistrationDTO registrationDTO) {
	    	
	    	CarparkUserAccountDto accountDto = registrationDTO.getAccount();
	    	boolean isAvailable = carparkUserService.isUsernameAvailable(accountDto.getUsername());
	        
	        if (!isAvailable) {
	        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user account. username has already taken!");
	        }
	    	
	        Carpark registeredCarpark = cpService.addNewCarpark(registrationDTO.getCarpark());
	        if (registeredCarpark == null) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register carpark.");
	        }
	        
	        // Step 2: Register Carpark User
	        CarparkUser registeredUser = carparkUserService.registerCarparkUser(registrationDTO.getUser());
	        if (registeredUser == null) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register carpark user.");
	        }
	        
	        // Step 3: Create Account
	       
	        CarparkUserAccount account = new CarparkUserAccount();
	        
	            account.setUsername(accountDto.getUsername());
	            account.setPassword(PasswordUtils.hashPassword(accountDto.getPassword()));
	            account.setAccountType(accountDto.getAccountType());
	            account.setCarpark(registeredCarpark);
	            account.setCpUser(registeredUser);
	            account.setHashCode("");
	            
	            CarparkUserAccount createdAccount = carparkUserService.addAccount(account);
	            
	            if (createdAccount != null) {
	                return ResponseEntity.ok("Car park user registered successfully.");
	            } 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create account.");
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
	        String username = loginRequest.getUsername();
	        String password = loginRequest.getPassword();
	        
	        // Find the user account based on the provided username
	        CarparkUserAccount userAccount = carparkUserService.findByUsername(username);
	        
	        if (userAccount != null && isPasswordValid(password, userAccount.getPassword())) {
	            // Successful login
	            // Generate and return a JWT token for authentication/authorization
	            String token = generateToken(userAccount.getCarpark().getCarparkID());
	            
	            return ResponseEntity.ok(token);
	        } else {
	            // Invalid username or password
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    }

	    private boolean isPasswordValid(String password, String hashedPassword) {
	
	    	return  PasswordUtils.isPasswordMatch(password, hashedPassword);
	    }

	    private String generateToken(int cpId) {
	        // Generate a JWT token for the authenticated user
	        // You can use a library like JJWT for token generation
	        // Example: return Jwts.builder().setSubject(userId).signWith(SignatureAlgorithm.HS256, "your-secret-key").compact();
	    	return String.valueOf(cpId);
	    }


}
