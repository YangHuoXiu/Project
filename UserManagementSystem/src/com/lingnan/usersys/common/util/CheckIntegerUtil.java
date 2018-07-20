package com.lingnan.usersys.common.util;


public class CheckIntegerUtil {
	public static boolean testInteger(String str){
		boolean flag=false;
		//正则表达式
		String regex="[0-9]+";
		//判断输入的str是否符合正则表达式
		if(str.matches(regex))
		{
			flag=true;
		}
	  return flag;	
	}
}
