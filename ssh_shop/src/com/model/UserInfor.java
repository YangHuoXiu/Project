package com.model;

import java.io.Serializable;

public class UserInfor implements Serializable{
	private Integer uinforid;
	private String address;
	private String phone;
	private Integer isadmin;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUinforid() {
		return uinforid;
	}
	public void setUinforid(Integer uinforid) {
		this.uinforid = uinforid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(Integer isadmin) {
		this.isadmin = isadmin;
	}
	
	
		

}