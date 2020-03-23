package com.zensar.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bus.dao.BusDAO;
import com.zensar.bus.model.BusMODL;

@RestController
public class BusController {

	
	  @Autowired
	  private BusDAO busDao;
	 

	  @RequestMapping(method = RequestMethod.POST, path = "/bus_entry")
	  public BusMODL busEntry(){
		   BusMODL bus= busDao.save(new BusMODL(1, 50, true, "Sachin", 10));
		  return bus;
	  }
}
