package com.zensar.bus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bus.dao.BusPassDAO;
import com.zensar.bus.model.BusPassMODL;

@Service
public class PendingPassService {
	
	@Autowired
	private BusPassDAO busPassDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(CancelPassService.class);

	/*public List<BusPassMODL> getPendingPass(Integer staffId)
	{
		List<BusPassMODL> pass=new ArrayList<>();
		pass=busPassDAO.pendingPass(staffId);
		logger.info("Pending Pass");
		return pass;
	}*/
	
	public List<BusPassMODL> getPendingPass(String encryptedToken)
	{
		List<BusPassMODL> pass=new ArrayList<>();
		try {
		pass=busPassDAO.pendingPass(encryptedToken);
		logger.info("Pending Pass");
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return pass;
	}

}
