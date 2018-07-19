package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

public class TurnDateUtilTest {

	@Test
	public void test() {
		String str="1990-13-01";
		Date date=TurnDateUtil.StrToDate(str);
		System.out.println(date);
		
		
	}

}
