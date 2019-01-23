package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Product implements Serializable{
   private Integer pid;
   private String pname;
   private Category category;
   private ProductInfor productInfor;
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}

public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public ProductInfor getProductInfor() {
	return productInfor;
}
public void setProductInfor(ProductInfor productInfor) {
	this.productInfor = productInfor;
}




   

}
