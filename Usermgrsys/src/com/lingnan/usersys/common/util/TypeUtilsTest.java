package com.lingnan.usersys.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
/**
 * 类型转化测试类
 * @author Administrator
 *
 */
public class TypeUtilsTest {

	/**
	 * 字符串转化为日期测试方法
	 */
	public void testStrToDate() {
		//fail("Not yet implemented");
		String str = "2018-10-10";
		 Date date = TypeUtils.strToDate(str);
		 System.out.print(date);
		
	}
	
	/**
	 * 日期转化字符串为测试方法
	 */
	public void testDateToStr() {
		//fail("Not yet implemented");
		//格式化字符串
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = null;
		 try {
			 //字符串转化为日期
			date = sdf.parse("2018-6-9");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //日期转化为字符串
		 String str = TypeUtils.dateToStr(date);
		 System.out.print(str);
		
	}

	/**
	 * 邮箱测试方法
	 */
	public void testCheckEmail() {
		String email = "11111@qq.com";
		boolean flag = TypeUtils.checkEmail(email);
		System.out.print(flag);
	}
}
