package com.lingnan.usersys.usermgrsys.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 用户测试类2
 * @author Administrator
 *
 */
public class UserDaoImplTest1 {

	/**
	 * 根据用户id查找测试方法
	 */
	public void testUserDaoImpl() {
			//fail("Not yet implemented");
			Connection conn = DBUtils.getConnection();
			UserDao a = new UserDaoImpl(conn);
			UserVO user = a.findUserByid("t03");
			user.setAid("t03");
			user.setAname("小小美");
			user.setApassword("222222");
			user.setPower(2);
			System.out.print(user.getPower());
			System.out.print(user.getAflag());
			boolean flag = a.updateUser(user);
			System.out.print(flag);
	}

}
