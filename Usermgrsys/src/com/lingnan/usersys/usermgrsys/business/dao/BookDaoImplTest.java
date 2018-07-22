package com.lingnan.usersys.usermgrsys.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.business.service.BookService;
import com.lingnan.usersys.usermgrsys.business.service.BookServiceImpl;
import com.lingnan.usersys.usermgrsys.domian.BookVO;
/**
 * 根据图书id号查询测试类
 * @author Administrator
 *
 */
public class BookDaoImplTest {

	/**
	 * 根据图书id号查询测试方法
	 */
	public void testFindBookByid() {
		int bid = 1;
		//连接数据库方法
		Connection conn = DBUtils.getConnection();
		BookDao a = new BookDaoImpl(conn);
		BookVO book = null;
		//调用图书查询方法
		book = a.findBookByid(bid);
		book.getBid();
		System.out.print(book.getBid());
	}

}
