package com.service;

import java.util.List;

import com.dao.impl.UserDaoimpl;
import com.model.OrderItems;
import com.model.User;
import com.model.UserInfor;
import com.utils.PageBean;

public class UserServiceimpl implements UserService {
	
	private UserDaoimpl userDaoimpl;
	
	public UserDaoimpl getUserDaoimpl() {
		return userDaoimpl;
	}
	
	public void setUserDaoimpl(UserDaoimpl userDaoimpl) {
		this.userDaoimpl = userDaoimpl;
	}
	
	@Override
	public List<User> findAllUser(String string) {
		// TODO Auto-generated method stub
		return userDaoimpl.findAllUser(string);
	}
	
	@Override
	public List<OrderItems> findAllOrderItems(String string){
		return userDaoimpl.findAllOrderItems(string);
	}

	@Override
	public void delete(Object object) {

		userDaoimpl.delete(object);
	}

	@Override
	public User findById(Class<User> class1, int uid) {
		// TODO Auto-generated method stub
		return userDaoimpl.findById(class1, uid);
	}

	@Override
	/*public void update(User user) {
		userDaoimpl.update(user);
		
	}*/
	public void update(UserInfor userInfor){
		userDaoimpl.update(userInfor);
	}
	
	//登录****************************begin
	@Override
//	public int UserLogin(String username, String password) {
//		// TODO Auto-generated method stub
//		return userDaoimpl.UserLogin(username, password);
//	}
	public User UserLogin(String username, String password) {
		// TODO Auto-generated method stub
		return userDaoimpl.UserLogin(username, password);
	}
	
	@Override
	public User AdminLogin(String username, String password) {
		// TODO Auto-generated method stub
		return userDaoimpl.AdminLogin(username, password);
	}
	//end
	
	@Override
	public void register(UserInfor userInfor) {
		userDaoimpl.register(userInfor);
		
	}
	
	//异步验证（用户名）****************************begin
	@Override
	public int findByUsername(String username){
		return userDaoimpl.findByUsername(username);
	}
	//end

	//*******************************begin
	// 业务层用户查询所有
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userDaoimpl.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<User> list = userDaoimpl.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public User findByUid(Integer uid) {
		return userDaoimpl.findByUid(uid);
	}

//	@Override
//	public PageBean<User> fuzzySearch(Integer page,String str) {
//		PageBean<User> pageBean = new PageBean<User>();
//		// 设置当前页数:
//		pageBean.setPage(page);
//		// 设置每页显示记录数:
//		// 显示5个
//		int limit = 5;
//		pageBean.setLimit(limit);
//		// 设置总记录数:
//		int totalCount = 0;
//		totalCount = userDaoimpl.findCount();
//		pageBean.setTotalCount(totalCount);
//		// 设置总页数
//		int totalPage = 0;
//		if(totalCount % limit == 0){
//			totalPage = totalCount / limit;
//		}else{
//			totalPage = totalCount / limit + 1;
//		}
//		pageBean.setTotalPage(totalPage);
//		// 设置每页显示数据集合:
//		int begin = (page - 1)*limit;
//		List<User> list = userDaoimpl.fuzzySearch(begin, limit, str);
//		pageBean.setList(list);
//		return pageBean;
//	}
	@Override
	public List<User> fuzzySearch(String str) {
		return userDaoimpl.fuzzySearch(str);
	}

	@Override
	public List<User> findAllUser() {
		return userDaoimpl.findAllUser();
	}

	//管理员批量删除用户
	@Override
	public boolean deletes(String id) {
		return userDaoimpl.deletes(id);
	}
	
	//end
}
