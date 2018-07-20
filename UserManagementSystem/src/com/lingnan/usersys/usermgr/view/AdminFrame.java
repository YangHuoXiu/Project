package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 用于用户管理，权限分为普通用户和管理员
 * @author Administrator
 *
 */
public class AdminFrame extends NormalFrame{
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user
	 */
	public AdminFrame(UserVO user)
	{
		super(user);
	}
	public void loginSuccShow()
	{
		System.out.println("欢迎登录主窗体");
		System.out.println(user.getName()+"您好：" + "      您的权限是： " +user.getPower());
		System.out.println("===================");
		//管理员
		if(user.getPower().equals("管理员")){
			this.show();
			}else{
				new NormalFrame(user).show();
			}
		}
	
	/**
	 * 管理员实现查找功能操作界面
	 */
	public void FindShow() {
		// 声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 循环操作
		while (true) {
			// 用户登录和注册界面
			System.out.println("用户操作界面");
			System.out.println("==========================");
			System.out.println("查看个人信息-----------------------1");
			System.out.println("查看所有用户信息--------------------2");
			System.out.println("所有的有效用户----------------------3");
			System.out.println("分页查找用户信息---------------------4");
			System.out.println("根据id查找用户信息-------------------5");
			System.out.println("根据用户名查找用户信息-----------------6");
			System.out.println("放回主界面--------------------------7");

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
					System.out.println("输入错误，只能输入1～5的数字");
					System.out.println("请你重新输入");
				}
			}
			/**
			 * 判断用户输入值，如果值为1，进行用户登录操作， 如果值为2，进行用户注册，如果值为3，退出系统
			 */
			switch (i) {
			case 1:
				this.searchShow3();
				break;// 中断switch
			case 2:
				   this.searchShow();
				   break;
			case 3:
				this.searchShow4();
				break;
			case 4:
				this.searchShow5();
				break;
			case 5:
				this.searchShow6();
				break;
			case 6:
				this.searchShow2();
				break;
			case 7:
				this.show();
				// 退出当前界面
				break;
			default:// 输入值是1-5之外的数字
				System.out.println("你输入的操作不正确，请重试输入");
			}
		}
	}
	
	/**
	 * 管理员实现的各个功能模块操作界面
	 */
	public void show()
	{
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
	    //循环操作
		while(true)
		{
			//用户登录和注册界面
			System.out.println("欢迎使用lingnan的用户管理系统");
			System.out.println("==========================");
			System.out.println("查看用户信息--------------------1");
			System.out.println("添加用户信息--------------------2");
			System.out.println("修改用户信息--------------------3");
			System.out.println("删除用户信息--------------------4");
			//System.out.println("批量删除删除用户信息--------------5");
			System.out.println("退出系统----------------------- 5");
			
			int i=-1;
			//读取用户控制台输入，如果输入值正确，中断循环，否则提示错误信息，再重新输入
			while(true){
				try{
					//读取用户输入操作选项的数字，同时转换为int型
					i=Integer.parseInt(br.readLine());
					//中断循环，进入下一步操作，i值判断
					break;
				}
				catch(Exception e)
				{
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1～5的数字");
					System.out.println("请你重新输入");
				}
			}
			/**
			 * 判断用户输入值，如果值为1，进行用户登录操作，
			 * 如果值为2，进行用户注册，如果值为3，退出系统
			 */
			switch(i)
			{
			case 1:
				this.FindShow();
				break;//中断switch
			case 2:
				this.addShow("添加用户");
				break;
			case 3:
				this.updateShow1();
				break;
			case 4:
				this.deleteShow();
				break;
//			case 5:
//				this.deleteSelectShow();
//				break;
			case 5:
				System.out.println("感谢您的使用");
				//退出当前界面
				System.exit(0);
				default://输入值是1-5之外的数字
					System.out.println("你输入的操作不正确，请重试输入");
			}
		}
	}
	



}
	

