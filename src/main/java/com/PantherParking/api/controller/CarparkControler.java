package com.PantherParking.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PantherParking.api.service.CarparkService;

@CrossOrigin
@RestController
@RequestMapping("/pantherapi/")
public class CarparkControler{
	
	@Autowired
	private CarparkService cpService; 
	
	@GetMapping("carpark/regnew")
	public String registerCarPark() {
		return cpService.addNewCarpark();
	}
	
	@GetMapping("carpark/details/{id}")
	public String viewCarparkById(@PathVariable("id")int id) {
		return "dad";
	}
	
	@GetMapping("carpark/{id}/slots/available")
	public String getAvalableParkingSlots(@PathVariable("id")int id) {
		return "test "+id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
