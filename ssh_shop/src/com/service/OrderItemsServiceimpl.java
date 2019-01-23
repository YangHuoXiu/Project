package com.service;

import java.util.List;











import com.dao.impl.OrderItemsDaoimpl;
import com.model.OrderItems;
import com.model.Product;
import com.model.ProductInfor;
import com.model.ProductOrder;
import com.model.User;
import com.utils.PageBean;


public class OrderItemsServiceimpl implements OrderItemsService{

private OrderItemsDaoimpl orderItemsDaoimpl;
	


	public OrderItemsDaoimpl getOrderItemsDaoimpl() {
	return orderItemsDaoimpl;
}

public void setOrderItemsDaoimpl(OrderItemsDaoimpl orderItemsDaoimpl) {
	this.orderItemsDaoimpl = orderItemsDaoimpl;
}


  @Override
    public   List<OrderItems> findAll() { 
	return orderItemsDaoimpl.findAll();
}

  
  @Override
        public OrderItems findById(int tid) { 
		return orderItemsDaoimpl.findById(tid);
	}
  
  @Override
  public  ProductOrder findOid(Class<ProductOrder> class1, int oid){
	  return orderItemsDaoimpl.findOid(class1, oid);
  }
  
  
/*  @Override
       public boolean delete(int tid) { 
		return orderItemsDaoimpl.delete(tid);
	}
*/
  @Override 
  public void delete(OrderItems orderItems){
	  orderItemsDaoimpl.delete(orderItems);
	  
  }
  
  
  @Override
	public void update(OrderItems orderItems) { 
		orderItemsDaoimpl.update(orderItems);
	}
  
  @Override
  public void update(ProductOrder productOrder) { 
		orderItemsDaoimpl.update( productOrder);
	}



  @Override
  public void sava(ProductOrder productOrder){
	  orderItemsDaoimpl.sava(productOrder);
	}
	
	public void sava(OrderItems orderItems){
		orderItemsDaoimpl.sava(orderItems);
	}

	// ***********************
	// *******************************begin
	// 业务层用户查询所有
	public PageBean<ProductOrder> findByPage(Integer page) {
		PageBean<ProductOrder> pageBean = new PageBean<ProductOrder>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = orderItemsDaoimpl.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1) * limit;
		List<ProductOrder> list = orderItemsDaoimpl.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}


}
