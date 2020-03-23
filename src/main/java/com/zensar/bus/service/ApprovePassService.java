package com.zensar.bus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.bus.BusPortalApplication;
import com.zensar.bus.dao.BusPassDAO;
import com.zensar.bus.exception.NotNullException;
import com.zensar.bus.model.BusPassMODL;

@Service
public class ApprovePassService {
	
	@Autowired
	private BusPassDAO busPassDAO;	
/*	@Autowired
	private BusPassMODL busPassMODL;*/
	
	private static final Logger LOGGER=LoggerFactory.getLogger(BusPortalApplication.class);
	
/*	public List<BusPassMODL> getApprovePass(Integer staffId)
	{
		List<BusPassMODL> pass=new ArrayList<>();
		pass=busPassDAO.approvedPass(staffId);
		LOGGER.info("Aprroved Pass");
		return pass;
		
	} */
	
	public List<BusPassMODL> getApprovePass(String encryptedToken)
	{
		if(encryptedToken==null) throw new NotNullException();
		List<BusPassMODL> pass=new ArrayList<>();
		try {
				pass=busPassDAO.approvedPass(encryptedToken);
				LOGGER.info("Aprroved Pass");
		}
		catch (Exception e) {
			
			e.printStackTrace();			
		}
		return pass;
		
	}
}
