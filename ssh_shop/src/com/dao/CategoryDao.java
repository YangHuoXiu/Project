package com.dao;

import java.util.List;

import com.model.Category;
import com.model.User;


public interface CategoryDao {
	
	public List<Category> findAllCategory(String string);
		
	public List<Category> findByPage(int begin, int limit);
	public int findCount();
	
	public void update(Category category);
	
	public Category findByCid(Integer cid);
	
	public void delete(Object object);
	
	public void save(Category category);
	
}
