package com.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.OrderItems;
import com.model.User;
import com.model.UserInfor;
import com.utils.PageBean;

public interface UserDao {
	
	public List<User> findAllUser(String string);
	
	public List<OrderItems> findAllOrderItems(String string);
	
	public void delete(Object Object);
	
	public User findById(Class<User> class1, int uid);
	
	// public void update(User user);
	
	public void update(UserInfor userInfor);
	
	// 登录****************************begin
//	public int UserLogin(String username, String password);
	public User UserLogin(String username, String password);
	
	public User AdminLogin(String username, String password);
	// end
	
	public void register(UserInfor userInfor);
	
	// 异步验证，验证注册的用户名是否存在****************************begin
	public int findByUsername(String username);
	// end
	
	//********************************begin
	public List<User> findByPage(int begin, int limit);
	public User findByUid(Integer uid);
	public int findCount();
//	public List<User> fuzzySearch(int begin, int limit,String str);
	public List<User> fuzzySearch(String str);
	public List<User> findAllUser();
	//管理员批量删除用户
	public boolean deletes(String id);
	//end
	
}
