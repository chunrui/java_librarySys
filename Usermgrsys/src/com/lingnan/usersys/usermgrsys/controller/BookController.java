package com.lingnan.usersys.usermgrsys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.usermgrsys.business.service.BookService;
import com.lingnan.usersys.usermgrsys.business.service.BookServiceImpl;
import com.lingnan.usersys.usermgrsys.domian.BookVO;
import com.lingnan.usersys.usermgrsys.domian.UserVO;

/**
 * 图书控制器
 * @author Administrator
 *
 */
public class BookController {
	BookService bookmgrService = BookServiceImpl.getInstance();
	/**
	 * 根据图书id好查找图书信息
	 * @param aid 图书编号
	 * @return 返回图书对象
	 */
	public BookVO dofindBookByid(int bid){
		BookVO book =null;
		try {
		      
			book = bookmgrService.findBookByid(bid);
		} catch (Exception e) {
			System.out.print("c根据图书id查找出错:"+e.getMessage());
		}
		return book;
	}
	/**
	 * 查找图书信息
	 * @return 返回图书对象 
	 */
	public Vector<BookVO> dofindAllBook(){
		Vector<BookVO> v = new Vector<BookVO>(); 
		try {
			
			v = bookmgrService.findAllBook();
		} catch (Exception e) {
			System.out.print("c根据图书id查找出错:"+e.getMessage());
		}
		return v;
	}
	/**
	 * 添加图书
	 * @param book
	 * @return 返回true或者false
	 */
	public boolean doaddbook(BookVO book){
		boolean result = false;
		try {
			result = bookmgrService.addBook(book);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("c添加用户出错:"+e.getMessage());
		}
		return result;
	}
	/**
	 * 修改图书
	 * @param book 图书对象
	 * @return
	 */
	public boolean doupdatbook(BookVO book){
		boolean result = false;
		try {
			result = bookmgrService.updateBook(book);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("c修改图书出错:"+e.getMessage());
		}
		return result;
	}
	
	/**
	 * 删除图书
	 * @param bid 图书编号
	 * @return 返回true或者false
	 */
	public boolean dodeletebook(int bid){
		boolean result = false;
		try {
			result = bookmgrService.deleteBookByid(bid);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("c删除图书出错:"+e.getMessage());
		}
		return result;
	}
	/**
	 *  按图书名模糊查询
	 * @param name  图书名
	 * @return 返回图书对象
	 */
	public Vector<BookVO> dofindBookByName(String name){
		Vector<BookVO>  v = new Vector<BookVO>();
		try {
		      
			v = bookmgrService.findBookByName(name);
		} catch (Exception e) {
			System.out.print("c根据图书名查找出错:"+e.getMessage());
		}
		return v;
	}		
	/**
	 * 分页查询
	 * @param pageNO  页号
	 * @param pagesize 页的大小
	 * @return 返回图书对象
	 */
public Vector<BookVO> dofindBookBypage(int pageNO,int pagesize){
	Vector<BookVO> v = new Vector<BookVO>();
	try {
	      
		v = bookmgrService.findBookBypage(pageNO, pagesize);
	} catch (Exception e) {
		System.out.print("c根据图书名查找出错:"+e.getMessage());
	}
	return v;
}		
}
