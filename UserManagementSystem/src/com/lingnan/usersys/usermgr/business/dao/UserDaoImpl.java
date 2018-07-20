package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.util.DBUtil;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImpl implements UserDao {
	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * 
	 * @param conn
	 *            数据库连接
	 */
	public UserDaoImpl(Connection conn) {
		// 给属性赋初始化值
		this.conn = conn;
	}

	/**
	 * 用户登录
	 * 
	 * @param name 用户名
	 * @param passwd 密码
	 * @return 用户信息
	 */
	public UserVO login(String name, String password) {
		// 声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		// 声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		// 声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVO user = null;
		try {
			// 调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep = conn
					.prepareStatement("select * from T_USER where name=? and pass=? and status='1'");
			// 调用预编译对象的setXXX方法，给对于变量赋值
			prep.setString(1, name);
			prep.setString(2, password);
			// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();

			// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
			if (rs.next()) {
				// 创建一个新用户对象，赋值给用户变量对象
				user = new UserVO();
				/**
				 * 调用结果集对象的getXXX()方法。取出各个字段的值 然后在调用用户对象的setXXX()方法，给属性赋值
				 * 最后创建的对象中包含了查询结果中的所有的字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setMail(rs.getString("mail"));
				user.setPower(rs.getString("power"));
				user.setBirth(rs.getDate("birth"));
				user.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtil.closeStatement(rs, prep);
		}
		/*
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据 如果查询结果为空，该对象为空值null
		 */

		return user;
	}

	/**
	 * 根据用户名查找
	 * 
	 * @param name 用户名
	 * @return 用户信息
	 */
	public Vector<UserVO> findUserByName(String name) {
		// 声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		// 声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		// 声明用户对象变量，用于保存从结果集中提取出来的数据
		Vector<UserVO> v = new Vector<UserVO>();
		try {
			// 调用连接对象的prepareStatement方法，得到预编译对象，
			prep = conn.prepareStatement("select * from T_USER where name='"
					+ name + "'");
			// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
			while (rs.next()) {
				// 创建一个新用户对象，赋值给用户变量对象
				UserVO user = new UserVO();
				/**
				 * 调用结果集对象的getXXX()方法。取出各个字段的值 然后在调用用户对象的setXXX()方法，给属性赋值
				 * 最后创建的对象中包含了查询结果中的所有的字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setMail(rs.getString("mail"));
				user.setPower(rs.getString("power"));
				user.setBirth(rs.getDate("birth"));
				user.setStatus(rs.getString("status"));
				v.add(user);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtil.closeStatement(rs, prep);
		}

		return v;

	}

	/**
	 * 查找所有的用户
	 *
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findAll() {
		// 声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		// 声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		// 声明用户对象变量，用于保存从结果集中提取出来的数据
		Vector<UserVO> v = new Vector<UserVO>();
		try {
			// 调用连接对象的prepareStatement方法，得到预编译对象，
			prep = conn.prepareStatement("select * from T_USER");
			// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
			while (rs.next()) {
				// 创建一个新用户对象，赋值给用户变量对象
				UserVO user = new UserVO();
				/**
				 * 调用结果集对象的getXXX()方法。取出各个字段的值 然后在调用用户对象的setXXX()方法，给属性赋值
				 * 最后创建的对象中包含了查询结果中的所有的字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setMail(rs.getString("mail"));
				user.setPower(rs.getString("power"));
				user.setBirth(rs.getDate("birth"));
				user.setStatus(rs.getString("status"));
				v.add(user);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtil.closeStatement(rs, prep);
		}

		return v;
	}

	/**
	 * 查找有效的用户
	 * 
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findAllValid() {
		// 声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		// 声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		// 声明用户对象变量，用于保存从结果集中提取出来的数据
		Vector<UserVO> v = new Vector<UserVO>();
		try {
			// 调用连接对象的prepareStatement方法，得到预编译对象，
			prep = conn
					.prepareStatement("select * from T_USER where status='1'");
			// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
			while (rs.next()) {
				// 创建一个新用户对象，赋值给用户变量对象
				UserVO user = new UserVO();
				/**
				 * 调用结果集对象的getXXX()方法。取出各个字段的值 然后在调用用户对象的setXXX()方法，给属性赋值
				 * 最后创建的对象中包含了查询结果中的所有的字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setMail(rs.getString("mail"));
				user.setPower(rs.getString("power"));
				user.setBirth(rs.getDate("birth"));
				user.setStatus(rs.getString("status"));
				v.add(user);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtil.closeStatement(rs, prep);
		}

		return v;
	}
	
	/**
	 * 根据用户id查找
	 * 
	 * @param id 用户编号
	 * @return 用户信息
	 */

	public UserVO findUserById(int id) {
		// 声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		// 声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		// 声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVO user = null;
		try {
			// 调用连接对象的prepareStatement方法，得到预编译对象，
			prep = conn
					.prepareStatement("select * from T_USER where id=? and status='1'");
			prep.setInt(1, id);
			// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
			if (rs.next()) {
				// 创建一个新用户对象，赋值给用户变量对象
				user = new UserVO();
				/**
				 * 调用结果集对象的getXXX()方法。取出各个字段的值 然后在调用用户对象的setXXX()方法，给属性赋值
				 * 最后创建的对象中包含了查询结果中的所有的字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setMail(rs.getString("mail"));
				user.setPower(rs.getString("power"));
				user.setBirth(rs.getDate("birth"));
				user.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtil.closeStatement(rs, prep);
		}
		/*
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据 如果查询结果为空，该对象为空值null
		 */

		return user;
	}
	/**
	 * 分页查询
	 * 
	 * @param pageNO 页的数量
	 * @param pageSize 每页的记录数
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findUsers(int pageNO, int pageSize) {
		// 声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		// 声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		// 声明用户对象变量，用于保存从结果集中提取出来的数据
		Vector<UserVO> v = new Vector<UserVO>();
		try {
			// 调用连接对象的prepareStatement方法，得到预编译对象，
			prep = conn.prepareStatement("select * from (select t2.*,rownum rn from (select t1.* from t_user t1 order by id) t2) " +
					"where rn>? and rn<=?");
			prep.setInt(1, (pageNO-1)*pageSize);
			prep.setInt(2, pageNO*pageSize);
			// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
			while (rs.next()) {
				// 创建一个新用户对象，赋值给用户变量对象
				UserVO user = new UserVO();
				/**
				 * 调用结果集对象的getXXX()方法。取出各个字段的值 然后在调用用户对象的setXXX()方法，给属性赋值
				 * 最后创建的对象中包含了查询结果中的所有的字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setMail(rs.getString("mail"));
				user.setPower(rs.getString("power"));
				user.setBirth(rs.getDate("birth"));
				user.setStatus(rs.getString("status"));
				v.add(user);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtil.closeStatement(rs, prep);
		}

		return v;
	}
	
	/**
	 * 查找当前最大的id
	 * 
	 * @return id的最大值
	 */
	public int findMaxId(){
		// 声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		// 声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep = null;
		int max;
		try {
			// 调用连接对象的prepareStatement方法，得到预编译对象，
			prep = conn.prepareStatement("select max(id) as MaxId from T_USER");
			// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs=prep.executeQuery();
			// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
		    rs.next();
			max=rs.getInt("MaxID");
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时查询最大值出错", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtil.closeStatement(rs, prep);
		}

		return max;

	}
	/**
	 * 统计当前用户的用户数量
	 * 
	 * @return 用户数量
	 */
	public int getRecordCount(){
			// 声明结果集对象变量，用于保存数据库查询结果
			ResultSet rs = null;
			// 声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement prep = null;
			int num;
			try {
				// 调用连接对象的prepareStatement方法，得到预编译对象，
				prep = conn.prepareStatement("select count(*) as num from T_USER");
				// 调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
				rs=prep.executeQuery();
				// 如果查询结果不为空，将取出结果集中的各个字符，封装在用户对象的各个属性中
			    rs.next();
				num=rs.getInt("num");
			} catch (SQLException e) {
				System.out.println("运行sql语句时出现错误：" + e.getMessage());
				// 将异常封装成自定义异常
				throw new DaoException("登录时查询最大值出错", e);
			} finally {
				// 调用数据库工具类，关闭结果集对象和声明对象
				DBUtil.closeStatement(rs, prep);
			}

			return num;

	}
	/**
	 * 添加用户
	 * 
	 * @param user 用户信息
	 * @return 添加成功的返回true，否则返回ifalse
	 */

	public boolean register(UserVO user) {
		PreparedStatement prep = null;
		int result = -1;
		try {
			prep = conn
					.prepareStatement("insert into T_USER(id,userid,name,pass,mail,power,birth) values(?,?,?,?,?,?,?)");
			prep.setInt(1, user.getId());
			prep.setString(2, user.getUserid());
			prep.setString(3, user.getName());
			prep.setString(4, user.getPass());
			prep.setString(5, user.getMail());
			prep.setString(6, user.getPower());
			prep.setDate(7, new java.sql.Date(user.getBirth().getTime()));
			result = prep.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时添加语句出错！", e);
		} finally {
			DBUtil.closeStatement(null, prep);
		}
	}

	/**
	 * 
	 * 根据id删除用户
	 * @param id 用户编号
	 * @return 删除成功，返回true，否则返回false
	 */
	public boolean deleteUser(int id) {
		Statement stat = null;
		boolean flag = false;
		try {
			stat = conn.createStatement();
			stat.executeUpdate("delete from T_USER where id='" + id + "'");
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时删除语句出错！", e);
		} finally {
			DBUtil.closeStatement(null, stat);
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
		PreparedStatement prep = null;
		boolean flag = false;
		int id = user.getId();
		String userid = user.getUserid();
		String name = user.getName();
		String pass = user.getPass();
		String mail = user.getMail();
		String power = user.getPower();
	    //Date birth=user.getBirth();
		String status = user.getStatus();
		try {

			prep = conn.prepareStatement("update T_USER set userid=?,name=?,pass=?,mail=?,power=?,birth=?,status=?where id=?");
			prep.setString(1, user.getUserid());
			prep.setString(2,user.getName());
			prep.setString(3, user.getPass());
			prep.setString(4, user.getMail());
			prep.setString(5, user.getPower());
			prep.setDate(6,new java.sql.Date(user.getBirth().getTime()));
			prep.setString(7, user.getStatus());
			prep.setInt(8,user.getId());
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("登录时更新语句出错！", e);
		} finally {
			DBUtil.closeStatement(null, prep);
		}
		return flag;
	}	
	//功能还未可以
	public boolean deleteSelect(int[] str)
	{
		PreparedStatement prep=null;
		Connection conn=null;
		boolean flag=false;
		String sql = "delete from T_USER where id in ('"+str[0]+"'"+"'" + str[1]+ "'"+"'"+str[2]+"'"+"'"+str[3]+"'"+"'"+str[4]+"')";
		  try {
			  System.out.println(str[0]+" "+str[1]+" "+str[2]+str[3]+str[4]);
				prep=conn.prepareStatement(sql);
				System.out.println(str[0]+" "+str[1]+" "+str[2]+str[3]+str[4]);
				prep.executeUpdate();
				flag = true;
				System.out.println(flag);
			} catch (SQLException e) {
				System.out.println("运行sql语句时出现错误" + e.getMessage());
				// 将异常封装成自定义异常
				throw new DaoException("登录语句时批量删除失败！", e);
			} finally {
				DBUtil.closeStatement(null, prep);
			}
			return flag;
		
	}
}
