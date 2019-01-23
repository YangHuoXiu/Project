package com.model;

import java.io.Serializable;

public class OrderItems implements Serializable{
		private Integer tid;
		private Integer count;
		private Double subtotal;
		private Product product;
		private ProductOrder productOrder;
		
		public Integer getTid() {
			return tid;
		}
		public void setTid(Integer tid) {
			this.tid = tid;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public Double getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(Double subtotal) {
			this.subtotal = subtotal;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public ProductOrder getProductOrder() {
			return productOrder;
		}
		public void setProductOrder(ProductOrder productOrder) {
			this.productOrder = productOrder;
		}
		
			
	}


