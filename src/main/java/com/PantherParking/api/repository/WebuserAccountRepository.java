package com.PantherParking.api.repository;

import org.springframework.data.repository.CrudRepository;


import com.PantherParking.api.entity.WebUserAccount;

public interface WebuserAccountRepository extends CrudRepository<WebUserAccount, Integer> {

	boolean existsByUsername(String username);

	WebUserAccount findByUsername(String username);
	
	
}
