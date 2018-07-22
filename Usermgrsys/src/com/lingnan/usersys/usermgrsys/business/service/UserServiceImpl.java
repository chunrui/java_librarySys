package com.lingnan.usersys.usermgrsys.business.service;
import java.sql.Connection;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.business.dao.UserDao;
import com.lingnan.usersys.usermgrsys.domian.UserVO;

public class UserServiceImpl implements UserService{
	/**
	 * 生成一个userservice
	 */
	private static UserService userservice = new UserServiceImpl();
	/**
	 * 私有的构造方法
	 */
	private UserServiceImpl(){
		
	}
	/**
	 * 通过getInstance()获取UserService
	 * @return
	 */
	public static UserService getInstance()
	{
		return userservice;
	}

	/**
	 * 添加用户信息
	 * @param user 用户对象
	 * @return 返回true或者false
	 */
	public boolean addUser(UserVO user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		//UserVO user = null;
		//声明变量，用于记录添加结果返回值
		boolean result =false;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			UserDao userMrgDao= (UserDao) DaoFactory.getBaseDao(conn, EnumType.USER_DAO);
			//开启事物
			DBUtils.beginTransaction(conn);
			//user.setPower(2);
			//调用dao中adduser（）方法，进行数据库插入操作，将结果集赋给result变量
			result = userMrgDao.addUser(user);
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
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO login(String aid, String pass) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		UserVO user = null;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			UserDao userMrgDao= (UserDao) DaoFactory.getBaseDao(conn, EnumType.USER_DAO);
			user = userMrgDao.login(aid, pass);
		}catch (DaoException e) {
			throw e;
		}catch (Exception e) {
			//自定义异常类
			throw new ServiceException("用户登录失败@");
		}
		finally{
			//数据库关闭
			DBUtils.closeConnection(conn);
		}	
		return user;
	}
	/**
	 * 修改用户信息
	 * @param user 用户对象
	 * @return 返回true或者false
	 */
	public boolean updateUser(UserVO user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		//UserVO user = null;
		//声明变量，用于记录添加结果返回值
		boolean result =false;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			UserDao userMrgDao= (UserDao) DaoFactory.getBaseDao(conn, EnumType.USER_DAO);
			//开启事物
			DBUtils.beginTransaction(conn);
			//user.setPower(2);
			//调用dao中adduser（）方法，进行数据库插入操作，将结果集赋给result变量
			result = userMrgDao.updateUser(user);
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
	 * 根据id查找用户信息
	 * @param aid 用户编号
	 * @return 返回true或者false
	 */
	public UserVO findUserByid(String aid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		UserVO user = null;
		try {
			//调用数据库连接对象，用于保存数据库连接对象
			conn = DBUtils.getConnection();
			//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
			UserDao userMrgDao= (UserDao) DaoFactory.getBaseDao(conn, EnumType.USER_DAO);
			user = userMrgDao.findUserByid(aid);
		} catch (DaoException e) {
			throw e;
		}catch (Exception e) {
			//自定义异常类
			throw new ServiceException("用户查找失败。。。");
		}finally{
			//数据库关闭
			DBUtils.closeConnection(conn);
		}	
		return user;
	}		       
	/**
	 * 查找所有用户信息
	 * @return Vector型
	 */
	public Vector<UserVO> findAllUser() {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				UserVO user = null;
				Vector<UserVO> v = null;
				try {
					//调用数据库连接对象，用于保存数据库连接对象
					conn = DBUtils.getConnection();
					//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
					UserDao userMrgDao= (UserDao) DaoFactory.getBaseDao(conn, EnumType.USER_DAO);
					v = userMrgDao.findAllUser();
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
	 * 根据id删除用户信息
	 * @param aid 用户编号
	 * @return 返回true或者false
	 */
	public boolean deleteUserByid(String aid) {
		      // TODO Auto-generated method stub
				Connection conn = null;
				//UserVO user = null;
				//声明变量，用于记录添加结果返回值
				boolean result =false;
				try {
					//调用数据库连接对象，用于保存数据库连接对象
					conn = DBUtils.getConnection();
					//调用dao工厂的getdao方法，取得指定类型的dao类，并将值赋给dao接口变量
					UserDao userMrgDao= (UserDao) DaoFactory.getBaseDao(conn, EnumType.USER_DAO);
					//开启事物
					DBUtils.beginTransaction(conn);
					
					//调用dao中adduser（）方法，进行数据库插入操作，将结果集赋给result变量
					result = userMrgDao.deleteUserByid(aid);
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
}
