package com.lingnan.usersys.common.util;

public class CheckMailUtil {
	/**
	 * 邮箱的格式判断
	 * @param str
	 * @return
	 */
	public static boolean testMail(String str)
	{
		boolean flag=false;
		//正则表达式
		String regex= "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		//判断输入的str是否符合正则表达式
		if(str.matches(regex))
		{
			flag=true;
		}
	  return flag;
		
	}

}
