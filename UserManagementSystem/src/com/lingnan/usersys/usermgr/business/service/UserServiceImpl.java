package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.util.Date;
import java.util.Vector;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtil;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.business.dao.UserDaoImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;

//利用单例模式
public class UserServiceImpl implements UserService {
	/**
	 * 用户service类实例
	 */
	private static UserService userService = new UserServiceImpl();

	/**
	 * 构造方法
	 */
	private UserServiceImpl() {

	}

	/**
	 * 取得用户service实例
	 * 
	 * @return
	 */
	public static UserService getInstance() {
		return userService;
	}

	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO login(String name, String password) {
		// 声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		UserVO user = null;
		try {
			// 调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtil.getConnection();
			// 调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao的接口变量
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			// 调用dao中的login方法。进行登录操作，结果赋值给登录结果变量
			user = userMgrDao.login(name, password);
			/*
			 * 如果不用工厂模式，之前的做法为 UserDao userMgrDao2=new UserDaoImpl(conn);
			 * user=userMgrDao2.login(name, password);
			 */
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		} catch (Exception e) {
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户登录错误！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		// 返回用户登录结果
		return user;
	}

	/**
	 * 查找所有的用户
	 * @return 返回所有的用户信息的值
	 */
	public Vector<UserVO> findAll() {
		Connection conn = null;
		 Vector<UserVO> v=new  Vector<UserVO>();
		try {
			conn = DBUtil.getConnection();
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			v= userMgrDao.findAll();
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		} catch (Exception e) {
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户查询失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return v;
	}
	
	/**
	 *查看有效用户
	 * @return 返回用户的所有信息
	 */
	public Vector<UserVO> findAllValid(){
		Connection conn = null;
		 Vector<UserVO> v=new  Vector<UserVO>();
		try {
			conn = DBUtil.getConnection();
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			v= userMgrDao.findAllValid();
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		} catch (Exception e) {
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户查询失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
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
	public Vector<UserVO> findUsers(int pageNO, int pageSize){
		Connection conn = null;
		 Vector<UserVO> v=new  Vector<UserVO>();
		try {
			conn = DBUtil.getConnection();
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			v= userMgrDao.findUsers(pageNO, pageSize);
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		} catch (Exception e) {
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户查询失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return v;
		
	}
	
	/**
	 *更具用户名查找用户信息
	 * @param name 用户名
	 * @return 返回用户信息集合
	 */
	public Vector<UserVO> findUserByName(String name){
		Connection conn = null;
		 Vector<UserVO> v=new  Vector<UserVO>();
		try {
			conn = DBUtil.getConnection();
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			v= userMgrDao.findUserByName(name);
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		} catch (Exception e) {
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户查询失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return v;
		
	}
	
	/**
	 * 注册
	 * @param user 用户信息
	 * @return 注册成功返回true，否则返回false
	 */
	
	public boolean register(UserVO user) {
		// 声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		// 声明变量，用于保存数据库插入结果
		boolean flag = false;
		try {
			// 调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtil.getConnection();
			// 调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并复制给dao接口变量
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			// 调用数据库工具类的beginTransaction方法，开始事务
			DBUtil.beginTransaction(conn);
			// 设置用户权限为普通用户
			user.setPower("普通用户");
			// 调用dao中的register方法，进行数据库的注册操作
			flag = userMgrDao.register(user);
			// 调用工具类的commit方法，提交事务
			DBUtil.commit(conn);
			// 操作过程中出现异常，调用数据库工具类的rollback方法，回滚事务
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		} catch (Exception e) {
			DBUtil.rollback(conn);
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户查询失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return flag;

	}

	/**
	 * 根据用户id查找
	 * 
	 * @param id 用户编号
	 * @return 用户信息
	 */
	
	public UserVO findUserById(int id) {
		Connection conn = null;
		UserVO user = null;
		try {
			conn = DBUtil.getConnection();
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			user = userMgrDao.findUserById(id);
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		} catch (Exception e) {
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户查询失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return user;
	}

	/**
	 * 
	 * 根据id删除用户
	 * @param id 用户编号
	 * @return 删除成功，返回true，否则返回false
	 */
	
	public boolean deleteUser(int id) {
		// 声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		// 声明变量，用于保存数据库插入结果
		boolean flag = false;
		try {
			// 调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtil.getConnection();
			// 调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并复制给dao接口变量
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			// 调用数据库工具类的beginTransaction方法，开始事务
			DBUtil.beginTransaction(conn);
			// 调用dao中的register方法，进行数据库的注册操作
			flag = userMgrDao.deleteUser(id);
			// 调用工具类的commit方法，提交事务
			DBUtil.commit(conn);
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		}
		// 操作过程中出现异常，调用数据库工具类的rollback方法，回滚事务
		catch (Exception e) {
			DBUtil.rollback(conn);
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户删除失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return flag;
	}

	/**
	 * 更新用户
	 * 
	 * @param user 用户信息
	 * @return 更新成功的返回true，否则返回false
	 */
	public boolean updateUser(UserVO user) {
		// 声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		// 声明变量，用于保存数据库插入结果
		boolean flag = false;
		try {
			// 调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtil.getConnection();
			// 调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并复制给dao接口变量
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,EnumType.USER_DAO);
			// 调用数据库工具类的beginTransaction方法，开始事务
			DBUtil.beginTransaction(conn);
			// 调用dao中的register方法，进行数据库的注册操作
			flag = userMgrDao.updateUser(user);
			// 调用工具类的commit方法，提交事务
			DBUtil.commit(conn);
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		}
		// 操作过程中出现异常，调用数据库工具类的rollback方法，回滚事务
		catch (Exception e) {
			DBUtil.rollback(conn);
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("用户更新失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return flag;
	}
	
	/**
	 * 查找最大的id
	 * @return 返回最大值
	 */
	public int findMaxId(){
		// 声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		// 声明变量，用于保存数据库插入结果
		int max;
		try {
			// 调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtil.getConnection();
			// 调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并复制给dao接口变量
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			// 调用数据库工具类的beginTransaction方法，开始事务
			DBUtil.beginTransaction(conn);
			// 调用dao中的register方法，进行数据库的注册操作
			 max=userMgrDao.findMaxId();
			// 调用工具类的commit方法，提交事务
			DBUtil.commit(conn);
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		}
		// 操作过程中出现异常，调用数据库工具类的rollback方法，回滚事务
		catch (Exception e) {
			DBUtil.rollback(conn);
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("查找最大值失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return max;

	}
	
	/**
	 * 统计用户的数量
	 * @return 返回用户数量
	 */
	public int getRecordCount(){
		// 声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		// 声明变量，用于保存数据库插入结果
		int num;
		try {
			// 调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtil.getConnection();
			// 调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并复制给dao接口变量
			UserDao userMgrDao = (UserDao) DaoFactory.getDao(conn,
					EnumType.USER_DAO);
			// 调用数据库工具类的beginTransaction方法，开始事务
			DBUtil.beginTransaction(conn);
			// 调用dao中的register方法，进行数据库的注册操作
			 num= userMgrDao.getRecordCount();
			// 调用工具类的commit方法，提交事务
			DBUtil.commit(conn);
		} catch (DaoException e) {
			// 将自定义异常并抛出
			throw e;
		}
		// 操作过程中出现异常，调用数据库工具类的rollback方法，回滚事务
		catch (Exception e) {
			DBUtil.rollback(conn);
			// 将异常封装成自定义异常并抛出
			throw new ServiceException("查找记录数量失败！", e);
		} finally {
			DBUtil.closeConncetion(conn);
		}
		return num;
	}

}
