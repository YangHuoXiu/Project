package com.service;

import java.util.List;







import com.model.OrderItems;
import com.model.Product;
import com.model.ProductInfor;
import com.model.ProductOrder;
import com.model.User;
import com.utils.PageBean;


public interface OrderItemsService {
	
	public   List<OrderItems> findAll() ;
	public OrderItems findById(int tid);
	 public  ProductOrder findOid(Class<ProductOrder> class1, int oid);
	
	
	public void delete(OrderItems orderItems);
	
	public void update(OrderItems orderItems);

	public void update(ProductOrder productOrder);
	
	
	public void sava(ProductOrder productOrder);
	public void sava(OrderItems orderItems);

	//**************
	public PageBean<ProductOrder> findByPage(Integer page);

}
