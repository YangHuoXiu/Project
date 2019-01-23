package com.lingnan.usersys.common.exception;

public class ServiceException extends RuntimeException{
	/**
	 * 构造函数
	 */
	public ServiceException()
	{
		
	}
	/**
	 * 构造函数
	 * @param arg0   异常的详细信息
	 */
	public ServiceException(String arg0)
	{
		super(arg0);
	}
	/**
	 * 构造函数
	 * @param e 异常产生的原因
	 */
	 public ServiceException(Throwable e)
	 {
		 super(e);
	 }
	 /**
	  * 构造函数
	  * @param arg0     异常的详细信息
	  * @param e    异常的产生原因
	  */
	 public ServiceException(String arg0,Throwable e)
	 {
		 super(arg0,e);
	 }
	 

}
