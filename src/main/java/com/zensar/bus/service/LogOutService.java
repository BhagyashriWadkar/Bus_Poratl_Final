package com.zensar.bus.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.bus.dao.LoginDAO;
import com.zensar.bus.dao.UserDAO;
import com.zensar.bus.exception.NotNullException;
import com.zensar.bus.model.UserMODL;

@Service
public class LogOutService {
	
	@Autowired
	private UserDAO userDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(CancelPassService.class);
	
	public String logOut1(String encryptedToken)
	{
		if(encryptedToken==null) throw new NotNullException();
		System.out.println("encryptedToken"+encryptedToken);
		 UserMODL loginMOdl = new UserMODL();
		 
		 //loginMOdl=loginDAO.findByencryptedToken(encryptedToken.trim());
		 try {
			 loginMOdl=userDAO.findByencryptedToken1(encryptedToken);
				 loginMOdl.setActive(0);
				 System.out.println(loginMOdl.getEncryptedToken()+" "+loginMOdl.getActive());
				 userDAO.save(loginMOdl);	
				 logger.info("Application LogOut");	
				 return "logout";
		 }
		 catch(Exception e)
		 {
				 e.printStackTrace();
				 return "Invalid User";	 
		 }	
		 
	}
}
