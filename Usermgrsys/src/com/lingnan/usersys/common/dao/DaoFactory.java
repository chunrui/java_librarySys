package com.lingnan.usersys.common.dao;

import java.sql.Connection;

import javax.sql.rowset.serial.SerialException;

import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.usermgrsys.business.dao.UserDaoImpl;
/**
 * 用户工厂类
 * @author Administrator
 *
 */
public class DaoFactory {
	/**
	 * 获得用户dao对象的工厂方法
	 * @param conn 数据库连接
	 * @param type dao常量
	 * @return 返回工厂
	 */
	public static BaseDao getBaseDao(Connection conn,String type){
		//如果传入的dao类型是用户类型user，就实例化用户dao实现类
		if("user".equals(type)){
			return new UserDaoImpl(conn);
			//返回实例化对象
			//throw new ServiceException("dao工厂方法出错");
		}
		//如果没有和以上指定类型匹配的值，就提示错误信息
		else{
			throw new ServiceException("dao工厂方法出错");
		}
	}

}
