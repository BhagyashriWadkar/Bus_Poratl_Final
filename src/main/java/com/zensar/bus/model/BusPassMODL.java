package com.zensar.bus.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passbooking")
public class BusPassMODL {

	@Id
	private Integer passId;
	private Integer staffId;
	private Integer routeId;
	private Integer pointId;
	private String passType;
	private Integer cost;
	private Date passStartDate;
	private Date passEndDate;
	private String passStatus;
	
	public Integer getPassId() {
		return passId;
	}
	public void setPassId(Integer passId) {
		this.passId = passId;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Integer getPointId() {
		return pointId;
	}
	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}
	public String getPassType() {
		return passType;
	}
	public void setPassType(String passType) {
		this.passType = passType;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Date getPassStartDate() {
		return passStartDate;
	}
	public void setPassStartDate(Date passStartDate) {
		this.passStartDate = passStartDate;
	}
	public Date getPassEndDate() {
		return passEndDate;
	}
	public void setPassEndDate(Date passEndDate) {
		this.passEndDate = passEndDate;
	}
	public String getPassStatus() {
		return passStatus;
	}
	public void setPassStatus(String passStatus) {
		this.passStatus = passStatus;
	}
	
}
