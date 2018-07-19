package com.lingnan.usersys.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lingnan.usersys.common.exception.DateException;

public class TurnDateUtil {
	/**
	 * 类型转换工具
	 * @param str 指定的字符串
	 * @return 转换后的日期
	 */
	public static Date StrToDate(String str)
	{
		Date date=null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法，将字符串解析成指定格式的日期类型
			date=sdf.parse(str);
		} catch (ParseException e) {
			//将异常封装成自定义异常
			throw new DateException("字符串转换为日期出错",e);
		}
		return date;
	}
	
	
	/**
	 * 类型转换工具
	 * @param date  指定的日期
	 * @return 转换后的字符串
	 */
	public static String dateToStr(Date date)
	{
		String str=null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
			//调用format方法，将日期解析成指定格式的字符串
			str=sdf.format(date);
		}
		catch(Exception e){
			//将异常封装成自定义异常
			throw new DateException("日期转换为字符串出错！",e);
//			e.printStackTrace();
		}
		return str;
	}

}
