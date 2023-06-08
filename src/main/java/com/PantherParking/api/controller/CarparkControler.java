package com.PantherParking.api.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PantherParking.api.Response.CarparkResponse;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.service.CarparkService;

@CrossOrigin
@RestController
@RequestMapping("/pantherapi/")
public class CarparkControler{
	
	@Autowired
	private CarparkService cpService; 
	
	@PostMapping("carpark/regnew")
	public String registerCarPark(@RequestBody Carpark cp) {
		System.out.println(cp.getCarparkName());
		return cpService.addNewCarpark(cp);
	}
	
	
	@GetMapping("carpark/details/{id}")
	public CarparkResponse viewCarparkById(@PathVariable("id")int id) {
		Optional<Carpark> cp = cpService.findById(id);
		String name = ((cp == null) ? "N/A" : cp.get().getCarparkName());
		String contactNumber = ((cp == null) ? "N/A" : cp.get().getContactNumber());
		return new CarparkResponse(name, contactNumber );
	}
	
	@GetMapping("carpark/{id}/slots/available")
	public String getAvalableParkingSlots(@PathVariable("id")int id) {
		return "test "+id;
	}
	
	@GetMapping("carpark/getall")
	public CarparkResponse viewAll(){
		return cpService.getAll();
	}
	
	@PutMapping("carpark/test/{num}")
	public void testSpaces(@PathVariable("num")int number , @RequestBody Map<String, Object> freeSlots) {
		System.out.println(freeSlots.get("parkingSpaces"));
	}
	
	
	
	
		

}
