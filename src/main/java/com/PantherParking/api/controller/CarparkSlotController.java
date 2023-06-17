package com.PantherParking.api.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.PantherParking.api.Response.SlotInfoDTO;
import com.PantherParking.api.Response.SlotsCount;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.entity.ParkingSlot;
import com.PantherParking.api.request.parkingslots.ParkingRequest;
import com.PantherParking.api.service.CarparkService;
import com.PantherParking.api.service.ParkingSlotService;

@CrossOrigin
@RestController
@RequestMapping("/pantherapi/slots")
public class CarparkSlotController {
	
	@Autowired
	private CarparkService cpService; 
	
	@Autowired
	private ParkingSlotService pSlotService;
	

	
	@PostMapping("/add/{cpid}")
	public String addParkingSlot(@PathVariable("cpid")int cpid,  @RequestBody ParkingSlot slot) {
		
		Optional<Carpark>  Ocp =cpService.findById(cpid);
		
		if (Ocp.isPresent()) {
		    
			Carpark cp=Ocp.get();
			
			slot.setCarpark(cp);
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new Date(date.getTime());
			java.sql.Time sqlTime = new Time(date.getTime());
			
			slot.setDateAvailableFrom(sqlDate);
			slot.setTimeAvailableFrom(sqlTime);
			
			
			ParkingSlot ps= pSlotService.addParkingSlot(slot);
						
			return ps.getDateAvailableFrom().toString();
		}
		return "";
		
		//return cp.;
	}
	@PostMapping("/addmore/{cpid}")
	public String addParkingSlotMore(@PathVariable("cpid")int cpid,  @RequestBody List<ParkingSlot> slots) {
		Optional<Carpark>  Ocp =cpService.findById(cpid);
		if (Ocp.isPresent()) {
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new Date(date.getTime());
			java.sql.Time sqlTime = new Time(date.getTime());
			Carpark cp=Ocp.get();
			for (ParkingSlot slot : slots) {
				if(pSlotService.getIfAvailable(cp, slot.getSlotRefNumber() ).isPresent())
					continue ;
	            slot.setCarpark(cp);
	            slot.setDateAvailableFrom(sqlDate);
				slot.setTimeAvailableFrom(sqlTime);
	            ParkingSlot addedSlot = pSlotService.addParkingSlot(slot);
	        }

			return "okay";
		}
		return "";
		
		//return cp.;
	}
	
	
//	@PutMapping("/update")
	public String updateSlotAvailability(@RequestBody String[] freeSlots) {
		
		String [] fSlots = freeSlots;
		List<ParkingSlot> updatedParkingSlots = new ArrayList<>();
		
	    for (String slotId : fSlots) {
	    	int slotIdInt = Integer.valueOf(slotId);
	    	System.out.println(slotIdInt);
	        //ParkingSlot updatedParkingSlot = pSlotService.updateAvailability(slotIdInt, true);
	        //updatedParkingSlots.add(updatedParkingSlot);
	    }
	    return "";
	}
	
	@PutMapping("/{cpid}/updateslotsavb")
	public void updateAvailabilityParkingSlots(@PathVariable("cpid") int cpid, @Validated @RequestBody ParkingRequest parkingRequest, BindingResult bindingResult) {
	       if (bindingResult.hasErrors()) {
	    	   System.out.println(bindingResult.getAllErrors());
	       } else {
	            String[] parkingFreeSlotsIds = parkingRequest.getParkingFreeSlotsIds();
	            String[] parkingUsedSlotsIds = parkingRequest.getParkingUsedSlotsIds();
	            
				int freeSlotCount = parkingRequest.getFreeSlotCount();
				System.out.println(freeSlotCount);
				
	            Optional<Carpark>  Ocp =cpService.findById(cpid);
	    		if (Ocp.isPresent()) {
	    			Carpark cp=Ocp.get();
	    			for (String slotId : parkingUsedSlotsIds) {
		    	    	Optional<ParkingSlot> psl = pSlotService.updateSlotAvailabilityByCarparkAndRefNumber(cp, slotId, false);
		    	    	if(psl.isPresent()) {
		    	    		System.out.println(psl.get().getSlotID());
		    	    	}
		    	    }
	    			for (String slotId : parkingFreeSlotsIds) {
		    	    	Optional<ParkingSlot> psl = pSlotService.updateSlotAvailabilityByCarparkAndRefNumber(cp, slotId, true);
		    	    	if(psl.isPresent()) {
		    	    		System.out.println("Free "+psl.get().getSlotID());
		    	    	}
		    	    }
	    		}   	    
	       }	       
	  }
	
	@GetMapping("{cpid}/freeslotcount")
	public SlotsCount getFreeSlotCount(@PathVariable("cpid") int cpid) {
		return  new SlotsCount(pSlotService.getFreeSlotCount(cpid), pSlotService.getAllSlotCont(cpid));
	}
	
	@GetMapping("{cpid}/usedslotcount")
	public SlotsCount getUsedSlotCount(@PathVariable("cpid") int cpid) {
		return  new SlotsCount(pSlotService.getUsedSlotCount(cpid), pSlotService.getAllSlotCont(cpid));
	}
	
	@GetMapping("{cpid}/disabledslotcount")
	public SlotsCount getDisabledSlotCount(@PathVariable("cpid") int cpid) {
		return  new SlotsCount(pSlotService.getDisabledSlotCont(cpid), pSlotService.getAllSlotCont(cpid));
	}
	
	@GetMapping("{cpid}/freeslots")
	public List<SlotInfoDTO> getFreeSlot(@PathVariable("cpid") int cpid) {
		return  pSlotService.getFreeParkingSlots(cpid);
	}
	
	@GetMapping("{cpid}/usedslots")
	public List<SlotInfoDTO> getUsedSlot(@PathVariable("cpid") int cpid) {
		return  pSlotService.getUsedParkingSlots(cpid);
	}	
	
	

}
