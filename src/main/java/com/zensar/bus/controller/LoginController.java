package com.zensar.bus.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.zensar.bus.model.UserMODL;
import com.zensar.bus.userLogin.BusPortalLogin;

@RestController
public class LoginController {
@Autowired
BusPortalLogin busportalLogin;
private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class.getClass());


	
@RequestMapping(value="/loginUser",method=RequestMethod.POST)
public ResponseEntity<Object> login(@Valid @RequestBody UserMODL loginDetails) throws MethodArgumentNotValidException
{
	
	 LOGGER.info("Login to system");
	 ResponseEntity<Object> details=busportalLogin.update(loginDetails);
	 return details;
}
		

/*@RequestMapping(value="/loginc",method=RequestMethod.POST)
public void save(@RequestBody UserMODL loginDetails)
{
	
	busportalLogin.save(loginDetails);
}*/
}
