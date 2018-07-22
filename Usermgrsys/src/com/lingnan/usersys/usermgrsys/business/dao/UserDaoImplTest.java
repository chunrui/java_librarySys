package com.lingnan.usersys.usermgrsys.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 用户测试类
 * @author Administrator
 *
 */
public class UserDaoImplTest {

/**
 * 登录测试方法
 */
	public void testLogin() {
		//fail("Not yet implemented");
		Connection conn = DBUtils.getConnection();
		UserDao a = new UserDaoImpl(conn);
		String aid = "t03";
		String pass = "222222";
		UserVO uservo = a.login(aid, pass);
		String id = uservo.getAid();
		System.out.print(id);
	}
}
