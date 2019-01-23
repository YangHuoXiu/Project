package com.model;

import java.io.Serializable;

public class AddressInfor implements Serializable{
	private Integer aid;
	private String sentName;
	private String sentAdress;
	private String phone;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getSentName() {
		return sentName;
	}
	public void setSentName(String sentName) {
		this.sentName = sentName;
	}
	public String getSentAdress() {
		return sentAdress;
	}
	public void setSentAdress(String sentAdress) {
		this.sentAdress = sentAdress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
