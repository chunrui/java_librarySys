package com.lingnan.usersys.usermgrsys.business.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.BookFactory;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.business.dao.BookDao;
import com.lingnan.usersys.usermgrsys.business.dao.UserDao;
import com.lingnan.usersys.usermgrsys.domian.BookVO;
/**
 * 图书实现类
 * @author Administrator
 *
 */
public class BookServiceImpl implements  BookService{
	/**
	 * 生成一个bookservice
	 */
	private static BookService bookservice = new BookServiceImpl();
	/**
	 * 私有的构造方法
	 */
	private BookServiceImpl(){
		
	}
	/**
	 * 通过getInstance()获取UserService
	 * @return
	 */
	public static BookService getInstance()
	{
		return bookservice; 
	}

	/**
	 * 添加图书方法
	 * @param book 图书对象
	 * @return  返回true或者false
	 */
	public boolean addBook(BookVO book) {
		// TODO Auto-generated method stub
		Connection conn = null;
		//UserVO user = null;
		//声明变量，用于记录添加结果返回值
		boolean result =false;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			BookDao bookMrgDao = (BookDao) BookFactory.getBaseDao(conn, EnumType.BOOK_DAO);
			//开启事物
			DBUtils.beginTransaction(conn);
			//user.setPower(2);
			//调用dao中adduser（）方法，进行数据库插入操作，将结果集赋给result变量
			result = bookMrgDao.addBook(book);
			//提交事物
			DBUtils.commit(conn);
	}catch(Exception e){
		DBUtils.rollback(conn);
		System.out.print("添加失败！"+e.getMessage());
	}finally{
		
	}
		//返回结果
		return result;
	}

	/**
	 * 更新图书信息
	 * @param book 图书对象
	 * @return  返回true或者false
	 */
	public boolean updateBook(BookVO book) {
		// TODO Auto-generated method stub
		Connection conn = null;
		//UserVO user = null;
		//声明变量，用于记录添加结果返回值
		boolean result =false;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			BookDao userMrgDao= (BookDao) BookFactory.getBaseDao(conn, EnumType.BOOK_DAO);
			//开启事物
			DBUtils.beginTransaction(conn);
			//user.setPower(2);
			//调用dao中adduser（）方法，进行数据库插入操作，将结果集赋给result变量
			result = userMrgDao.updateBook(book);
			//提交事物
			DBUtils.commit(conn);
	}catch(Exception e){
		DBUtils.rollback(conn);
		System.out.print("修改失败！"+e.getMessage());
	}finally{
		DBUtils.closeConnection(conn);
	}
		//返回结果
		return result;
	}
	/**
	 * 根据id号查找图书
	 * @param bid 图书id号
	 * @return 返回图书对象
	 */
	public BookVO findBookByid(int bid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		BookVO book = null;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			BookDao bookMrgDao= (BookDao) BookFactory.getBaseDao(conn, EnumType.BOOK_DAO);
			book = bookMrgDao.findBookByid(bid);
		} catch (Exception e) {
			//自定义异常类
			System.out.print("图书查找失败！"+e.getMessage());
		}finally{
			//数据库关闭
			DBUtils.closeConnection(conn);
		}	
		return book;					  
	}

	
/**
 * 查找所有图书信息
 * @return 返回图书对象
 */
	public Vector<BookVO> findAllBook() {
		Connection conn = null;
		BookVO book = null;
		Vector<BookVO> v = new Vector<BookVO>();
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			BookDao bookMrgDao= (BookDao) BookFactory.getBaseDao(conn, EnumType.BOOK_DAO);
			v = bookMrgDao.findAllBook();
		} catch (DaoException e) {
			throw e;
		}catch (Exception e) {
			//自定义异常类
			throw new ServiceException("图书查找失败。。。"+e.getMessage());
		}finally{
			//数据库关闭
			DBUtils.closeConnection(conn);
		}	
		return v;	
	}

	/**
	 * 根据id好号删除图书
	 * @param  bid 图书id号
	 * @return 返回true或者false
	 */
	public boolean deleteBookByid(int bid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		//UserVO user = null;
		//声明变量，用于记录添加结果返回值
		boolean result =false;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			BookDao bookMrgDao= (BookDao) BookFactory.getBaseDao(conn, EnumType.BOOK_DAO);			//开启事物
			DBUtils.beginTransaction(conn);
			
			//调用dao中adduser（）方法，进行数据库插入操作，将结果集赋给result变量
			result = bookMrgDao.deleteBookByid(bid);
			//提交事物
			DBUtils.commit(conn);
			
	}catch(Exception e){
		DBUtils.rollback(conn);
		System.out.print("删除用户信息失败！"+e.getMessage());
	}finally{
		DBUtils.closeConnection(conn);
	}
		//返回结果
		return result;
	}
	/**
	 * 根据图书名查找图书信息
	 * @param  name 图书名
	 * @return 返回Vector<BookVO>
	 */
	public Vector<BookVO> findBookByName(String name) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		BookVO book = null;
		Vector<BookVO>  v = new Vector<BookVO>();
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			BookDao bookMrgDao= (BookDao) BookFactory.getBaseDao(conn, EnumType.BOOK_DAO);
			v = bookMrgDao.findBookByName(name);
		} catch (Exception e) {
			//自定义异常类
			System.out.print("按图书名图书查找失败！"+e.getMessage());
		}finally{
			//数据库关闭
			DBUtils.closeConnection(conn);
		}	
		return v;					  
}		       
		
	/**
	 * 分页查找图书信息
	 * @param  pageNO 页号
	 * @param  pagesize 页大小
	 * @return 返回Vector<BookVO>
	 */
	public Vector<BookVO> findBookBypage(int pageNO, int pagesize) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		BookVO book = null;
		Vector<BookVO>  v = new Vector<BookVO>();
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			BookDao bookMrgDao= (BookDao) BookFactory.getBaseDao(conn, EnumType.BOOK_DAO);
			v = bookMrgDao.findBookBypage(pageNO, pagesize);
		} catch (Exception e) {
			//自定义异常类
			System.out.print("分页查找图书失败！"+e.getMessage());
		}finally{
			//数据库关闭
			DBUtils.closeConnection(conn);
		}	
		return v;					  
}		       
}
