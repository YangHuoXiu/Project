package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.ProductDao;
import com.model.Category;
import com.model.Product;
import com.model.ProductInfor;
import com.model.User;
import com.utils.PageHibernateCallback;

public class ProductDaoimpl extends HibernateDaoSupport implements ProductDao {
	
	public List<Product> findAllProduct(String string){
		List<Product> list =(List<Product>) getHibernateTemplate().find(string);
		return  list;
	}
	
	public void delete(Object object){
		this.getHibernateTemplate().delete(object);
	}
	
	public Product findByPid(Class<Product> class1, int pid){
		return getHibernateTemplate().get(class1, pid);
	}
	
	public Product findByImage(String image){
		String hql="from Product  where Product.productInfor.image= "+image;
		Query query=getSession().createQuery(hql);
		Product product=(Product) query.uniqueResult();
	 return product;
		
	}
	
	public Product findByPname(Class<Product> class1,String pname){
		return getHibernateTemplate().get(class1, pname);
	}
	
	public  Category findByCid(Class<Category> class1, int cid){
		return getHibernateTemplate().get(class1, cid);
	}
	
	public ProductInfor findByid(Class<ProductInfor> class1, int id){
		return getHibernateTemplate().get(class1, id);
	}
	
	public void update(Product product){
		/*SessionFactory f = this.getHibernateTemplate().getSessionFactory();
		Session s=(Session) f.getCurrentSession();
		s.beginTransaction();
		String sql="update product set pname=? where pid=?";
		Query query = s.createSQLQuery(sql);
		query.setString(0,"pname");
		query.setInteger(1,	pid);
		System.out.println(pid+pname+"dlsjdflsd");
	
		*/
		this.getHibernateTemplate().update(product);
	}
	
	public void update(ProductInfor productInfor){
		getHibernateTemplate().update(productInfor);
	}
	
	public void sava(ProductInfor productInfor){
		getHibernateTemplate().save(productInfor);
	}
	
	public void sava(Product product){
		this.getHibernateTemplate().save(product);
	}
	
	//**********************
	// 后台查询所有商品的方法
	@Override
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product p left outer join fetch p.productInfor left outer join fetch p.category";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, null, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}
	// 后台统计商品个数的方法
	@Override
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public Product findByPid(int pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	@Override
	public List<Product> fuzzySearch(String str) {
		String hql = "from Product p left outer join fetch p.productInfor left outer join fetch p.category where pname like '%"+str+"%' or desName like '%"+str+"%' or cname like '%"+str+"%'";
		System.out.println(str+"***************dao1");
		List<Product> list = this.getHibernateTemplate().find(hql);
		System.out.println(str+"***************dao2");
		return list;
	}
}
