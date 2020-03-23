package com.zensar.bus.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zensar.bus.model.RouteMODL;

public interface RouteDAO extends CrudRepository<RouteMODL, Integer> {
@Transactional
@Modifying
@Query(value= "update  route set availableSeat=availableSeat - 1 where routeId = :routeId",nativeQuery=true) 
int updateSeats(@Param("routeId") Integer routeId);

@Query(value= "select availableSeat from  route where routeId = :routeId",nativeQuery=true) 
int getSeats(@Param("routeId") Integer routeId);
}
