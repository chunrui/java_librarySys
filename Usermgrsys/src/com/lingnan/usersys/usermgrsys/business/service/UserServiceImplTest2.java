package com.lingnan.usersys.usermgrsys.business.service;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 用户service层测试类2
 * @author Administrator
 *
 */
public class UserServiceImplTest2 {

	/**
	 * 用户service层查找测试方法
	 */
	public void testFindAllUser() {
		    UserService usermgrService =  UserServiceImpl.getInstance();
			
		    Vector<UserVO>  v= usermgrService.findAllUser();
		    System.out.println("编号             昵称               密码                       权限");
			for(UserVO user:v)
			{
				System.out.println(""+user.getAid()+"    "+user.getAname()+"          "+user.getApassword()+"     "+user.getPower()+"");
			}
	}

}
