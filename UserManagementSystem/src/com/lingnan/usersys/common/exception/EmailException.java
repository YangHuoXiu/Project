package com.lingnan.usersys.common.exception;

public class EmailException extends RuntimeException{
	/**
	 * 构造函数
	 */
	public EmailException()
	{
		
	}
	/**
	 * 构造函数
	 * @param arg0异常的详细信息
	 */
	public EmailException(String arg0)
	{
		super(arg0);
	}
	/**
	 * 构造函数
	 * @param e异常产生的原因
	 */
	public EmailException(Throwable e)
	{
		super(e);
	}
	
	/**
	 * 构造
	 * @param arg0  异常的详细信息
	 * @param e  异常产生的原因
	 */
	public EmailException(String arg0,Throwable e)
	{
		super(arg0,e);
	}

}
