package com.model;

import java.io.Serializable;

public class ProductInfor implements Serializable{
	private Integer desid;
	private String desName;
	private Integer price;
	private Integer size;
	private Integer sumnum;
	private String color;
	private String image;
	private Product product;
	public Integer getDesid() {
		return desid;
	}
	public void setDesid(Integer desid) {
		this.desid = desid;
	}
	
	
	
	public String getDesName() {
		return desName;
	}
	public void setDesName(String desName) {
		this.desName = desName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getSumnum() {
		return sumnum;
	}
	public void setSumnum(Integer sumnum) {
		this.sumnum = sumnum;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	

}
