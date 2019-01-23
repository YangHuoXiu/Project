package com.lingnan.usersys.usermgr.controller;

import java.util.Date;
import java.util.Vector;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserController {
	//声明用户service接口对象，用于业务处理
	UserService userMgrService=UserServiceImpl.getInstance();
	/**
	 *用户登录
	 * @param name 用户名
	 * @param password    用户密码
	 * @return 用户信息
	 */
	public UserVO doLogin(String name,String password)
	{
		UserVO user=null;
		try{
			//调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.login(name, password);
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("用户登陆的时候出错"+e.getMessage());
		}
		return user;
	}	
	
	/**
	 * 用户注册
	 * @param user    用户信息
	 * @return 注册成功返回true,失败返回false
	 */
	public boolean doRegister(UserVO user)
	{
		boolean flag=false;
		try{
			flag=userMgrService.register(user);
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("注册用户信息出错"+e.getMessage());
		}
		return flag;
	}
	/**
	 *用户登录
	 * @param user 用户信息
	 * @return 添加成功返回true 否则返回false
	 */
	public boolean addUser(UserVO user)
	{
		boolean flag=false;
		try{
			flag=userMgrService.register(user);
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("添加用户信息出错"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 根据用户id查找
	 * @param id 用户id
	 * @return 用户信息
	 */
	public UserVO findUserById(int id)
	{
		UserVO user=null;
		try{
			//调用用户service接口中的searchAllUser方法，进行用户查询操作
			user=userMgrService.findUserById(id);
		}
		catch(Exception e){
			//显示异常信息
			System.out.println("查询用户信息出错"+e.getMessage());
		}
		return user;
		}
	
	/**
	 * 删除用户
	 * @param id 用户编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteUser(int id)
	{
		boolean flag=false;
		try{
			flag=userMgrService.deleteUser(id);
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("删除用户信息出错"+e.getMessage());
		}
		return flag;
	}
	
	public boolean doDeleteSelect(int[] str)
	{
		boolean flag=false;
		try{
			flag=userMgrService.deleteSelect(str);
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("批量删除用户出错"+e.getMessage());
		}
		return flag;
	}
	/**
	 * 更新用户
	 * @param user 用户信息
	 * @return 更新成功返回值为true or false
	 */
	public boolean doUpdate(UserVO user)
	{
		boolean flag=false;
		try{
			flag=userMgrService.updateUser(user);
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("用户更新出错"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 查找所有的用户信息
	 * @return 用户信息集合
	 */
	public Vector<UserVO> doFindAll()
	{
		Vector<UserVO> v=new Vector<UserVO>();
		try{
			v=userMgrService.findAll();
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("查找所有用户信息出错"+e.getMessage());
		}
		return v;
	}

/**
 * 查找所有的有效用户
 * @return 用户集合
 */
	public Vector<UserVO> doFindAllValid(){
		Vector<UserVO> v=new Vector<UserVO>();
		try{
			v=userMgrService.findAllValid();
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("查找所有用户信息出错"+e.getMessage());
		}
		return v;
		
	}
	
	/**
	 * 分页查询
	 * 
	 * @param pageNO 页的数量
	 * @param pageSize 每页的记录数
	 * @return 用户信息集合
	 */
	public Vector<UserVO> doFindUsers(int pageNO, int pageSize){
			Vector<UserVO> v=new Vector<UserVO>();
			try{
				v=userMgrService.findUsers(pageNO, pageSize);
			}
			catch(Exception e)
			{
				//显示异常信息
				System.out.println("查找所有用户信息出错"+e.getMessage());
			}
			return v;
		
	}
	
	/**
	 * 根据用户名查找
	 * 
	 * @param name 用户名
	 * @return 用户信息
	 */
	
	public Vector<UserVO> doFindUserByName(String name)
	{
		Vector<UserVO> v=new Vector<UserVO>();
		try{
			v=userMgrService.findUserByName(name);
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("查找所有用户信息出错"+e.getMessage());
		}
		return v;
	}
	
	/**
	 * 查找当前最大的id
	 * 
	 * @return id的最大值
	 */
	public int doFindMaxId(){
		int max=0;
		try{
			max=userMgrService.findMaxId();
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("查找编号最大值失败"+e.getMessage());
		}
		return max;
		
	}
	/**
	 * 统计当前用户的用户数量
	 * 
	 * @return 用户数量
	 */
	public int doGetRecordCount(){
		int num=0;
		try{
			num=userMgrService.getRecordCount();
		}
		catch(Exception e)
		{
			//显示异常信息
			System.out.println("统计记录数量失败"+e.getMessage());
		}
		return num;
		
	}
	
	
	
	}


