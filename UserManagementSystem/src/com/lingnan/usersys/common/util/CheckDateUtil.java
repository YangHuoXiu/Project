package com.lingnan.usersys.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断日期格式
 * @author Administrator
 *
 */
public class CheckDateUtil {
	
	/**
	 *  日期格式判断
	 * @param str 字符串
	 * @return 日期格式输入正确的时候返回true，否则返回false
	 */
	public static boolean testDate(String str)
	{
		boolean flag=false;
		//正则表达式
		String regex= "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))"; 
		//判断输入的str是否符合正则表达式
		if(str.matches(regex))
		{
			flag=true;
		}
	  return flag;
	}
	


}
