package com.PantherParking.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.PantherParking.api.entity.CarparkUserAccount;

public interface CarparkUserAccountRepository extends CrudRepository<CarparkUserAccount, String> {
	 boolean existsByUsername(String username);

	CarparkUserAccount findByUsername(String username);
}
