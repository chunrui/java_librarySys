package com.lingnan.usersys.usermgrsys.business.service;

import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.usermgrsys.domian.BookVO;
/**
 * BookService抽象类
 * @author Administrator
 *
 */
public interface BookService {
	/**
	 *添加图书
	 * @param book 图书信息
	 * @return 返回值为true或者false
	 */
	public boolean addBook(BookVO book);
	/**
	 * 图书更新
	 * @param book 图书信息
	 * @return 返回true或者false
	 */
	public boolean updateBook(BookVO book);
	/**
	 * 根据id号查找图书
	 * @param bid 图书编号
	 * @return  返回BookVO对象
	 */
	public BookVO findBookByid(int bid);
	
	/**
	 * 查找所有图书
	 * @return  返回BookVO对象
	 */
	public Vector<BookVO> findAllBook();
	/**
	 * 根据bid号删除图书
	 * @param bid 图书编号
	 * @return  返回true或者false
	 */
	public boolean deleteBookByid(int bid);
	/**
	   * 通过图书名查询
	   * @param name  图书名
	   * @return 返回图书对象
	   */
	public Vector<BookVO> findBookByName(String name);
		/**
		 * 分页查询
		 * @param page  页号
		 * @param size  页的大小
		 * @return  返回图书对象
		 */
	public Vector<BookVO> findBookBypage(int pageNO,int pagesize);

}