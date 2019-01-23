package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.CategoryDao;
import com.model.Category;
import com.model.User;
import com.utils.PageHibernateCallback;

public class CategoryDaoimpl extends HibernateDaoSupport implements CategoryDao {
	
	public List<Category> findAllCategory(String string){
		List<Category> list =(List<Category>) getHibernateTemplate().find(string);
		System.out.println("*******************");
		return list;
	}
	
	@Override
	public List<Category> findByPage(int begin, int limit) {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Category>(hql, null, begin, limit));
		return list;
	}
	@Override
	public int findCount() {
		String hql = "select count(*) from Category";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public void update(Category category) {
		getHibernateTemplate().update(category);
	}

	@Override
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	@Override
	public void delete(Object object) {
		getHibernateTemplate().delete(object);		
	}
	
	//保存分类的方法
	@Override
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}
		
}
