package com.service;

import java.util.List;

import com.dao.impl.ProductDaoimpl;
import com.model.Category;
import com.model.Product;
import com.model.ProductInfor;
import com.model.User;
import com.utils.PageBean;

public class ProductServiceimpl implements ProductService {
	private ProductDaoimpl productDaoimpl;
	
	public ProductDaoimpl getProductDaoimpl() {
		return productDaoimpl;
	}
	
	public void setProductDaoimpl(ProductDaoimpl productDaoimpl) {
		this.productDaoimpl = productDaoimpl;
	}
	
	public List<Product> findAllProduct(String string) {
		return productDaoimpl.findAllProduct(string);
	}
	
	public void delete(Object object) {
		productDaoimpl.delete(object);
	}
	
	public Product findByPid(Class<Product> class1, int pid) {
		return productDaoimpl.findByPid(class1, pid);
	}
	
	public Product findByImage(String image){
		return productDaoimpl.findByImage(image);
	}
	
	public Product findByPname(Class<Product> class1, String pname) {
		return productDaoimpl.findByPname(class1, pname);
	}
	
	public Category findByCid(Class<Category> class1, int cid) {
		return productDaoimpl.findByCid(class1, cid);
	}
	
	public ProductInfor findByid(Class<ProductInfor> class1, int id) {
		return productDaoimpl.findByid(class1, id);
	}
	
	public void update(Product product) {
		productDaoimpl.update(product);
	}
	
	public void update(ProductInfor productInfor) {
		productDaoimpl.update(productInfor);
	}
	
	public void sava(ProductInfor productInfor) {
		productDaoimpl.sava(productInfor);
	}
	
	public void sava(Product product) {
		productDaoimpl.sava(product);
	}
	
	// ***********************
	// *******************************begin
	// 业务层用户查询所有
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDaoimpl.findCount();
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
		List<Product> list = productDaoimpl.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Product findByPid(int pid) {
		System.out.println("service**********"+pid);
		return productDaoimpl.findByPid(pid);
	}

	@Override
	public List<Product> fuzzySearch(String str) {
		return productDaoimpl.fuzzySearch(str);
	}
}
