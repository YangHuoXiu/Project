package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 用于用户管理，权限分为普通用户和管理员
 * @author Administrator
 *
 */
public class NormalFrame extends IndexFrame{
	//用户对象
	UserVO user=null;
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user
	 */
	public NormalFrame(UserVO user)
	{ 
		this.user=user;
	}
	
	/**
	 * 普通用户实现的功能模块的操作界面
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
			System.out.println("查看个人信息--------------------1");
			System.out.println("修改个人信息--------------------2");
			System.out.println("退出系统-----------------------3");
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
					System.out.println("输入错误，只能输入1～3的数字");
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
				this.searchShow3();
				break;//中断switch
			case 2:
				this.updateShow();
				break;
			case 3:
				System.out.println("感谢您的使用");
				//退出当前界面
				System.exit(0);
				default://输入值是1-3之外的数字
					System.out.println("你输入的操作不正确，请重试输入");
			}
		}
	}
	
	

}
