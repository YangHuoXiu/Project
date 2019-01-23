package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	private Integer uid;
	private String username;
	private String  password;
	private Set<ProductOrder> productorder=new HashSet<ProductOrder>();
	private  UserInfor userInfor;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<ProductOrder> getProductorder() {
		return productorder;
	}
	public void setProductorder(Set<ProductOrder> productorder) {
		this.productorder = productorder;
	}
	public UserInfor getUserInfor() {
		return userInfor;
	}
	public void setUserInfor(UserInfor userInfor) {
		this.userInfor = userInfor;
	}
	
	
	
	
	
	
	

}
