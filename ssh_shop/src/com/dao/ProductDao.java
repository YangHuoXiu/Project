package com.dao;

import java.util.List;

import com.model.Category;
import com.model.Product;
import com.model.ProductInfor;
import com.model.User;
import com.model.UserInfor;


public interface ProductDao {
	
	public List<Product> findAllProduct(String string);
	public void delete(Object object);
	
	public  Product findByPid(Class<Product> class1, int pid);
	
	public Product findByPname(Class<Product> class1,String pname);
	public  Category findByCid(Class<Category> class1, int cid);
	
	public ProductInfor findByid(Class<ProductInfor> class1, int id);
	
	public Product findByImage(String image);
	
	public void update(Product product);
	public void update(ProductInfor productInfor);
	
	public void sava(ProductInfor productInfor);
	
	public void sava(Product product);
	
	//*******************
	public List<Product> findByPage(int begin, int limit);
	public int findCount();
	public  Product findByPid(int pid);
	public List<Product> fuzzySearch(String str);
}
