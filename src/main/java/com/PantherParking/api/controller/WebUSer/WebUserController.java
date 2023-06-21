package com.PantherParking.api.controller.WebUSer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PantherParking.api.Response.CarparkRegistrationDTO;
import com.PantherParking.api.Response.CarparkUserAccountDto;
import com.PantherParking.api.Response.WebuserRegistrationDTO;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.entity.CarparkUser;
import com.PantherParking.api.entity.CarparkUserAccount;
import com.PantherParking.api.entity.WebUser;
import com.PantherParking.api.entity.WebUserAccount;
import com.PantherParking.api.request.parkingslots.LoginRequest;
import com.PantherParking.api.service.webuser.WebUserService;
import com.PantherParking.api.util.PasswordUtils;

@CrossOrigin
@RestController
@RequestMapping("/pantherapi/webuser")
public class WebUserController {
	@Autowired
	private WebUserService wbScv;
	
	 
    @GetMapping("/check-username/{username}")
    public ResponseEntity<Boolean> checkUsernameAvailability(@PathVariable String username) {
        boolean isAvailable = wbScv.isUsernameAvailable(username);
        return ResponseEntity.ok(isAvailable);
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerCarparkUser(@RequestBody WebuserRegistrationDTO accountDto) {
    	
    
    	boolean isAvailable = wbScv.isUsernameAvailable(accountDto.getUsername());
        
        if (!isAvailable) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user account. username has already taken!");
        }
    	
        WebUser wb = new WebUser();
        wb.setName(accountDto.getName());
        wb.setAddress(accountDto.getAddress());
        wb.setNic(accountDto.getNic());
        wb.setEmail(accountDto.getEmail());
        
        WebUser registeredWebUser = wbScv.addNewWebUser(wb);
        
        if (registeredWebUser == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user.");
        }else {

        	WebUserAccount account = new WebUserAccount();
        
            account.setUsername(accountDto.getUsername());
            account.setPassword(PasswordUtils.hashPassword(accountDto.getPassword()));
            account.setWebUser(registeredWebUser);
            
            WebUserAccount createdAccount = wbScv.addAccount(account);
            
            if (createdAccount != null) {
                return ResponseEntity.ok("User registered successfully.");
            } 
        }
        
       
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create account.");
    }
    
    
	
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        
        // Find the user account based on the provided Username
        WebUserAccount  userAccount =  wbScv.getWebuserByUsername(username);
        
        if (userAccount != null && isPasswordValid(password, userAccount.getPassword())) {
            // Successful login
            // Generate and return a JWT token for authentication/authorization
            String token = generateToken(userAccount.getWebUser().getWebUserId());
            
            return ResponseEntity.ok(token);
        } else {
            // Invalid username or password
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    
    
    
    private boolean isPasswordValid(String password, String hashedPassword) {
    	//return password.equals(hashedPassword);
    	return  PasswordUtils.isPasswordMatch(password, hashedPassword);
    }
    
    private String generateToken(int webuserId) {
        // Generate a JWT token for the authenticated user
        // You can use a library like JJWT for token generation
        // Example: return Jwts.builder().setSubject(userId).signWith(SignatureAlgorithm.HS256, "your-secret-key").compact();
    	return String.valueOf(webuserId);
    }


}
