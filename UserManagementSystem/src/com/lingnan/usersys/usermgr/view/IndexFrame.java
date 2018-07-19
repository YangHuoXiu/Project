package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.CheckMailUtil;
import com.lingnan.usersys.common.util.TurnDateUtil;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 用户实现的功能操作
 * 
 * @author Administrator
 *
 */
public class IndexFrame implements BaseFrame {
	
	/**
	 * 用户操作界面
	 */
	
	//定义一个静态公共类,保存登录时的信息；
	public static UserVO user1=new UserVO();
	public void show() {
		// 声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 循环操作
		while (true) {
			// 用户登录和注册界面
			System.out.println("欢迎使用lingnan的用户管理系统");
			System.out.println("==========================");
			System.out.println("用户登录--------------------1");
			System.out.println("用户注册--------------------2");
			System.out.println("退出系统--------------------3");
			int i = -1;
			// 读取用户控制台输入，如果输入值正确，中断循环，否则提示错误信息，再重新输入
			while (true) {
				try {
					// 读取用户输入操作选项的数字，同时转换为int型
					i = Integer.parseInt(br.readLine());
					// 中断循环，进入下一步操作，i值判断
					break;
				} catch (Exception e) {
					// 出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1～3的数字");
					System.out.println("请你重新输入");
				}
			}
			/**
			 * 判断用户输入值，如果值为1，进行用户登录操作， 如果值为2，进行用户注册，如果值为3，退出系统
			 */
			switch (i) {
			case 1:
				this.loginShow();
				break;// 中断switch
			case 2:
				this.addShow("注册");
				break;
			case 3:
				System.out.println("感谢您的使用");
				// 退出当前界面
				System.exit(0);
			default:// 输入值是1-3之外的数字
				System.out.println("你输入的操作不正确，请重试输入");
			}
		}
	}
	/**
	 * 用户登录界面
	 */
	public void loginShow() {
		// 声明缓冲池处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户登录面");
		System.out.println("=====================");
		System.out.println("请输入您的用户名");
		try {
			// 以行为单位，读取输入的各个值，赋值给用户对象的各个属性
			String name = br.readLine();
			System.out.println("请输入您的密码：");
		    String password = br.readLine();
			// 调用控制器中的doLogin方法，进行用户登录操作
			UserController uc = new UserController();
			 user1 = uc.doLogin(name, password);
			// 取得用户登录的id
			// 如果返回值不为空，登录成功，显示用户信息
			if (user1 != null) {
				System.out.println("登录成功。");
				System.out.println("====================");
				// 调用主界面
				AdminFrame m = new AdminFrame(user1);
				m.loginSuccShow();
				// 退出当前界面
				System.exit(0);
			} else {
				// 登录失败，显示失败信息
				System.out.println("登录失败");

			}
		} catch (IOException e) {
			// 显示异常信息
			System.out.println(e.getMessage());
		}
	}
      
	/**
	 * 用户添加界面
	 */
	public void addShow(String type) {
		// 声明缓冲池处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户操作界面");
		System.out.println("=====================");
		try {
			UserController uc = new UserController();
			// 实例化用户对象
			UserVO user = new UserVO();
			// 读取输入的各个值，赋值给用户对象的各个属性
			user.setId(uc.doFindMaxId()+1);
			System.out.println("请输入您的账号：");
			user.setUserid(br.readLine());
			System.out.println("请输入您的姓名：");
			user.setName(br.readLine());
			System.out.println("请输入您的密码：");
			user.setPass(br.readLine());
			while (true) {
				System.out.println("请输入您的邮箱：");
				String mail = br.readLine();
				if (CheckMailUtil.testMail(mail)) {
					user.setMail(mail);
					break;
				}
			}
			user.setPower("普通用户");
			System.out.println("请输入您的出生日期(YYYY-MM-DD)：");
			user.setBirth(TurnDateUtil.StrToDate(br.readLine()));
			// 调用控制器中的doLogin方法，进行用户登录操作
			
			boolean binsert = uc.doRegister(user);
			// 如果放回值为真，插入成功，显示成功信息，否则插入失败，显示失败信息
			if (binsert) {
				if ("注册".equals(type))
					System.out.println("用户注册成功");
				else
					System.out.println("添加用户成功");
			} else {
				if ("注册".equals(type))
					System.out.println("用户注册失败");
				else
					System.out.println("添加用户失败");
			}

		} catch (DateException e) {
			// 显示异常信息
			if ("注册".equals(type))
				System.out.println("注册的时候出错了" + e.getMessage());
			else
				System.out.println("添加用户的时候出错了" + e.getMessage());

		} catch (NumberFormatException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查找所有用户界面
	 */
	public void searchShow() {
		System.out.println("用户查询界面");
		System.out.println("=====================");
		try {
			UserController uc = new UserController();
			Vector<UserVO> v = new Vector<UserVO>();
			v=uc.doFindAll();
			System.out.print("当前用户表的用户数量为：");
			System.out.println(uc.doGetRecordCount());
			System.out.println("用户信息如下");
			// 循环
			for (UserVO user : v)
				System.out.println(user.getId() + "\t" + user.getUserid()
						+ "\t" + user.getName() + "\t" + user.getPass() + "\t"
						+ "\t" + user.getMail() + "\t" + user.getPower() + "\t"
						+ user.getBirth() + "\t" + user.getStatus());
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户信息查询不到" + e.getMessage());
		}

	}

	/**
	 * 根据用户名查找用户界面
	 */
	public void searchShow2() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户查询界面");
		System.out.println("=====================");
		try {
			UserController uc = new UserController();
			Vector<UserVO> v = new Vector<UserVO>();
			System.out.println("请输入您要查找的用户名：");
			String name = br.readLine();
			v = uc.doFindUserByName(name);
			System.out.println("用户信息如下");
			// 循环
			for (UserVO user : v)
				System.out.println(user.getId() + "\t" + user.getUserid()
						+ "\t" + user.getName() + "\t" + user.getPass() + "\t"
						+ "\t" + user.getMail() + "\t" + user.getPower() + "\t"
						+ user.getBirth() + "\t" + user.getStatus());
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户信息查询不到" + e.getMessage());
		}

	}

	/**
	 * 普通用户查找个人信息界面
	 */
	public void searchShow3() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户查询界面");
		System.out.println("=====================");
		try {
			UserController uc = new UserController();
			UserVO user = new UserVO();
			user = uc.findUserById(user1.getId());
			System.out.println("用户信息如下");
			// 循环
			System.out.println(user.getId() + "\t" + user.getUserid() + "\t"
					+ user.getName() + "\t" + user.getPass() + "\t" + "\t"
					+ user.getMail() + "\t" + user.getPower() + "\t"
					+ user.getBirth() + "\t" + user.getStatus());
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户信息查询不到" + e.getMessage());
		}

	}
	
	/**
	 * 根据id查找用户界面
	 */
	public void searchShow6() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户查询界面");
		System.out.println("=====================");
		try {
			UserController uc = new UserController();
			System.out.println("请输入编号：");
			int id = Integer.parseInt(br.readLine());
			UserVO user = new UserVO();
			user = uc.findUserById(id);
			System.out.println("用户信息如下");
			// 循环
			System.out.println(user.getId() + "\t" + user.getUserid() + "\t"
					+ user.getName() + "\t" + user.getPass() + "\t" + "\t"
					+ user.getMail() + "\t" + user.getPower() + "\t"
					+ user.getBirth() + "\t" + user.getStatus());
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户信息查询不到" + e.getMessage());
		}

	}

	/**
	 * 查找所有的有效用户界面
	 */
	public void searchShow4() {
		System.out.println("用户查询界面");
		System.out.println("=====================");
		try {
			UserController uc = new UserController();
			Vector<UserVO> v = new Vector<UserVO>();
			v = uc.doFindAllValid();
			System.out.println("用户信息如下");
			// 循环
			for (UserVO user : v)
				System.out.println(user.getId() + "\t" + user.getUserid()
						+ "\t" + user.getName() + "\t" + user.getPass() + "\t"
						+ "\t" + user.getMail() + "\t" + user.getPower() + "\t"
						+ user.getBirth() + "\t" + user.getStatus());
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户信息查询不到" + e.getMessage());
		}
	}

	/**
	 * 分页查找用户界面
	 */
	public void searchShow5() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户查询界面");
		System.out.println("=====================");
		try {
			UserController uc = new UserController();
			Vector<UserVO> v = new Vector<UserVO>();
			System.out.println("请您输入页码：");
			int pageNO = Integer.parseInt(br.readLine());
			System.out.println("请您输入页码大小：");
			int pageSize = Integer.parseInt(br.readLine());
			v = uc.doFindUsers(pageNO, pageSize);
			System.out.println("用户信息如下");
			// 循环
			for (UserVO user : v)
				System.out.println(user.getId() + "\t" + user.getUserid()
						+ "\t" + user.getName() + "\t" + user.getPass() + "\t"
						+ "\t" + user.getMail() + "\t" + user.getPower() + "\t"
						+ user.getBirth() + "\t" + user.getStatus());
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户信息查询不到" + e.getMessage());
		}

	}

	/**
	 * 删除用户界面
	 */
	public void deleteShow() {
		// 声明缓冲池处理流对象，用于接收控制台输入的数据
		Scanner sc = new Scanner(System.in);
		System.out.println("用户查询界面");
		System.out.println("=====================");
		try {
			System.out.println("请输入你要删除的用户编号：");
			int id = sc.nextInt();
			UserController uc = new UserController();
			boolean flag = uc.deleteUser(id);
			// 如果返回值不为空，登录成功，显示用户信息
			if (flag) {
				System.out.println("删除用户成功！");
			} else {
				System.out.println("删除用户失败！");
			}
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户信息无法删除" + e.getMessage());
		}

	}

	/**
	 *普通用户修改个人信息界面
	 */
	public void updateShow() {
		// 声明缓冲池处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户操作界面");
		System.out.println("=====================");
		try {
			// 实例化用户对象
			UserVO user = new UserVO();
			// 读取输入的各个值，赋值给用户对象的各个属性
			user.setId(user1.getId());
			System.out.println("请输入您要修改的账号");
			user.setUserid(br.readLine());
			System.out.println("请输入您要修改的姓名：");
			user.setName(br.readLine());
			System.out.println("请输入您要修改的密码：");
			user.setPass(br.readLine());
			while (true) {
				System.out.println("请输入您要修改的邮箱：");
				String mail = br.readLine();
				if (CheckMailUtil.testMail(mail)) {
					user.setMail(mail);
					break;
				}
			}
			user.setPower("普通用户");
//			System.out.println("请输入您要修改的出生日期(YYYY-MM-DD)：");
//			user.setBirth(TurnDateUtil.StrToDate(br.readLine()));
			// 调用控制器中的doLogin方法，进行用户登录操作
			user.setStatus(user1.getStatus());
			UserController uc = new UserController();
			boolean binsert = uc.doUpdate(user);
			// 如果放回值为真，插入成功，显示成功信息，否则插入失败，显示失败信息
			if (binsert) {
				System.out.println("修改个人信息成功");
			} else {
				System.out.println("修改个人修改失败");
			}

		} catch (DateException e) {
			// 显示异常信息
			System.out.println("个人信息修改的时候的时候出错了" + e.getMessage());
		} catch (NumberFormatException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *根据id修改用户信息界面
	 */
	public void updateShow1() {
		// 声明缓冲池处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户操作界面");
		System.out.println("=====================");
		try {
			// 实例化用户对象
			UserVO user = new UserVO();
			// 读取输入的各个值，赋值给用户对象的各个属性
			System.out.println("请输入你要修改的用户的编号");
			int id = Integer.parseInt(br.readLine());
			UserController uc = new UserController();
			user = uc.findUserById(id);
			// 如果返回值不为空，登录成功，显示用户信息
			if (user != null) {
				System.out.println("用户信息如下");
				System.out.println(user.getId() + "   " + user.getUserid()
						+ "   " + user.getName() + "   " + user.getPass()
						+ "   " + "    " + user.getMail() + "   "
						+ user.getPower() + "  " + user.getBirth() + "   "
						+ user.getStatus());
			}
			user.setId(user.getId());
			System.out.println("请输入您要修改的账号");
			user.setUserid(br.readLine());
			System.out.println("请输入您要修改的姓名：");
			user.setName(br.readLine());
			System.out.println("请输入您要修改的密码：");
			user.setPass(user.getPass());
			user.setMail(user.getMail());
			user.setPower(user.getPower());
			//user.setBirth(user.getBirth());
			user.setStatus(user.getStatus());
			// 调用控制器中的doLogin方法，进行用户登录操作
			// UserController uc = new UserController();
			boolean binsert = uc.doUpdate(user);
			// 如果放回值为真，插入成功，显示成功信息，否则插入失败，显示失败信息
			if (binsert) {
				System.out.println("用户信息信息成功");
			} else {
				System.out.println("用户信息修改失败");
			}

		} catch (DateException e) {
			// 显示异常信息
			System.out.println("用户信息修改的时候的时候出错了" + e.getMessage());

		} catch (NumberFormatException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
