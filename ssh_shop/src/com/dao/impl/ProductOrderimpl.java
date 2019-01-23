package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




import com.dao.ProductOrderdao;
import com.model.OrderItems;
import com.model.ProductOrder;
import com.utils.PageHibernateCallback;



public class ProductOrderimpl extends HibernateDaoSupport implements ProductOrderdao{
	
	public void save(ProductOrder productOrder){
		this.getHibernateTemplate().save(productOrder);
	}
	
	public int findCountByUid(Integer uid) {
		String hql = "select count(*) from ProductOrder as o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/*// Dao层查询我的订单分页查询:查询数据
	public List<ProductOrder> findPageByUid(Integer uid, int begin, int limit) {
		String hql = "from ProductOrder o where o.user.uid = ?";
		List<ProductOrder> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<ProductOrder>(hql, new Object[] { uid },begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}*/

	// DAO层根据订单id查询订单
	public ProductOrder findByOid(Integer oid) {
		return this.getHibernateTemplate().get(ProductOrder.class, oid);
	}

	// DAO层修改订单的方法:
	public void update(ProductOrder currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}

	// DAO中统计订单个数的方法
	/*public int findCount() {
		String hql = "select count(*) from productorder";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// DAO中分页查询订单的方法
	public List<ProductOrder> findByPage(int begin, int limit) {
		String hql = "from ProductOrder order";
		List<ProductOrder> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<ProductOrder>(hql, null, begin, limit));
		return list;
	}*/

	// DAo中根据订单id查询订单项
	public List<OrderItems> findOrderItem(Integer oid) {
		String hql = "from OrderItems oi where oi.order.oid = ?";
		List<OrderItems> list = this.getHibernateTemplate().find(hql, oid);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public List<ProductOrder> findByUid(Integer uid){
		String hql = "from ProductOrder as o where o.user.uid = ?";
		List<ProductOrder> list = this.getHibernateTemplate().find(hql, uid);
		System.out.println(list+"MICHAEL");
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
		
		
	}
	

}
