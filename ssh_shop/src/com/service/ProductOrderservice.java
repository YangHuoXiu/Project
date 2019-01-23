package com.service;

import java.util.List;

import com.model.OrderItems;
import com.model.ProductOrder;

public interface ProductOrderservice {
	public void save(ProductOrder productOrder);
	
	// Dao层查询我的订单分页查询:统计个数
	/*public int findCountByUid(Integer uid);*/
	
	
	public ProductOrder findByOid(Integer oid);
	public void update(ProductOrder currOrder);
	/*public int findCount();*/
	/*public List<ProductOrder> findByPage(int begin, int limit);*/
	public List<OrderItems> findOrderItem(Integer oid);
	public List<ProductOrder> findByUid(Integer uid);
	
    public int findCountByUid(Integer uid);
	
	/*public List<ProductOrder> findPageByUid(Integer uid, int begin, int limit);
	public int findCount();
	public List<ProductOrder> findByPage(int begin, int limit);*/
	
}
