package com.lingnan.usersys.usermgrsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.domian.BookVO;
import com.lingnan.usersys.usermgrsys.domian.UserVO;

/**
 * BookDaoImpl类实现ookDao抽象类
 * @author Administrator
 *
 */
public class BookDaoImpl implements BookDao {
	/**
	 * 数据库连接
	 */
   private Connection conn;
   /**
    * 构造方法
    * @param conn  数据库连接
    */
   public BookDaoImpl(Connection conn){
	   this.conn = conn;
   } 
   
   /**
  	 * 根据id号查找图书
  	 * @param bid 图书编号
  	 * @return  返回BookVO对象
  	 */
   public BookVO findBookByid(int bid) {
	 //声明用户变量，用于存放结果集
	   BookVO book = null;
	    //声明结果集变量，用于存放数据库查询的结果
	   ResultSet rs = null;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement prestmt = null;
	   try {
		   //店员连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		   prestmt =conn.prepareStatement("select * from book where Bid=? and Bflag=1");
		   //调用预编译的set方法，给？赋值
		   prestmt.setInt(1,bid);
		   //执行预编译语句，并把得到的结果集赋给结果集变量
		   rs = prestmt.executeQuery();
		   //处理结果集，把结果集存放在book对象中 
		   while(rs.next()){
			   book = new BookVO();
			   book.setBid(rs.getInt(1));
			   book.setBname(rs.getString(2));
			   book.setBauthor(rs.getString(3));
			   book.setBstate(rs.getString(4));
			   book.setBflag(rs.getInt(5));
		   }
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
		DBUtils.closeStatement(rs,prestmt); 
	}
		return book;
   }
   
   

   
   /**
 	 * 查找所有图书信息
 	 * @return  返回Vector
 	 */
   public Vector<BookVO> findAllBook() {
	   //声明图书变量，用于存放结果集
	   BookVO book = null;
	    //声明结果集变量，用于存放数据库查询的结果
	   ResultSet rs = null;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement prestmt = null;
	   Vector<BookVO> v = new Vector<BookVO>();
	   try {
		   //店员连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		   prestmt =conn.prepareStatement("select * from book");
		   //执行预编译语句，并把得到的结果集赋给结果集变量
		   rs = prestmt.executeQuery();
		   //处理结果集，把结果集存放在book对象中 
		   while(rs.next()){
			   book = new BookVO();
			   book.setBid(rs.getInt(1));
			   book.setBname(rs.getString(2));
			   book.setBauthor(rs.getString(3));
			   book.setBstate(rs.getString(4));
			   book.setBflag(rs.getInt(5));
			   v.add(book);
		   }
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
		DBUtils.closeStatement(rs,prestmt); 
	}
		return v;
   } 
   
   
   /**
 	 * 添加图书
 	 * @param book 图书对象
 	 * @return  返回true或者false
 	 */
public boolean addBook(BookVO book) {
	 boolean flag = false;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement pret = null; 
	   //记录结果集的数量
	   int result = -1;
	  try {
		  DBUtils.beginTransaction(conn);
		//调用连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		  // prestmt =conn.prepareStatement("update T_user set Tid='"+aid+"',Tname='"+name+"',Tpassword='"+password+"',Tpower='"+power+"'");
		  pret =conn.prepareStatement("insert into book(Bname,Bauthor,Bstate)"
			+ "values(?,?,?)");
		  //pret.setInt(1, book.getBid());
		  pret.setString(1, book.getBname());
		  pret.setString(2, book.getBauthor());
		  pret.setString(3, book.getBstate());
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
		  System.out.print("添加图书失败！");
	}finally{
		DBUtils.closeStatement(null,pret); 
	}
	   return flag;
}
   /**
	 * 更新图书
	 * @param book 图书对象
	 * @return  返回true或者false
	 */
public boolean updateBook(BookVO book) {
	 boolean flag = false;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement pret = null; 
	   //记录结果集的数量
	   int result = -4;
	  try {
		//调用连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		  DBUtils.beginTransaction(conn);
		  pret =conn.prepareStatement("update book set Bid=?,Bname=?,Bauthor=?,Bstate=? where Bid=?");
		  pret.setInt(1, book.getBid());
		  pret.setString(2, book.getBname());
		  pret.setString(3, book.getBauthor());
		  pret.setString(4, book.getBstate());
		  pret.setInt(5, book.getBid());
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
		  System.out.print("修改图书失败！"+e.getMessage());
	}finally{
		DBUtils.closeStatement(null,pret); 
	}
	   return flag;   
}


     /**
        * 更新图书
	    * @param bid 图书id
	    * @return  返回true或者false 
      */
public boolean deleteBookByid(int bid) {
	boolean flag=false;
	PreparedStatement pstam=null;
	try {
		DBUtils.beginTransaction(conn);
		pstam = conn.prepareStatement("delete from book where Bid="+bid+"");
		int result = pstam.executeUpdate();
		DBUtils.commit(conn);
		if(result>0)
		{
		    flag=true;
		}else {
			flag=false;
		}
		
	}catch (SQLException e) {
		DBUtils.rollback(conn);
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.print("删除图书失败！"+e.getMessage());
	}finally{
		DBUtils.closeStatement(null,pstam); 
	}		
	return flag;
}

/**
 * 通过图书名模糊查询图书信息
 * @param name 图书名
 * @return  返回图书对象
 */
public Vector<BookVO> findBookByName(String name) {
	//声明用户变量，用于存放结果集
	   BookVO book = null;
	    //声明结果集变量，用于存放数据库查询的结果
	   ResultSet rs = null;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement prestmt = null;
	   Vector<BookVO>  v = new Vector<BookVO>();
	   try {
		   //调用连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		   prestmt =conn.prepareStatement
				   ("select * from book where Bname like ? and Bflag=1");
		   //调用预编译的set方法，给？赋值
		  prestmt.setString(1,"%" + name + "%");
		   //执行预编译语句，并把得到的结果集赋给结果集变量
		   rs = prestmt.executeQuery();
		   //处理结果集，把结果集存放在book对象中 
		   while(rs.next()){
			   book = new BookVO();
			   book.setBid(rs.getInt(1));
			   book.setBname(rs.getString(2));
			   book.setBauthor(rs.getString(3));
			   book.setBstate(rs.getString(4));
			   book.setBflag(rs.getInt(5));
			   v.add(book);
		   }
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
		DBUtils.closeStatement(rs,prestmt); 
	}
		return v;
}

/**
 * 分页查询图书信息
 * @param pageNo 页号
 * @param pagesize 页面大小
 * @return  返回图书对象
 */
public Vector<BookVO> findBookBypage(int pageNo,int pagesize) {
	//声明用户变量，用于存放结果集
	   BookVO book = null;
	    //声明结果集变量，用于存放数据库查询的结果
	   ResultSet rs = null;
	 //声明预编译的声明对象变量，用于进行数据库操作的载体
	   PreparedStatement prestmt = null;
	   Vector<BookVO>  v = new Vector<BookVO>();
	   try {
		   //店员连接对象的预编译方法，得到预编译的结果对象，赋值给预编译对象
		   prestmt =conn.prepareStatement
				   ("select * from (select t2.*,rownum rn from "
				   		+ "(select t1.* from book t1 order by Bid) t2) where rn>? and rn<=?");
		   //调用预编译的set方法，给？赋值
		   prestmt.setInt(1, (pageNo-1)*pagesize);
		   prestmt.setInt(2, pageNo*pagesize);
		   rs  = prestmt.executeQuery();
		   while(rs.next()){
			   book = new BookVO();
			   book.setBid(rs.getInt(1));
			   book.setBname(rs.getString(2));
			   book.setBauthor(rs.getString(3));
			   book.setBstate(rs.getString(4));
			   book.setBflag(rs.getInt(5));
			   v.add(book);
		   }
	   }
		   catch (Exception e) {
				// TODO: handle exception
			}finally{
				DBUtils.closeStatement(rs,prestmt); 
			}
	   return v;
}  

}
