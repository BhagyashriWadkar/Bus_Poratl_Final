package com.zensar.bus.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zensar.bus.model.BusPassMODL;
import com.zensar.bus.model.UserMODL;

public interface LoginDAO extends CrudRepository<UserMODL, Integer> {
	
	
	
/*	@Modifying
	@Transactional
	@Query(value="update user set active=:status where encryptedToken=:encryptedToken",nativeQuery= true)
	int save1(@Param("status") String status,@Param("encryptedToken") String encryptedToken);	*/
}
