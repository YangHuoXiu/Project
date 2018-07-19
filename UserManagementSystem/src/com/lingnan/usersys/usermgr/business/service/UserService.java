package com.lingnan.usersys.usermgr.business.service;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * service接口
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO login(String name, String password);
	
	/**
	 * 注册
	 * @param user 用户信息
	 * @return 注册成功返回true，否则返回false
	 */
	public boolean register(UserVO user);
	/**
	 * 根据用户id查找
	 * 
	 * @param id 用户编号
	 * @return 用户信息
	 */
	public UserVO findUserById(int id);
	
	/**
	 * 
	 * 根据id删除用户
	 * @param id 用户编号
	 * @return 删除成功，返回true，否则返回false
	 */
	public boolean deleteUser(int id);
	
	/**
	 * 更新用户
	 * 
	 * @param user 用户信息
	 * @return 更新成功的返回true，否则返回false
	 */
	public boolean updateUser(UserVO user);
	
	/**
	 * 查找所有的用户
	 * @return 返回所有的用户信息的值
	 */
	public Vector<UserVO> findAll();
	
	/**
	 *查看有效用户
	 * @return 返回用户的所有信息
	 */
	public Vector<UserVO> findAllValid();
	
	/**
	 *更具用户名查找用户信息
	 * @param name 用户名
	 * @return 返回用户信息集合
	 */
	public Vector<UserVO> findUserByName(String name);
	
	/**
	 * 分页查询
	 * 
	 * @param pageNO 页的数量
	 * @param pageSize 每页的记录数
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findUsers(int pageNO, int pageSize);
	
	/**
	 * 查找最大的id
	 * @return 返回最大值
	 */
	public int findMaxId();
	
	/**
	 * 统计用户的数量
	 * @return 返回用户数量
	 */
	public int getRecordCount();
	
	

}
