package com.PantherParking.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PantherParking.api.Response.SlotInfoDTO;
import com.PantherParking.api.entity.Carpark;
import com.PantherParking.api.entity.ParkingSlot;

@Repository
public interface ParkingSlotRepository extends CrudRepository<ParkingSlot, String> {
	Optional< ParkingSlot> findByCarparkAndSlotRefNumber(Carpark carpark, String slotRefNumber);
	Optional<ParkingSlot> findByCarparkAndSlotRefNumberAndIsAvailable(Carpark carpark, String slotRefNumber, boolean isAvailable);

	@Query("SELECT COUNT(s) FROM ParkingSlot s WHERE s.carpark.carparkID = :cpid and s.isAvailable = :avb AND s.status != 'disable'")
	int  getAvailableSlotsCountByCarparkId(@Param("cpid")int carparkId,@Param("avb")boolean availability);
	@Query("SELECT COUNT(s) FROM ParkingSlot s WHERE s.carpark.carparkID = :cpid ")
	int getAllSlotsCountByCarparkId(@Param("cpid")int carparkId);
	@Query("SELECT COUNT(s) FROM ParkingSlot s WHERE s.carpark.carparkID = :cpid AND s.status = 'disable'")
	int getDisabledSlotsCountByCarparkId(@Param("cpid")int carparkId);
	
	@Query("SELECT s FROM ParkingSlot s WHERE s.carpark.carparkID = :cpid and s.isAvailable = :avb AND s.status != 'disable'")
	List<ParkingSlot> getAvailableSlotsByCarparkId(@Param("cpid")int carparkId,@Param("avb")boolean availability);
	
	@Query("SELECT com.PantherParking.api.Response.SlotInfoDTO(s.status, s.type, s.isAvailable, s.isBookedNow, s.slotRefNumber) FROM ParkingSlot s WHERE s.carpark.carparkID = :cpid ")
	List<SlotInfoDTO> getAllSlotsByCarparkId(@Param("cpid")int carparkId);
	
	@Query("SELECT com.PantherParking.api.Response.SlotInfoDTO(s.status, s.type, s.isAvailable, s.isBookedNow, s.slotRefNumber) FROM ParkingSlot s WHERE s.carpark.carparkID = :cpid AND s.status = 'disable'")
	List<SlotInfoDTO> getDisabledSlotsByCarparkId(@Param("cpid")int carparkId);
	
	
	
}
