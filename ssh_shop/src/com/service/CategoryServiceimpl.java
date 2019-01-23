package com.service;

import java.util.List;

import com.dao.impl.CategoryDaoimpl;
import com.model.Category;
import com.utils.PageBean;

public class CategoryServiceimpl implements CategoryService {
	private CategoryDaoimpl categoryDaoimpl;

	public CategoryDaoimpl getCategoryDaoimpl() {
		return categoryDaoimpl;
	}

	public void setCategoryDaoimpl(CategoryDaoimpl categoryDaoimpl) {
		this.categoryDaoimpl = categoryDaoimpl;
	}

	public List<Category> findAllCategory(String string) {
		return categoryDaoimpl.findAllCategory(string);
	}
	
	// *******************************begin
	// 业务层用户查询所有
	public PageBean<Category> findByPage(Integer page) {
		PageBean<Category> pageBean = new PageBean<Category>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = categoryDaoimpl.findCount();
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
		List<Category> list = categoryDaoimpl.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void update(Category category) {
		categoryDaoimpl.update(category);		
	}

	@Override
	public Category findByCid(Integer cid) {
		return categoryDaoimpl.findByCid(cid);
	}
	
	@Override
	public void delete(Object object) {
		categoryDaoimpl.delete(object);
	}
	
	@Override
	public void save(Category category) {
		categoryDaoimpl.save(category);
	}
	
}
