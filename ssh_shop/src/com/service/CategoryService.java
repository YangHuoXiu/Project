package com.service;

import java.util.List;

import com.model.Category;
import com.utils.PageBean;

public interface CategoryService {
	
	public List<Category> findAllCategory(String string);
	
	public PageBean<Category> findByPage(Integer page);

	public void update(Category category);
	
	public Category findByCid(Integer cid);
	
	public void delete(Object object);
	
	public void save(Category category);
	
}
