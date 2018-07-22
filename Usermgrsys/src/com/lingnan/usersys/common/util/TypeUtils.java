package com.lingnan.usersys.common.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.DateException;

/**
 * 类型转化工具类
 * @author Administrator
 *  
 */
public class TypeUtils {
	/**
	 * 字符串转化为日期
	 * @param str  指定的字符串
	 * @return 转化后的日期
	 */
	public static Date strToDate(String str){
	     Date date =null;
	   //设置要格式化的日期
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         try {
        	 //调用parse函数，把字符串转化为日期
	           date = sdf.parse(str);
            } catch (ParseException e) {
            	//自定义异常类
            	throw new DateException("字符串转化为日期出错...",e);
    }
          //返回转化后的值
         return date;		
	}

	/**
	 * 日期转化为字符串
	 * @param date 指定的日期参数
	 * @return 转化后的日期
	 */
	public static String dateToStr(Date date){
	     String str =null;
	     //设置要格式化的日期
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         try {
        	 //调用format函数，把日期转化为字符串
    	       str = sdf.format(date);
             } catch (Exception e) {
            	//自定义异常类
              throw new DateException("日期转化为字符串出错...",e);
                  
             }
         //返回转化后的值
          return str;		
	    }
	/**
     * 验证邮箱
     * @param email 参数
     * @return 返回布尔值
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
        	      //邮箱正则表达式检测
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
}
