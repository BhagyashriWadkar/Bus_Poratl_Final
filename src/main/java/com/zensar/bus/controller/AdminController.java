package com.zensar.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bus.dao.BusPassDAO;
import com.zensar.bus.dao.UserDAO;
import com.zensar.bus.model.BusPassMODL;
import com.zensar.bus.model.PassStatusEnum;
import com.zensar.bus.model.UserMODL;

@RestController
public class AdminController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	 private BusPassDAO busPassDAO;
	
	@RequestMapping(value = "/buspass/{encryptedToken}/approve_pass/{passId}", method = RequestMethod.POST)
	public ResponseEntity<BusPassMODL> approvePass(@PathVariable String encryptedToken, @PathVariable Integer passId) {
		UserMODL admin = userDAO.findByencryptedToken(encryptedToken);
		BusPassMODL pass  = null; 
		if(admin.isAdmin() == true) {
			 pass = busPassDAO.findBypassId(passId);
			pass.setPassStatus(PassStatusEnum.Approved.toString());
		}
		return new ResponseEntity<BusPassMODL>(pass, HttpStatus.OK);

	}
}
