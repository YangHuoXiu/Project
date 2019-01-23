package com.lingnan.usersys.usermgr.business.dao;

import java.util.Date;
import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * dao接口
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao{
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 用户密码
	 * @return 返回用户信息
	 */
	public UserVO login(String name, String password);
	
	/**
	 * 用户注册
	 * @param user 用户信息
	 * @return 注册成功返回ture，否则返回false
	 */
	public boolean register(UserVO user);
	
	/**
	 * 查看用户个人信息
	 * @param id  用户编号
	 * @return 返回用户信息
	 */
	public UserVO findUserById(int id);
	/**
	 * 查找所有的用户
	 * @return 返回用户信息的集合
	 */
	public Vector<UserVO> findAll();
	
	/**
	 * 更加用户名查找用户
	 * @param name 用户名
	 * @return 返回用户信息集合
	 */
	public Vector<UserVO> findUserByName(String name);
	/**
	 * 删除用户
	 * @param id 用户编号
	 * @return 返回值为true或者false
	 */
	
	public boolean deleteUser(int id);
	/**
	 * 更新用户
	 * @param user  用户信息
	 * @return 返回值为true or false
	 */
	public boolean updateUser(UserVO user);
	
	/**
	 * 查找有效用户
	 * @return 返回用户信息集合
	 */
	public Vector<UserVO> findAllValid();
	
	/**
	 * 分页查找
	 * @param pageNO  页数
	 * @param pageSize 每页记录的数量
	 * @return  返回用户信息集合
	 */
	public Vector<UserVO> findUsers(int pageNO,int pageSize);
	 
	/**
	 * 查找当前id的最大值
	 * @return 返回最大值
	 */
	public int findMaxId();
	
	/**
	 * 统计当前用户表用户的数量
	 * @return 返回用户数量
	 */
	public int getRecordCount();
	
	/**
	 * 批量删除用户
	 * @param str 数组
	 * @return 批量删除成功返回true 否者返回false
	 */
	public boolean deleteSelect(int[] str);
	


}
