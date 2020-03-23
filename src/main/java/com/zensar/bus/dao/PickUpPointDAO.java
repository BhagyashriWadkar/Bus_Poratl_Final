package com.zensar.bus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zensar.bus.model.PickUpPointMODL;

public interface PickUpPointDAO extends CrudRepository<PickUpPointMODL, Integer> {

	//List<PickUpPointMODL> findByrouteId(Integer routeId);
	
	@Query(value= "SELECT pointId FROM pickuppoint  where pointName = :pointName",nativeQuery=true) 
    int findPointIdtByName(@Param("pointName") String pointName);
	
	@Query(value= "SELECT monthlyCost FROM pickuppoint t where t.pointId = :id",nativeQuery=true) 
    int findCostMonthlyById(@Param("id") int id);
	
	@Query(value= "SELECT weeklyCost FROM pickuppoint t where t.pointId = :id",nativeQuery=true) 
    int findCostWeeklyById(@Param("id") int id);
	
	@Query(value= "SELECT dailyCost FROM pickuppoint t where t.pointId = :id",nativeQuery=true) 
    int findCostDailyById(@Param("id") int id);
	
	List<PickUpPointMODL> findByrouteId(Integer routeId);
}
