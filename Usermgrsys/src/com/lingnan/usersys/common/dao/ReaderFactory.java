package com.lingnan.usersys.common.dao;

import java.sql.Connection;

import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.usermgrsys.business.dao.BookDaoImpl;
import com.lingnan.usersys.usermgrsys.business.dao.ReaderImpl;
/**
 * 读者工厂类
 * @author Administrator
 *
 */
public class ReaderFactory {
	/**
	 * 获得用户dao对象的工厂方法
	 * @param conn 数据库连接
	 * @param type dao常量
	 * @return
	 */
 public static BaseDao getBaseDao(Connection conn,String type){
	if("reader".equals(type)){
		return new ReaderImpl(conn);
		//返回实例化对象
		//throw new ServiceException("dao工厂方法出错");
	}
	//如果没有和以上指定类型匹配的值，就提示错误信息
	else{
		throw new ServiceException("dao工厂方法出错");
	}
}
}
