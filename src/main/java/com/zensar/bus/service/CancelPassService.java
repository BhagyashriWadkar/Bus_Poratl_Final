package com.zensar.bus.service;

import java.util.logging.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.bus.dao.BusPassDAO;
import com.zensar.bus.model.BusPassMODL;
import com.zensar.bus.model.PassStatusEnum;

@Service
public class CancelPassService {
	@Autowired
	private BusPassDAO busPassDAO;
	private static final Logger logger = LoggerFactory.getLogger(CancelPassService.class);
	public String canclePass(Integer passId )
	{
		 BusPassMODL busPassMOdl = busPassDAO.findByPassId(passId); 
		 try
		 {
			 System.out.println("pass staus"+busPassMOdl.getPassStatus());
			 if(busPassMOdl.getPassStatus().equals(PassStatusEnum.Approved.toString()) || busPassMOdl.getPassStatus().equals(PassStatusEnum.Pending.toString()))
			 {
				 busPassMOdl.setPassStatus(PassStatusEnum.Cancelled.toString());
				 busPassDAO.save(busPassMOdl);
				 logger.info("Pass canceled");
				 return "Pass Canceld";
			 }
			 else
			 {
				 logger.info("Pass alredy canceled");
				 return "Pass alredy Canceld";
			 }
		 }
		 catch (Exception e) 
		 {
			 e.printStackTrace();
			 return "Incorrect Pass Id";
		 }
	}
}
