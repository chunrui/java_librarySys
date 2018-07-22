package com.lingnan.usersys.usermgrsys.business.service;

import java.sql.Connection;
import java.util.Vector;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.dao.ReaderFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.business.dao.ReaderDao;
import com.lingnan.usersys.usermgrsys.business.dao.UserDao;
import com.lingnan.usersys.usermgrsys.domian.ReaderVO;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 读者service类
 * @author Administrator
 *
 */
public class ReaderServiceImpl implements ReaderService{
	/**
	 * 生成一个readerService
	 */
	private static ReaderService readerService = new ReaderServiceImpl();
	/**
	 * 私有的构造方法
	 */
	private ReaderServiceImpl(){
		
	}
	/**
	 * 通过getInstance()获取UserService
	 * @return
	 */
	public static ReaderService getInstance()
	{
		return readerService; 
	}
	/**
	 * 添加读者信息
	 * @param reader 读者对象
	 * @return 返回true或者false 
	 */
	public boolean addReader(ReaderVO reader) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 更新读者信息
	 * @param reader 读者对象
	 * @return 返回true或者false 
	 */
	public boolean updateReader(ReaderVO reader) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 根据id号查找读者信息
	 * @param rid 读者编号
	 * @return 返回读者对象
	 */
	public ReaderVO findReaderByid(String rid) {
		 //声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		ReaderVO reader = null;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			ReaderDao readerMrgDao= (ReaderDao) ReaderFactory.getBaseDao(conn, EnumType.Read_DAO);
			reader = readerMrgDao.findReaderByid(rid);
		} catch (DaoException e) {
			throw e;
		}catch (Exception e) {
			//自定义异常类
			throw new ServiceException("用户查找失败。。。");
		}finally{
			//数据库关闭
			DBUtils.closeConnection(conn);
		}	
		return reader;
	}			      	

	/**
	 * 查找读者所有信息
	 * @return 返回读者对象
	 */
	public Vector<ReaderVO> findAllReader() {
		 //声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		Vector<ReaderVO> v = null;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			ReaderDao readerMrgDao= (ReaderDao) ReaderFactory.getBaseDao(conn, EnumType.Read_DAO);
			v = readerMrgDao.findAllReader();
		} catch (DaoException e) {
			throw e;
		}catch (Exception e) {
			//自定义异常类
			throw new ServiceException("用户查找失败。。。");
		}finally{
			//数据库关闭
			DBUtils.closeConnection(conn);
		}	
		return v;
	}			      	
	/**
	 * 根据id号删除读者信息
	 * @param rid 读者编号
	 * @return 返回true或者false
	 */
	public boolean deleteReaderByid(String rid) {
		// TODO Auto-generated method stub
		return false;
	}

}
