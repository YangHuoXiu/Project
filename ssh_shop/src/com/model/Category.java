package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Category implements Serializable{
	private Integer cid;
	private String cname;
	private Set<Product> product=new HashSet<Product>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	

}
