package com.zensar.bus.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zensar.bus.model.UserMODL;

public interface UserDAO extends CrudRepository<UserMODL, Integer> {

	UserMODL findByencryptedToken(String enryptedToken);
	
	@Query(value="SELECT * FROM user  WHERE encryptedToken=:encryptedToken AND active=1",nativeQuery= true)
	UserMODL findByencryptedToken1(@Param("encryptedToken") String encryptedToken);
}
