package com.lingnan.usersys.usermgrsys.business.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lingnan.usersys.usermgrsys.domian.BookVO;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 图书测试类
 * @author Administrator
 *
 */
public class BookServiceImplTest {

	/**
	 *  根据图书id好查找图书信息的测试方法
	 */
	public void testFindBookByid() {
		BookService bookmgrService =  BookServiceImpl.getInstance();
		int bid = 1;
		BookVO book = bookmgrService.findBookByid(bid);
		int id =book.getBid();
		System.out.print(id);
	}

}
