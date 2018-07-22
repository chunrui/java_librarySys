package com.lingnan.usersys.usermgrsys.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.lingnan.usersys.usermgrsys.domian.BookVO;
import com.lingnan.usersys.usermgrsys.domian.ReaderVO;
import com.lingnan.usersys.usermgrsys.domian.UserVO;

/**
 * ReaderImpl类实现ReaderDao抽象类
 * @author Administrator
 *
 */
public class ReaderImpl implements ReaderDao{
	/**
	 * 数据库连接
	 */
   private Connection conn;
   /**
    * 构造方法
    * @param conn  数据库连接
    */
   public ReaderImpl(Connection conn){
	   this.conn = conn;
   } 
   
   /**
  	 * 根据id号查找读者
  	 * @param bid 读者编号
  	 * @return  返回ReaderVO对象
  	 */
   public ReaderVO findReaderByid(String bid) {
	 //声明读者变量，用于存放结果集
	   ReaderVO reader = null;
	    //声明结果集变量，用于存放数据库查询的结果
	   ResultSet rs = null;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement prestmt = null;
	   try {
		   //连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		   prestmt =conn.prepareStatement("select * from T_reader where Sid=?");
		   //调用预编译的set方法，给？赋值
		   prestmt.setString(1,bid);
		   //执行预编译语句，并把得到的结果集赋给结果集变量
		   rs = prestmt.executeQuery();
		   //处理结果集，把结果集存放在reader对象中 
		   while(rs.next()){
			   reader = new ReaderVO();
			   reader.setSid(rs.getString(1));
			   reader.setSname(rs.getString(2));
			   reader.setSage(rs.getInt(3));
			   reader.setSsex(rs.getString(4));
			   reader.setSclassid(rs.getString(5));
			   reader.setSdepartment(rs.getString(6));
			   reader.setSemail(rs.getString(7));
			   reader.setSflag(rs.getInt(8));
		   }
	} catch (Exception e) {
		// TODO: handle exception
	}
		return reader;
   }
   /**
 	 * 查找所有读者信息
 	 * @return  返回Vector
 	 */
   public Vector<ReaderVO> findAllReader() {
	   //声明读者变量，用于存放结果集
	   ReaderVO reader = null;
	    //声明结果集变量，用于存放数据库查询的结果
	   ResultSet rs = null;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement prestmt = null;
	   Vector<ReaderVO> v = new Vector<ReaderVO>();
	   try {
		   //店员连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		   prestmt =conn.prepareStatement("select * from T_reader where Sflag=1");
		   //执行预编译语句，并把得到的结果集赋给结果集变量
		   rs = prestmt.executeQuery();
		   //处理结果集，把结果集存放在reader对象中 
		   while(rs.next()){
			   reader = new ReaderVO();
			   reader.setSid(rs.getString(1));
			   reader.setSname(rs.getString(2));
			   reader.setSage(rs.getInt(3));
			   reader.setSsex(rs.getString(4));
			   reader.setSclassid(rs.getString(5));
			   reader.setSdepartment(rs.getString(6));
			   reader.setSemail(rs.getString(7));
			   reader.setSflag(rs.getInt(8));
			   v.add(reader);
		   }
	} catch (Exception e) {
		// TODO: handle exception
	}
		return v;
   } 
   
   
   
/**
 * 添加读者信息
 * @param reader 读者信息
 * @return  返回true或者false
 */
public boolean addReader(ReaderVO reader) {
	// TODO Auto-generated method stub
	return false;
}
 
/**
 * 更新读者信息
 * @param reader 读者信息
 * @return  返回true或者false
 */
public boolean updateReader(ReaderVO reader) {
	// TODO Auto-generated method stub
	return false;
}
/**
 * 删除读者信息
 * @param rid 读者编号
 * @return  返回true或者false
 */

public boolean deleteReaderByid(String rid) {
	// TODO Auto-generated method stub
	return false;
}

   

}
