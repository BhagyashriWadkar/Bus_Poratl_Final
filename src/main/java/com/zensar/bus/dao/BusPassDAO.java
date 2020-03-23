package com.zensar.bus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zensar.bus.model.BusPassMODL;

public interface BusPassDAO extends CrudRepository<BusPassMODL, Integer> 
{	
	public BusPassMODL findBypassId(Integer passId); 
	
	/*@Query(value="select * from passbooking p where p.staffId=:id and p.passStatus=1", nativeQuery= true )
	List<BusPassMODL> approvedPass(@Param("id") Integer staffId);	*/

	@Query(value="select * from passbooking p where p.staffId=(select staffId from user where encryptedToken=:id) and p.passStatus='Approved'", nativeQuery= true )
	List<BusPassMODL> approvedPass(@Param("id") String encryptedToken);
	
	
	/*@Query(value="select * from passbooking p where p.staffId=:id and p.passStatus=0", nativeQuery= true)
	List<BusPassMODL> pendingPass(@Param("id") Integer staffId );  */
	
	@Query(value="select * from passbooking p where p.staffId=(select staffId from user where encryptedToken=:id) and p.passStatus='Pending'", nativeQuery= true )
	List<BusPassMODL> pendingPass(@Param("id") String encryptedToken);
	
	@Query(value="select * from passbooking p where passId=:id ", nativeQuery= true)
	BusPassMODL findByPassId (@Param("id") Integer passId);
	
	
}
