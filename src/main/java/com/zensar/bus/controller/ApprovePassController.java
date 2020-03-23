package com.zensar.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bus.dao.BusPassDAO;
import com.zensar.bus.dao.LoginDAO;
import com.zensar.bus.model.BusPassMODL;
import com.zensar.bus.model.UserMODL;
import com.zensar.bus.service.ApprovePassService;
import com.zensar.bus.service.CancelPassService;
import com.zensar.bus.service.LogOutService;
import com.zensar.bus.service.PendingPassService;

import net.bytebuddy.asm.Advice.Return;


@RestController
public class ApprovePassController {
	
	@Autowired
	private ApprovePassService approvePassService;
	
	/*@RequestMapping(value="/aprrovePass", method=RequestMethod.POST)
	public List<BusPassMODL> getApprovePass(@RequestBody Integer staffId)
	{
		return approvePassService.getApprovePass(staffId);
	}
	*/
	@RequestMapping(value="/aprrovePass", method=RequestMethod.POST)
	public List<BusPassMODL> getApprovePass(@RequestBody String encryptedToken)
	{
		return approvePassService.getApprovePass(encryptedToken);
	}
}
