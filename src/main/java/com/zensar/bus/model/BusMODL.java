package com.zensar.bus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class BusMODL {

	@Id
	@Column(name = "busNo")
	private Integer busId;
	
	//@Column(name )
	private Integer routeId;
	private Integer capacity;
	private Integer availableSeats;
	private boolean availibilityFlag;
	private String driverName;
	private Long driverContact;
	private String monitorName;
	private Long monitorContact;

	public BusMODL(Integer routeId,Integer capacity,boolean availibilityFlag, String driverName , Integer availableSeats) {
		this.routeId = routeId;
		this.capacity= capacity;
		this.availableSeats = availableSeats;
		this.availibilityFlag = availibilityFlag;
		this.driverName = driverName;
	}
	

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public boolean isAvailibilityFlag() {
		return availibilityFlag;
	}

	public void setAvailibilityFlag(boolean availibilityFlag) {
		this.availibilityFlag = availibilityFlag;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getDriverContact() {
		return driverContact;
	}

	public void setDriverContact(Long driverContact) {
		this.driverContact = driverContact;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public Long getMonitorContact() {
		return monitorContact;
	}

	public void setMonitorContact(Long monitorContact) {
		this.monitorContact = monitorContact;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

}
