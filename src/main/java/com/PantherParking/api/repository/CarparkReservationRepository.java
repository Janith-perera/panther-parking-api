package com.PantherParking.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.PantherParking.api.entity.SlotBooking;

public interface CarparkReservationRepository extends JpaRepository <SlotBooking,Integer>{
	@Query("SELECT sb FROM  SlotBooking sb  where sb.status= :status and sb.carpark.carparkID= :cpId")
	public List<SlotBooking> findByStatus(@Param("status")String status, @Param("cpId") int carparkId);
	
	@Query("SELECT sb FROM  SlotBooking sb  where  sb.carpark.carparkID= :cpId")
	public List<SlotBooking> findAllByCarparkId( @Param("cpId") int carparkId);
	
}
