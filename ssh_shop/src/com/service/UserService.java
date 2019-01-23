package com.service;

import java.util.List;
import java.util.Vector;

import com.dao.UserDao;
import com.model.OrderItems;
import com.model.User;
import com.model.UserInfor;
import com.utils.PageBean;

public interface UserService {
	
	public List<User> findAllUser(String string);
	public List<OrderItems> findAllOrderItems(String string);
	public void delete(Object object);
	public User findById(Class<User> class1, int uid);
	
	/* public void update(User user); */
	public void update(UserInfor userInfor);
	
	// 登录****************************begin
//	public int UserLogin(String username, String password);
	public User UserLogin(String username, String password);
	public User AdminLogin(String username, String password);
	// end
	
	public void register(UserInfor userInfor);
	
	// 异步验证（用户名）****************************begin
	public int findByUsername(String username);
	// end
	
	//********************************begin
	public PageBean<User> findByPage(Integer page);
	public User findByUid(Integer uid);
//	public PageBean<User> fuzzySearch(Integer page,String str);
	public List<User> fuzzySearch(String str);
	public List<User> findAllUser();
	//管理员批量删除用户
	public boolean deletes(String id);
	//end
}
