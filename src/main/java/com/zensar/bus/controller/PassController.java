package com.zensar.bus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bus.exception.UserNotfoundException;
import com.zensar.bus.model.BusPassMODL;
import com.zensar.bus.service.PassService;


@RestController
public class PassController {
@Autowired 
PassService passService;

private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class.getClass());

@RequestMapping(value="/passBooking",method=RequestMethod.POST)
public BusPassMODL save(@RequestBody BusPassMODL passDetails)
{
	LOGGER.info("Applying for bus pass inside PassController");	
	return passService.save(passDetails);
	
}

@RequestMapping(value="/pass",method=RequestMethod.POST)
public List<BusPassMODL> getAll()
{
	return passService.getAll();
}
}
