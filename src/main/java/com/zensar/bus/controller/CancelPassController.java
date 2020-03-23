package com.zensar.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bus.service.CancelPassService;

@RestController
public class CancelPassController {
	
	@Autowired
	private CancelPassService cancelPassService;
	
	@RequestMapping(value="/cancelPass", method=RequestMethod.POST)
	public String cancelPass(@RequestBody Integer passId)
	{
		return  cancelPassService.canclePass(passId);	 
	}

}
