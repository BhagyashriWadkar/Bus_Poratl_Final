package com.zensar.bus.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bus.model.BusMODL;

@Repository
public interface BusDAO extends CrudRepository<BusMODL, Integer>
{
	BusMODL save (BusMODL bus);
}
