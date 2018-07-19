package com.lingnan.usersys.common.exception;

public class DateException extends DaoException{
	/**
	 * 构造函数
	 */
	public DateException()
	{
		
	}
	/**
	 *构造函数
	 * @param agr0异常的详细信息
	 */
	public DateException(String arg0)
	{
		super(arg0);
	}
	
	/**
	 * 构造函数
	 * @param e异常产生的原因
	 */
	public DateException(Throwable e)
	{
		super(e);
	}
	/**
	 * 构造函数
	 * @param arg0异常产生的详细信息
	 * @param e异常产生的原因
	 */
	public DateException(String arg0,Throwable e)
	{
		super(arg0,e);
	}

}
