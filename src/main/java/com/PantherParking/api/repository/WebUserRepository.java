package com.PantherParking.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.PantherParking.api.entity.WebUser;

public interface WebUserRepository extends CrudRepository<WebUser, Integer> {

}
