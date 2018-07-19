package com.lingnan.usersys.usermgr.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtil;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void test() {
	  Connection conn=DBUtil.getConnection();
	  UserDaoImpl us=new  UserDaoImpl(conn);
	  UserVO v=new UserVO(); 
	  v=us.login("bb", "bbb");
//	  for(UserVO sd:v)
//		System.out.println(sd.getId()+"  "+sd.getUserid()+"  "+sd.getName());
	}

}
