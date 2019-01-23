package com.service;

import java.util.List;

import com.dao.impl.ProductOrderimpl;
import com.model.OrderItems;
import com.model.ProductOrder;
import com.utils.PageBean;

public class ProductOrderserviceimpl implements ProductOrderservice {
	
	private ProductOrderimpl productOrderimpl;

	 public ProductOrderimpl getProductOrderimpl() {
		return productOrderimpl;
	}


	public void setProductOrderimpl(ProductOrderimpl productOrderimpl) {
		this.productOrderimpl = productOrderimpl;
	}


	@Override
	public void save(ProductOrder productOrder) {
		productOrderimpl.save(productOrder);
		
	}

	/*// 业务层根据用户id查询订单,带分页查询.
		public PageBean<ProductOrder> findByUid(Integer uid,Integer page) {
			PageBean<ProductOrder> pageBean = new PageBean<ProductOrder>();
			// 设置当前页数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			// 显示5个
			int limit = 5;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = 0;
			totalCount = productOrderimpl.findCountByUid(uid);
			pageBean.setTotalCount(totalCount);
			// 设置总页数
			int totalPage = 0;
			if(totalCount % limit == 0){
				totalPage = totalCount / limit;
			}else{
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// 设置每页显示数据集合:
			int begin = (page - 1)*limit;
			List<ProductOrder> list =productOrderimpl.findPageByUid(uid,begin,limit);
			pageBean.setList(list);
			return pageBean;
		}*/

		// 根据订单id查询订单
		public ProductOrder findByOid(Integer oid) {
			return productOrderimpl.findByOid(oid);
		}

		// 业务层修改订单的方法:
		public void update(ProductOrder currOrder) {
			productOrderimpl.update(currOrder);
		}

		/*// 业务层查询所有订单方法
		public PageBean<ProductOrder> findAll(Integer page) {
			PageBean<ProductOrder> pageBean = new PageBean<ProductOrder>();
			// 设置参数
			pageBean.setPage(page);
			// 设置每页显示的记录数:
			int limit = 10;
			pageBean.setLimit(limit);
			// 设置总记录数
			int totalCount =productOrderimpl.findCount();
			pageBean.setTotalCount(totalCount);
			// 设置总页数
			int totalPage = 0;
			if(totalCount % limit == 0){
				totalPage = totalCount / limit;
			}else{
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// 设置每页显示数据集合
			int begin = (page - 1) * limit;
			List<ProductOrder> list =productOrderimpl.findByPage(begin,limit);
			pageBean.setList(list);
			return pageBean;
		}*/

		// 业务层查询订单项的方法
		public List<OrderItems> findOrderItem(Integer oid) {
			return productOrderimpl.findOrderItem(oid);
		}


		@Override
		public int findCountByUid(Integer uid) {
			return productOrderimpl.findCountByUid(uid);
		}
		public List<ProductOrder> findByUid(Integer uid){
			return productOrderimpl.findByUid(uid);
		}

		/*@Override
		public List<ProductOrder> findPageByUid(Integer uid, int begin,
				int limit) {
			
			return productOrderimpl.findPageByUid(uid, begin, limit);
		}


		@Override
		public int findCount() {
			return productOrderimpl.findCount();
		}


		@Override
		public List<ProductOrder> findByPage(int begin, int limit) {
			return productOrderimpl.findByPage(begin, limit);
		}*/





		


		


		
	



}
