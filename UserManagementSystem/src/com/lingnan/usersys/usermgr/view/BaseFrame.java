package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.usermgr.domain.UserVO;

public interface BaseFrame {
	
	/**
	 *页面显示
	 */
	public void show();
	
	/**
	 * 添加用户应页面显示
	 * @param type
	 */
	public void addShow(String type);
	
	/**
	 * 查询
	 */
    public void  searchShow();
    
    /**
     * 查询
     */
    public void searchShow2();
    
    /**
     * 查询
     */
    public void searchShow3();
    
    /**
     * 查询
     */
    public void searchShow4();
    
    /**
     * 查询
     */
    public void searchShow5();
    
    /**
     * 修改
     */
    public void updateShow();
    
    /**
     * 修改
     */
	public void updateShow1();
	
	/**
	 * 删除
	 */
	public void deleteShow();
}
