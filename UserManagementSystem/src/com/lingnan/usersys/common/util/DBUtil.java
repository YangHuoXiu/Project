package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lingnan.usersys.common.exception.DaoException;

/**
 *数据库工具类
 * 
 * @author Administrator
 *
 */
public class DBUtil {
	/**
	 * 获取数据库连接
	 * 
	 * @return conn
	 */
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "123456";
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			//获取数据库连接对象
			conn =DriverManager.getConnection(url, user,password);
		} 
		catch (ClassNotFoundException e) {
			//将异常封装成自定义异常
			throw new DaoException("加载驱动失败！");
//			e.printStackTrace();
			
		} 
		catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("获取数据库连接失败！");

//			e.printStackTrace();
			
		}
		// 返回得到的连接对象
		return conn;
	}

	/**
	 * 
	 * 开始事务
	 * 
	 * @param conn 连接
	 */
	public static void beginTransaction(Connection conn) {
		try {
			// 将事务的自动提交设置为假
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			//将异常封装成自定义异常
			throw  new DaoException("开始事务出错",e);
			//e.printStackTrace();
		}
	}

	/**
	 * 提交事务
	 * @param conn 连接
	 */
	public static void commit(Connection conn) {
		try {
			//提交事务
			conn.commit();
			//将事务的自动提交设置为假
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			throw new DaoException("提交事务失败",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 回滚事务
	 * @param conn 连接
	 */
	public static void rollback(Connection conn)
	{
		try {
			//回滚事务
			conn.rollback();
			//将事务的自动提交设置为假
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("回滚事务失败",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接
	 * @param conn  连接
	 */
	public static void closeConncetion(Connection conn)
	{
		try {
			//如果数据库连接对象不为空，关闭该对象
		if(conn!=null)
		{
			conn.close();
			} 
		}
		  catch (SQLException e) {
			//将异常封装成自定义异常
			  throw new DaoException("关闭连接失败！",e);
				//e.printStackTrace();
		  }
	}
	/**
	 * 关闭resultset,statement
	 * @param rs  结果集
	 * @param stat 处理数据库
	 */
	public static void closeStatement(ResultSet rs,Statement stat)
	{
		try {
			//如果查询结果集对象不为空，关闭该对象
		if(rs!=null)
		{
			rs.close();
		}
		if(stat!=null)
		{
			//如果声明对象不为空，关闭该对象
			stat.close();
		}
		}
		catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("关闭对象失败",e);
			//e.printStackTrace();
	  }
	}

}
