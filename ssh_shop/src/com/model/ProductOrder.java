package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductOrder implements Serializable{
		private Integer oid;
		private Double total;
		private Integer state;// 1:未付款   2:订单已经付款   3:已经发货   4:订单结束
		private String username;
		private String phone;
		private String addr;
		// 用户的外键:对象
		private User user;
		// 配置订单项的集合
		private Set<OrderItems> orderItems = new HashSet<OrderItems>();
		public Integer getOid() {
			return oid;
		}
		public void setOid(Integer oid) {
			this.oid = oid;
		}
		public Double getTotal() {
			return total;
		}
		public void setTotal(Double total) {
			this.total = total;
		}
		public Integer getState() {
			return state;
		}
		public void setState(Integer state) {
			this.state = state;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Set<OrderItems> getOrderItems() {
			return orderItems;
		}
		public void setOrderItems(Set<OrderItems> orderItems) {
			this.orderItems = orderItems;
		}
		
}
		
		

