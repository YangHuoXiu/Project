package com.dao.impl;

import java.util.List;
import java.util.Vector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.UserDao;
import com.model.OrderItems;
import com.model.User;
import com.model.UserInfor;
import com.utils.PageBean;
import com.utils.PageHibernateCallback;

public class UserDaoimpl extends HibernateDaoSupport implements UserDao {
	
	@Override
	public List<User> findAllUser(String string) {
		
		List<User> list = (List<User>) getHibernateTemplate().find(string);
		return list;
	}
	
	@Override
	public List<OrderItems> findAllOrderItems(String string) {
		List<OrderItems> list = (List<OrderItems>) getHibernateTemplate().find(string);
		return list;
		
	}
	
	@Override
	public void delete(Object object) {
		getHibernateTemplate().delete(object);
		
	}
	
	@Override
	// 根据uid来查找
	public User findById(Class<User> class1, int uid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(class1, uid);
	}
	
	/*
	 * public void update(User user) { getHibernateTemplate().update(user);
	 * }
	 */
	@Override
	public void update(UserInfor userInfor) {
		getHibernateTemplate().update(userInfor);
	}
	
	// 普通用户登录****************************begin
	@Override
//	public int UserLogin(String username, String password) {
//		String hql = "from User where username=? and password=?";
//		List<User> list = this.getHibernateTemplate().find(hql, username,password);
//		if (list != null && list.size() > 0) {
//			return 1;
//		} else
//			return 0;
//	}
	public User UserLogin(String username, String password) {
		String hql = "from User where username=? and password=?";
		List<User> list = this.getHibernateTemplate().find(hql, username,password);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else
			return null;
	}
	//end
	
	// 管理员登录****************************begin
	@Override
	public User AdminLogin(String username, String password) {
		String hql = "from User where username=? and password=?";
		List<User> list = this.getHibernateTemplate().find(hql, username,password);
		if (list != null && list.size() > 0) {
			System.out.println("用户名存在，但不一定是管理员*******");
			Integer uid = list.get(0).getUid();
			String hql1 = "from UserInfor where uid=? and isadmin=1";
			List<UserInfor> list1 = this.getHibernateTemplate().find(hql1, uid);
			if (list1 != null && list1.size() > 0) {
				System.out.println("该用户是管理员***********");
				return list.get(0);
			} else {
				System.out.println("该用户为普通用户***********");
				return null;
			}
		} else {
			System.out.println("该用户不存在************");
			return null;
		}
	}
	// end
	
	// 注册
	@Override
	public void register(UserInfor userInfor) {
		this.getHibernateTemplate().save(userInfor);
	}
	
	// 异步验证（用户名）****************************begin
	@Override
	public int findByUsername(String username) {
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql, username);
		if (list != null && list.size() > 0) {
			return 0;
		} else {
			return 1;
		}
	}
	// end

	//****************************begin
	@Override
	public List<User> findByPage(int begin, int limit) {
		String hql = "from User u left outer join fetch  u.userInfor";
		List<User> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<User>(hql, null, begin, limit));
		return list;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	//end

	@Override
	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}

//	@Override
//	public List<User> fuzzySearch(int begin, int limit,String str) {
//	String hql = "from User u left outer join fetch u.userInfor where username like '%"+str+"%' or address like '%"+str+"%' or phone like '%"+str+"%'";
//		List<User> list = this.getHibernateTemplate().execute(
//				new PageHibernateCallback<User>(hql, null, begin, limit));
//		System.out.println(str+"*************dao");
//		for (User user : list) {
//			System.out.println(user.getUsername()+"************dao");
//		}
//		return list;
//	}
	@Override
	public List<User> fuzzySearch(String str) {
		String hql = "from User u left outer join fetch u.userInfor where username like '%"+str+"%' or address like '%"+str+"%' or phone like '%"+str+"%'";
		System.out.println(str+"***************dao1");
		List<User> list = this.getHibernateTemplate().find(hql);
		System.out.println(str+"***************dao2");
		for (User user : list) {
			System.out.println(user.getUsername()+"************dao");
		}
		return list;
	}

	@Override
	public List<User> findAllUser() {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	//管理员批量删除用户
	@Override
	public boolean deletes(String id) {
		System.out.println(id+"**************adada");
		Integer ids = Integer.parseInt(id);
		User user = this.findByUid(ids);
		UserInfor userInfor=user.getUserInfor();
		if(user != null ){
			getHibernateTemplate().delete(userInfor);
			return true;
		}else
			return false;
	}

	
}
