package com.dao;

import java.util.List;

import com.model.OrderItems;

import com.model.ProductOrder;






import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public interface OrderItemsDao {
	
	
	    List<OrderItems> findAll();
	    public OrderItems findById(int tid);
	    
	    public  ProductOrder findOid(Class<ProductOrder> class1, int oid);
	    /*boolean delete(int tid);*/
	    public void update(OrderItems orderItems); 

	    
	    public void update(ProductOrder productOrder);
	    
	    public void delete(OrderItems orderItems);  
	    public void sava(ProductOrder productOrder);
		public void sava(OrderItems orderItems);
		
		//***********************
		public List<ProductOrder> findByPage(int begin, int limit);
		public int findCount();
}
