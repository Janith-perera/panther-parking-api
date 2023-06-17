package com.PantherParking.api.controller.Carpark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PantherParking.api.entity.SlotBooking;
import com.PantherParking.api.service.carpark.CarparkReservationService;

@CrossOrigin
@RestController
@RequestMapping("/pantherapi/reservations")
public class CarparkReservationController {
	
	@Autowired
	private CarparkReservationService cpRSV;
	
	@GetMapping("/view/{cpid}/{status}")
	public  List<SlotBooking> CarparkRersevations(@PathVariable("cpid") int carparkId,@PathVariable("status")  String status) {
		if(status.equals("all")) {
			return cpRSV.viewReservations(carparkId);
		}
		return cpRSV.viewReservations(status, carparkId);
	}
	
//	@PostMapping("/new")
//	public  SlotBooking newCarparkRersevations() {
//		
//	}
	
	
	
	
//	@GetMapping("/view/{cpid}/{status}")
//	public  List<SlotBooking> addCarparkRersevations(@PathVariable("cpid") int carparkId,@PathVariable("status")  String status) {
//		if(status.equals("all")) {
//			return cpRSV.viewReservations(carparkId);
//		}
//		return cpRSV.viewReservations(status, carparkId);
//	}
	
}
