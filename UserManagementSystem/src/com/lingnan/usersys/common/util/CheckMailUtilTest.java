package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckMailUtilTest {

	@Test
	public void test() {
		String str="@qq.com";
		boolean flag=CheckMailUtil.testMail(str);
		System.out.println(flag);
		
		
	}

}
