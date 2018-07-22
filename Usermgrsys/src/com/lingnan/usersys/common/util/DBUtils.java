package com.lingnan.usersys.common.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lingnan.usersys.common.exception.DaoException;
/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DBUtils {
	/**
	 * 获取数据库连接
	 * @return 返回连接
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "scott";
			String password = "123456";
			//获取数据库连接对象
			conn = DriverManager.getConnection(url,user,password);
	} catch (SQLException e) {
         //自定义异常类
		throw new DaoException("数据库连接失败....",e);
	} catch (ClassNotFoundException e) {
        //自定义异常类
		throw new DaoException("加载驱动失败...",e);
	}
		return conn;
	}
	
	/**
	 * 数据库关闭
	 * @param conn 返回连接
	 */
	public static void closeConnection(Connection conn){
		try {
			if(conn!=null)
			{
				conn.close();
				conn =null;
			}
		} catch (SQLException e) {
			//自定义异常类
			throw new DaoException("关闭连接对象失败...",e);
		}
	}
	
	
	/**
	 * 关闭statement
	 * @param rs  结果集参数 
	 * @param stmt  参数
	 */
	public  static void closeStatement(ResultSet rs,Statement stmt){
		try {
			
			if(rs != null)
			{
				rs.close();
				rs = null;
			}
			if(stmt != null)
			{
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			//自定义封装异常类
			throw new DaoException("关闭声明对象失败...",e);
		}
	}
	
	/**
	 * 事物回滚
	 * @param conn 连接参数
	 */
	 public static void rollback(Connection conn){
		 try {
			conn.rollback();
		} catch (Exception e) {
			//自定义异常类
			throw new DaoException("事物回滚失败...",e);
		}
	 }
	 
	 /**
		 * 提交事物
		 * @param conn 连接参数
		 */
  public static void commit(Connection conn){
			 try {
				conn.commit();
			} catch (SQLException e) {
				//自定义异常类
				throw new DaoException("事物提交失败...",e);
			}
		 }
  
  /**
   * 开启事物
   * @param conn 连接参数
   */
  public static void beginTransaction(Connection conn){
	  try {
		conn.setAutoCommit(false);
	} catch (SQLException e) {
		//自定义异常类
		throw new DaoException("事物开启失败...",e);
	}
  }
  
}
