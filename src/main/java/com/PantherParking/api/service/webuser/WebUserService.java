package com.PantherParking.api.service.webuser;

import org.springframework.stereotype.Service;

import com.PantherParking.api.entity.WebUser;
import com.PantherParking.api.entity.WebUserAccount;

@Service
public interface WebUserService {

	WebUserAccount getWebuserByUsername(String username);

	boolean isUsernameAvailable(String username);

	WebUser addNewWebUser(WebUser wb);

	WebUserAccount addAccount(WebUserAccount account);
}
