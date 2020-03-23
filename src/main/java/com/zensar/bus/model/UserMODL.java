package com.zensar.bus.model;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class UserMODL {

	@Id 	
	private String userName;
	private Integer staffId;
	private String encryptedToken;
	private Integer active;
	private Date addStamp;
	private Date updateStamp;
	private Integer isApprover;
	private boolean isAdmin;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getEncryptedToken() {
		return encryptedToken;
	}
	public void setEncryptedToken(String encryptedToken) {
		this.encryptedToken = encryptedToken;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Date getAddStamp() {
		return addStamp;
	}
	public void setAddStamp(Date addStamp) {
		this.addStamp = addStamp;
	}
	public Date getUpdateStamp() {
		return updateStamp;
	}
	public void setUpdateStamp(Date updateStamp) {
		this.updateStamp = updateStamp;
	}
	public Integer getIsApprover() {
		return isApprover;
	}
	public void setIsApprover(Integer isApprover) {
		this.isApprover = isApprover;
	}	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "LoginMODL [userName=" + userName + ", staffId=" + staffId + ", encryptedToken=" + encryptedToken
				+ ", active=" + active + ", addStamp=" + addStamp + ", updateStamp=" + updateStamp + ",isApprover="
				+ isApprover + "]";
	}
}
