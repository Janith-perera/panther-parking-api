package com.PantherParking.api.impl.carpark;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PantherParking.api.Response.SlotInfoDTO;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.entity.ParkingSlot;
import com.PantherParking.api.repository.ParkingSlotRepository;
import com.PantherParking.api.service.ParkingSlotService;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    private final ParkingSlotRepository parkingSlotRepository;

    @Autowired
    public ParkingSlotServiceImpl(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }
    @Override
    public Optional<ParkingSlot> getIfAvailable(Carpark carpark, String slotRefNumber){
    	return  parkingSlotRepository.findByCarparkAndSlotRefNumber(carpark, slotRefNumber);
    }
    
    @Override
    public Optional<ParkingSlot> getIfAvailable(Carpark carpark, String slotRefNumber,boolean avblStatus){
    	return  parkingSlotRepository.findByCarparkAndSlotRefNumberAndIsAvailable(carpark, slotRefNumber,avblStatus);
    }
    

    @Override
    public  Optional<ParkingSlot> updateSlotAvailabilityByCarparkAndRefNumber(Carpark carparkId, String slotRefNumber, boolean isAvailable) {
        Optional<ParkingSlot> parkingSlot = this.getIfAvailable(carparkId, slotRefNumber,!isAvailable);
        if (parkingSlot.isPresent()) {
        	ParkingSlot ps = parkingSlot.get();
        	java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			java.sql.Time sqlTime = new java.sql.Time(date.getTime());
        	ps.setDateAvailableFrom(sqlDate);
        	ps.setTimeAvailableFrom(sqlTime);
        	ps.setIsAvailable(isAvailable);
        	parkingSlotRepository.save(ps);
          
        }
        
        return parkingSlot;
    }

    @Override
    public ParkingSlot addParkingSlot(ParkingSlot parkingSlot) {
    	
    	
        return parkingSlotRepository.save(parkingSlot);
    }

    @Override
    public ParkingSlot updateAvailability(int slotId, boolean isAvailable) {
        ParkingSlot parkingSlot = parkingSlotRepository.findById(String.valueOf(slotId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid slot ID"));
        parkingSlot.setIsAvailable(isAvailable);
        return parkingSlotRepository.save(parkingSlot);
    }

    @Override
    public ParkingSlot updateStatus(int slotId, String status) {
        ParkingSlot parkingSlot = parkingSlotRepository.findById(String.valueOf(slotId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid slot ID"));
        parkingSlot.setStatus(status);
        return parkingSlotRepository.save(parkingSlot);
    }

    @Override
    public ParkingSlot updateBookedStatus(int slotId, boolean isBookedNow) {
        ParkingSlot parkingSlot = parkingSlotRepository.findById(String.valueOf(slotId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid slot ID"));
        parkingSlot.setBookedNow(isBookedNow);
        return parkingSlotRepository.save(parkingSlot);
    }
    
    @Override
    public int getFreeSlotCount(int cpid) {
    	return parkingSlotRepository.getAvailableSlotsCountByCarparkId(cpid,true);
    }
    
    @Override
    public int getUsedSlotCount(int cpid) {
    	return parkingSlotRepository.getAvailableSlotsCountByCarparkId(cpid,false);
    }
	@Override
	public int getAllSlotCont(int cpid) {
		
		return parkingSlotRepository.getAllSlotsCountByCarparkId(cpid);
	}
	@Override
	public int getDisabledSlotCont(int cpid) {
		return parkingSlotRepository.getDisabledSlotsCountByCarparkId(cpid);
	}
	
	@Override
	public List<SlotInfoDTO> getFreeParkingSlots(int cpid){
		List<ParkingSlot> slotList = parkingSlotRepository.getAvailableSlotsByCarparkId(cpid, true);
		List<SlotInfoDTO> slotInfoList = new ArrayList<>();
		for (ParkingSlot result : slotList) {
			
	        SlotInfoDTO slotInfo = new SlotInfoDTO();
	        slotInfo.setSlotId(result.getSlotID());
	        slotInfo.setStatus(result.getStatus());
	        slotInfo.setType(result.getType());
	        slotInfo.setAvailable(result.getIsAvailable());
	        slotInfo.setBookedNow(result.isBookedNow());
	        slotInfo.setSlotRefNumber(result.getSlotRefNumber());
	        slotInfo.setFromDate(result.getDateAvailableFrom());
	        slotInfo.setFromTime(result.getTimeAvailableFrom());
	        slotInfoList.add(slotInfo);
	    }
		return slotInfoList;
	}
	
	@Override
	public List<SlotInfoDTO> getUsedParkingSlots(int cpid){

		List<ParkingSlot> slotList = parkingSlotRepository.getAvailableSlotsByCarparkId(cpid, false);
		List<SlotInfoDTO> slotInfoList = new ArrayList<>();
		for (ParkingSlot result : slotList) {
	        SlotInfoDTO slotInfo = new SlotInfoDTO();
	        slotInfo.setSlotId(result.getSlotID());
	        slotInfo.setStatus(result.getStatus());
	        slotInfo.setType(result.getType());
	        slotInfo.setAvailable(result.getIsAvailable());
	        slotInfo.setBookedNow(result.isBookedNow());
	        slotInfo.setSlotRefNumber(result.getSlotRefNumber());
	        slotInfo.setFromDate(result.getDateAvailableFrom());
	        slotInfo.setFromTime(result.getTimeAvailableFrom());
	        slotInfoList.add(slotInfo);
	    }
		return slotInfoList;
	
	}
	
	@Override
	public List<SlotInfoDTO> getDisabledParkingSlots(int cpid){

		List<ParkingSlot> slotList = parkingSlotRepository.getDisabledSlotsByCarparkId(cpid);
		List<SlotInfoDTO> slotInfoList = new ArrayList<>();
		for (ParkingSlot result : slotList) {
	        SlotInfoDTO slotInfo = new SlotInfoDTO();
	        slotInfo.setSlotId(result.getSlotID());
	        slotInfo.setStatus(result.getStatus());
	        slotInfo.setType(result.getType());
	        slotInfo.setAvailable(result.getIsAvailable());
	        slotInfo.setBookedNow(result.isBookedNow());
	        slotInfo.setSlotRefNumber(result.getSlotRefNumber());
	        slotInfo.setFromDate(result.getDateAvailableFrom());
	        slotInfo.setFromTime(result.getTimeAvailableFrom());
	        slotInfoList.add(slotInfo);
	    }
		return slotInfoList;
	
	}

	
    
    
}

