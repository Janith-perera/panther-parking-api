package com.PantherParking.api.controller.Carpark;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PantherParking.api.Response.SlotBookingDTO;
import com.PantherParking.api.entity.SlotBooking;
import com.PantherParking.api.service.carpark.CarparkReservationService;

@CrossOrigin
@RestController
@RequestMapping("/pantherapi/reservations")
public class CarparkReservationController {
	
	@Autowired
	private CarparkReservationService cpRSV;
	
	@GetMapping("/view/{cpid}/{status}")
	public List<SlotBookingDTO>   CarparkRersevations(@PathVariable("cpid") int carparkId,@PathVariable("status")  String status) {
	
		List<SlotBooking> slotBookings ; 
		
		if(status.equals("all")) {
			slotBookings= cpRSV.viewReservations(carparkId);
		}else {
			slotBookings = cpRSV.viewReservations(status, carparkId);
		}
		
		List<SlotBookingDTO> slotBookingDTOs = new ArrayList<>();

		for (SlotBooking slotBooking : slotBookings) {
		     SlotBookingDTO slotBookingDTO = new SlotBookingDTO(
		    		 slotBooking.getBookingId(),
		             slotBooking.getDate(),
		             slotBooking.getStartTime(),
		             slotBooking.getLeaveTime(),
		             slotBooking.getStatus(),
		             slotBooking.getVehicle().getVehicleId(),
		             slotBooking.getWebUser().getWebUserId()
		             
		     );
		     slotBookingDTOs.add(slotBookingDTO);
		}

		return slotBookingDTOs;
		
		
	}
	
	@PutMapping("/update/{bookingId}/{status}")
	public void updateStatus(@PathVariable int bookingId,@PathVariable  String status) {
		cpRSV.updateStatus(bookingId, status);
	}
	
	
	
	
//	@GetMapping("/view/{cpid}/{status}")
//	public  List<SlotBooking> addCarparkRersevations(@PathVariable("cpid") int carparkId,@PathVariable("status")  String status) {
//		if(status.equals("all")) {
//			return cpRSV.viewReservations(carparkId);
//		}
//		return cpRSV.viewReservations(status, carparkId);
//	}
	
}
