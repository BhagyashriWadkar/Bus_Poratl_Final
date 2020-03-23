package com.zensar.bus.service;
import java.sql.Timestamp;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zensar.bus.BusPortalApplication;
import com.zensar.bus.dao.UserDAO;
import com.zensar.bus.exception.NotNullException;
import com.zensar.bus.exception.UserNotfoundException;
import com.zensar.bus.model.UserMODL;

@Service
public class BusPortalLogin {
@Autowired
UserDAO userDAO;
private static final Logger LOGGER=LoggerFactory.getLogger(BusPortalApplication.class);

	public void save(UserMODL loginDetails)
	{
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); 
		String encryptedToken = encoder.encode(loginDetails.getEncryptedToken());
		loginDetails.setEncryptedToken(encryptedToken);
		userDAO.save(loginDetails);
	}
	public UserMODL update(UserMODL loginDetails)
	{
		
		if(loginDetails.getStaffId()==null ||loginDetails.getStaffId()==0 || loginDetails.getUserName()==null||loginDetails.getEncryptedToken()==null)throw new NotNullException();
		Optional<UserMODL> old=userDAO.findById(loginDetails.getStaffId());
		UserMODL entity = old.get();
		if(old.isPresent()) 
        {LOGGER.info("Updating timestamp of exist user "+loginDetails.getStaffId());
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
			String present=entity.getEncryptedToken();
			if(bCryptPasswordEncoder.matches(loginDetails.getEncryptedToken(),present))
			{
					        	
	        //	entity.setActive(true);
	        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        	entity.setUpdateStamp(timestamp);
	            entity = userDAO.save(entity);     
	            LOGGER.info("Successfully updated ");
	            return entity;
			}
			else
			{
				LOGGER.error("Password missMatched");
				return loginDetails;
			}
			
        } else {
        	LOGGER.info("saving user details of "+loginDetails.getStaffId());
        	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); 
    		String encryptedToken = encoder.encode(loginDetails.getEncryptedToken());
    		loginDetails.setEncryptedToken(encryptedToken);
        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	loginDetails.setUpdateStamp(timestamp);
        	loginDetails.setAddStamp(timestamp);
        	//loginDetails.setActive(true);
        	loginDetails.setAdmin(true);;
        	loginDetails = userDAO.save(loginDetails);
        	LOGGER.info("Login details are saved "+loginDetails);
            return loginDetails;
        }
	}
}
