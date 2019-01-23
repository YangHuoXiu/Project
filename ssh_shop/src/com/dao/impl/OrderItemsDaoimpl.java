package com.dao.impl;

import java.util.List;










import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;







import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderItemsDao;
import com.model.OrderItems;
import com.model.Product;
import com.model.ProductInfor;
import com.model.ProductOrder;
import com.utils.PageHibernateCallback;


@Transactional


public class OrderItemsDaoimpl extends HibernateDaoSupport implements OrderItemsDao{
	
	
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItems> findAll() {
		String hql="from OrderItems c left outer join fetch  c.productOrder  ";
		Query query=getSession().createQuery(hql);
		List<OrderItems> lsit=query.list();
		return lsit;
	}
 


	@Override
	public OrderItems findById(int tid) {
		String hql="from OrderItems c left outer join fetch  c.productOrder  where tid= "+tid;
		Query query=getSession().createQuery(hql);
		OrderItems orderItems=(OrderItems) query.uniqueResult();
	 return orderItems;
	}
	
	
	 public  ProductOrder findOid(Class<ProductOrder> class1, int oid){
		 return getHibernateTemplate().get(class1, oid);
	 }

	@Override
/*	public boolean delete(int tid) {
		String hql="delete from OrderItems c  where c.tid= "+tid;
		String hql1="delete from ProductOrder p  where p.oid= "+oid;
		Query query=getSession().createQuery(hql);
		Query query1=getSession().createQuery(hql1);
		boolean b = false;
		try {
			 query.executeUpdate();
			 query1.executeUpdate();
			 b=true;
		} catch (Exception e) {
			 
		}
		return b;
	}*/
	
	public void delete(OrderItems orderItems){
		
		getHibernateTemplate().delete(orderItems);
			
	}

	

	public void update(OrderItems orderItems) {

	getHibernateTemplate().update(orderItems);
	
	}
	
	public void update(ProductOrder productOrder) {

		getHibernateTemplate().update(productOrder);
		
		}
	
	
	public void sava(ProductOrder productOrder){
		getHibernateTemplate().save(productOrder);
	}
	
	public void sava (OrderItems orderItems){
		getHibernateTemplate().save(orderItems);
	}

	//***************************
	@Override
	public List<ProductOrder> findByPage(int begin, int limit) {
		String hql = "from ProductOrder p left outer join fetch p.user";
		List<ProductOrder> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<ProductOrder>(hql, null, begin, limit));
		return list;
	}
	@Override
	public int findCount() {
		String hql = "select count(*) from ProductOrder";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}
}

