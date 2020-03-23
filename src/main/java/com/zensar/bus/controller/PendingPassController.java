package com.zensar.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bus.model.BusPassMODL;
import com.zensar.bus.service.PendingPassService;

@RestController
public class PendingPassController {
	
	@Autowired
	private PendingPassService pendingPassService;
	
	/*@RequestMapping(value="/pendingPass", method=RequestMethod.POST)
	public List<BusPassMODL> getPendingPass(@RequestBody Integer staffId)
	{
		return pendingPassService.getPendingPass(staffId);
	}*/
	
	@RequestMapping(value="/pendingPass", method=RequestMethod.POST)
	public List<BusPassMODL> getPendingPass(@RequestBody String encryptedToken)
	{
		return pendingPassService.getPendingPass(encryptedToken);
	}

}
