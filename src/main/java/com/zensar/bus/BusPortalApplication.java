package com.zensar.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.zensar.bus.service.CancelPassService;
@SpringBootApplication
public class BusPortalApplication
{
	private static final Logger LOGGER=LoggerFactory.getLogger(BusPortalApplication.class);
	
	public static void main(String[] args) {
			
		SpringApplication.run(BusPortalApplication.class, args);
		
		 LOGGER.info("Application started");
	
	}
}
