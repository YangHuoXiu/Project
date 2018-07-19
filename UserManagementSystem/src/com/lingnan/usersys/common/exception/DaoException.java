package com.lingnan.usersys.common.exception;

/**
 * 
 * @author Administrator
 *
 */
public class DaoException extends RuntimeException{
	/**
	 * 构造函数
	 */
	public DaoException()
	{
		
	}
	/**
	 *构造函数
	 * @param arg0异常的详细信息
	 */
	public DaoException(String arg0)
	{
		super(arg0);
	}
	/**
	 * 构造函数
	 * @param e异常的原因
	 */
	public DaoException(Throwable e)
	{
		super(e);
	}
	/**
	 * 构造函数
	 * @param arg0异常的详细信息
	 * @param e异常的原因
	 */
	public DaoException(String arg0,Throwable e)
	{
		super(arg0,e);
	}

}
