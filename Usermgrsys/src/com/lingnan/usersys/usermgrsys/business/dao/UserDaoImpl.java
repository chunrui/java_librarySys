package com.lingnan.usersys.usermgrsys.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * UserDaoImpl类实现UserDao抽象类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	/**
	 * 数据库连接
	 */
   private Connection conn;
   /**
    * 构造方法
    * @param conn  数据库连接
    */
   public UserDaoImpl(Connection conn){
	   this.conn = conn;
   }
   /**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
   public UserVO login(String aid, String pass) {
	   //声明用户变量，用于存放结果集
	   UserVO user = null;
	    //声明结果集变量，用于存放数据库查询的结果
	   ResultSet rs = null;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement prestmt = null;
	   try {
		   //店员连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		   prestmt =conn.prepareStatement("select * from T_user where Tid=? and Tpassword=? and Tflag=1");
		   //调用预编译的set方法，给？赋值
		   prestmt.setString(1,aid);
		   prestmt.setString(2,pass);
		   //执行预编译语句，并把得到的结果集赋给结果集变量
		   rs = prestmt.executeQuery();
		   //处理结果集，把结果集存放在user对象中 
		   while(rs.next())
		   {
			   user = new UserVO();
			   user.setAid(rs.getString(1));
			   user.setAname(rs.getString(2));
			   user.setApassword(rs.getString(3));
			   user.setPower(rs.getInt(4));
			   user.setAflag(rs.getInt(5));
		   }
	} catch (Exception e) {
		// TODO: handle exception
		System.out.print("登录失败！");
	}finally{
		 DBUtils.closeStatement(rs,prestmt);  
	   }
       return user;
	}
   

   /**
  	 * 用户添加方法
  	 * @param user 用户对象
  	 * @return 返回true或者false
  	 */
   public boolean addUser(UserVO user) {
	  boolean flag = false;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement pret = null; 
	   //记录结果集的数量
	   int result = -1;
	  try {
		  DBUtils.beginTransaction(conn);
		//调用连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		  // prestmt =conn.prepareStatement("update T_user set Tid='"+aid+"',Tname='"+name+"',Tpassword='"+password+"',Tpower='"+power+"'");
		  pret =conn.prepareStatement("insert into T_user(Tid,Tname,Tpassword,Tpower)"
			+ "values(?,?,?,?)");
		  pret.setString(1, user.getAid());
		  pret.setString(2, user.getAname());
		  pret.setString(3, user.getApassword());
		  pret.setInt(4, user.getPower());
		  result = pret.executeUpdate();
		  DBUtils.commit(conn);
		  if(result>0){
			  flag = true;  
		  }else{
			  flag = false;
		  }	  
	  } catch (Exception e) {
		// TODO: handle exception
		  DBUtils.rollback(conn);
		  System.out.print("添加用户失败！");
	}finally{
		DBUtils.closeStatement(null,pret); 
	}
	   return flag;
  }
   
   /**
	 * 根据id号查找用户
	 * @param aid 用户编号
	 * @return  返回UserVO对象
	 */
   public UserVO findUserByid(String aid){
	 //声明用户变量，用于存放结果集
	   UserVO user = null;
	    //声明结果集变量，用于存放数据库查询的结果
	   ResultSet rs = null;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement prestmt = null;
	   try {
		   //店员连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		   prestmt =conn.prepareStatement("select * from T_user where Tid=? and Tflag=1");
		   //调用预编译的set方法，给？赋值
		   prestmt.setString(1,aid);
		   //执行预编译语句，并把得到的结果集赋给结果集变量
		   rs = prestmt.executeQuery();
		   //处理结果集，把结果集存放在user对象中 
		   while(rs.next()){
			   user = new UserVO();
			   user.setAid(rs.getString(1));
			   user.setAname(rs.getString(2));
			   user.setApassword(rs.getString(3));
			   user.setPower(rs.getInt(4));
			   user.setAflag(rs.getInt(5));
		   }
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
		DBUtils.closeStatement(rs,prestmt); 
	}
		return user;		
	}
   
   /**
	 * 查找所有用户信息
	 * @retuen 返回用户对象
	 *
	 */
	public Vector<UserVO> findAllUser(){
		   //声明用户变量，用于存放结果集
		   UserVO user = null;
		   //声明结果集变量，用于存放数据库查询的结果
		   ResultSet rs = null;
		   //声明预编译的声明对象变量，用于进行数据库操作的载体
		   PreparedStatement prestmt = null;
		   Vector<UserVO> v = new Vector<UserVO> ();
		   try {
			   //店员连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
			   prestmt =conn.prepareStatement("select * from T_user where Tflag=1");
			   //执行预编译语句，并把得到的结果集赋给结果集变量
			   rs = prestmt.executeQuery();
			   //处理结果集，把结果集存放在user对象中 
			   while(rs.next()){
				   user = new UserVO();
				   user.setAid(rs.getString(1));
				   user.setAname(rs.getString(2));
				   user.setApassword(rs.getString(3));
				   user.setPower(rs.getInt(4));
				   user.setAflag(rs.getInt(5));
				   v.add(user);
			   }
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DBUtils.closeStatement(rs,prestmt); 
		}
			return v;		
		}
	/**
	 * 修改用户信息
	 * @param user  用户对象
	 * @return 返回true或者false
	 */	
  public boolean updateUser(UserVO user) {
	      boolean flag = false;
		 //声明预编译的声明对象变量，用于进行数据库操作的载体
		   PreparedStatement pret = null; 
		   //记录结果集的数量
		   int result = -4;
//		   String aid= user.getAid();
//		   String name = user.getAname();
//		   String password = user.getApassword();
//		   int power = user.getPower();
		  try {
			//调用连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
			  DBUtils.beginTransaction(conn);
			 pret =conn.prepareStatement("update T_user set Tid=?,Tname=?,Tpassword=?,Tpower=? where Tid=?");
			  pret.setString(1, user.getAid());
			  pret.setString(2, user.getAname());
			  pret.setString(3, user.getApassword());
			  pret.setInt(4, user.getPower());
			  pret.setString(5, user.getAid());
			  result = pret.executeUpdate();
			  DBUtils.commit(conn);
			  System.out.print("----"+result);
			  if(result>0){
				  flag = true;
			  }else{
				  flag = false;
			  }
			  
			  	  
		  } catch (Exception e) {
			// TODO: handle exception
			  DBUtils.rollback(conn);
			  System.out.print("修改用户失败！"+e.getMessage());
		}finally{
			DBUtils.closeStatement(null,pret); 
		}
		   return flag;
		   
  }
/**
 * 删除方法
 * @param aid  用户编号
 * @return 返回true或者false
 */
 public boolean deleteUserByid(String aid) {
	boolean flag=false;
	PreparedStatement pstam=null;
	try {
		DBUtils.beginTransaction(conn);
		pstam = conn.prepareStatement("delete from T_user where Tid='"+aid+"'");
		int result = pstam.executeUpdate();
		DBUtils.commit(conn);
		if (result>0) {
			flag=true;
		}else{
			flag=false;
		}
	}catch (SQLException e) {
		DBUtils.rollback(conn);
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.print("删除用户信息失败！");
	}finally{
		DBUtils.closeStatement(null,pstam); 
	}		
	return flag;
}  
}
