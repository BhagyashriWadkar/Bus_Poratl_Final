package com.zensar.bus.service;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bus.controller.LoginController;
import com.zensar.bus.dao.BusPassDAO;
import com.zensar.bus.dao.PickUpPointDAO;
import com.zensar.bus.dao.RouteDAO;
import com.zensar.bus.dao.UserDAO;
import com.zensar.bus.exception.NotNullException;
import com.zensar.bus.exception.PickupPointNotfoundException;
import com.zensar.bus.exception.RouteNotfoundException;
import com.zensar.bus.exception.UserNotfoundException;
import com.zensar.bus.exception.SeatUnavailableException;
import com.zensar.bus.model.BusPassMODL;
import com.zensar.bus.model.PassStatusEnum;
import com.zensar.bus.model.UserMODL;



@Service
public class PassService {
@Autowired 
BusPassDAO busPassDAO;
@Autowired
PickUpPointDAO pickupPointDAO;
@Autowired
RouteDAO routeDAO;
@Autowired
UserDAO userDAO;
private static final Logger LOGGER=LoggerFactory.getLogger(PassService.class.getClass());

public BusPassMODL save(BusPassMODL passDetails)
{
	if(passDetails.getPassId()==null||passDetails.getPassId()==0) throw new NotNullException();
	Optional<UserMODL> user =userDAO.findById(passDetails.getStaffId());
	if(!(user.isPresent())) throw new UserNotfoundException();
	if(!(routeDAO.findById(passDetails.getRouteId()).isPresent())) throw new RouteNotfoundException();
	if(!(pickupPointDAO.findById(passDetails.getPointId()).isPresent())) throw new PickupPointNotfoundException();
	LOGGER.info("Inside PassService for staffID: "+passDetails.getStaffId()+" with pass ID: "+passDetails.getPassId());
	String passType=passDetails.getPassType();
	if(passDetails.getPassStartDate()==(null))
		passDetails.setPassStartDate(new Date());
	if(passType.equals("Daily"))
	{
		Date startDate=passDetails.getPassStartDate();
		Date endDate=new Date();
		endDate.setTime(startDate.getTime() + 1 * 1000 * 60 * 60 * 24);
		passDetails.setPassEndDate(endDate);
	}
	if(passType.equals("Weekly"))
	{
		Date startDate=passDetails.getPassStartDate();
		Date endDate=new Date();
		endDate.setTime(startDate.getTime() + 7 * 1000 * 60 * 60 * 24);
		passDetails.setPassEndDate(endDate);
		
	}
	if(passType.equals("Monthly"))
	{
		Date startDate=passDetails.getPassStartDate();
		Date endDate=new Date();
		endDate.setTime(startDate.getTime() + 30 * 1000L * 60L * 60L * 24);
		passDetails.setPassEndDate(endDate);
		
	}
	
	int pointId=passDetails.getPointId();	
	int cost=0;
	if(passType.equals("Daily"))
	{
		cost =pickupPointDAO.findCostDailyById(pointId);
	}
	else if(passType.equals("Weekly"))
	{
		cost =pickupPointDAO.findCostWeeklyById(pointId);
	}
	else
	{
		cost =pickupPointDAO.findCostMonthlyById(pointId);
	}
	//System.out.println(cost);
	passDetails.setCost(cost);
	
	passDetails.setPassStatus(PassStatusEnum.Pending.toString());
	int routeId=passDetails.getRouteId();
	int seats=routeDAO.getSeats(routeId);
	if (seats<0)throw new NotNullException();
	else
	{
	routeDAO.updateSeats(routeId);
	}
	return busPassDAO.save(passDetails);
	
}


public List<BusPassMODL> getAll()
{
	List<BusPassMODL> passes=new ArrayList<>();
	busPassDAO.findAll().forEach(passes::add);
	return passes;
}
}
