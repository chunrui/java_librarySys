package com.lingnan.usersys.usermgrsys.business.service;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgrsys.business.dao.UserDao;
import com.lingnan.usersys.usermgrsys.business.dao.UserDaoImpl;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 用户service层测试类
 * @author Administrator
 *
 */
public class UserServiceImplTest {

/**
 * 用户service层登录测试方法
 */
	public void testLogin() {
		//fail("Not yet implemented");
		        UserService usermgrService =  UserServiceImpl.getInstance();
				String aid = "t01";
				String pass = "111111";
				UserVO user = usermgrService.login(aid, pass);
				String id = user.getAid();
				System.out.print(id);
	}

}
