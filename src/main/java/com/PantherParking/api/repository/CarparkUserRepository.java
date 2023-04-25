package com.PantherParking.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.PantherParking.api.entity.CarparkUser;

@Repository
public interface CarparkUserRepository extends CrudRepository<CarparkUser,String> {
	
}
