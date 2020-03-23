package com.zensar.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bus.service.LogOutService;

@RestController
public class LogoutController {
	
	@Autowired
	private LogOutService logOutService;
	
	@RequestMapping(value="/logOut1", method=RequestMethod.POST)
	public String logOut(@RequestBody String encryptedToken)
	{
		System.out.println("encryptedToken"+encryptedToken);
		return logOutService.logOut1(encryptedToken);
	}

}
