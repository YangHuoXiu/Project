package com.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Action.UserAction;
import com.dao.UserDao;
import com.dao.impl.UserDaoimpl;
import com.model.User;
import com.service.UserServiceimpl;

public class UserTest {
	public static void main(String[] args) {
		/*User u = new User();
		u.setUid(16);*/
		String path="applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		UserServiceimpl userServiceimpl = (UserServiceimpl) context.getBean("UserServiceimpl");
		//userServiceimpl.delete(u);
	}
}
