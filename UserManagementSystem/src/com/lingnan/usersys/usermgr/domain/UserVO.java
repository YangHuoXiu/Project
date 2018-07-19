package com.lingnan.usersys.usermgr.domain;

import java.util.Date;

/**
 * 用户信息类
 * @author Administrator
 *
 */
public class UserVO {
	private int id;             //用户编号
	private String userid;      //用户帐号
	private String name;        //用户名
	private String pass;        //用户密码
	private String mail;        //用户邮箱
	private String power;       //用户权限
	private Date birth;         //用户出生日期
	private String status;      //用户状态
	
	/**
	 * 获取用户编号
	 * @return  编号
	 */
	public int getId() {
		return id;
	}
	
	/**
	 *  将用户编号设置为id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取用户账号
	 * @return  账号
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 *  将用户账号设置为useid
	 * @param userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取用名
	 * @return  账号
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 将用户名设置为 name
	 * @param  name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取密码
	 * @return  密码
	 */
	public String getPass() {
		return pass;
	}
	
   /**
    * 将密码设置为mail
    * @param pass
    */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * 获取邮箱
	 * @return 邮箱
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 将邮箱设置为 mail
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 *获取权限
	 * @return 权限
	 */
	public String getPower() {
		return power;
	}
	/**
	 * 将权限设置为power
	 * @param power
	 */
	public void setPower(String power) {
		this.power = power;
	}
	/**
	 * 获取出生日期
	 * @return 出生日期
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 将出生日期设置为birth
	 * @param birth
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	/**
	 * 获取用户状态
	 * @return 用户状态
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * 将用户状态设置为status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
