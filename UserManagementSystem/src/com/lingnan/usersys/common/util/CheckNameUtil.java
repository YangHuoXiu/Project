package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class CheckNameUtil {
	/**
	 * 判断是否存在该用户名
	 * @param name 用户名
	 * @return 存在该用户名返回true，否则返回false
	 */
	public static boolean checkNameTest(String name){
		 Connection conn=null;
		// 声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		// 声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		try {
			conn=DBUtil.getConnection();
			// 调用连接对象的prepareStatement方法，得到预编译对象，
			prep = conn.prepareStatement("select * from T_USER where name=?");
			prep.setString(1, name);
			// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
			if (rs.next()) {
				// 创建一个新用户对象，赋值给用户变量对象
				return true;
			}
			else return false;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误：" + e.getMessage()+"flsjfls");
			// 将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtil.closeStatement(rs, prep);
		}
		/*
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据 如果查询结果为空，该对象为空值null
		 */
	}

}
