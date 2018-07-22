package com.lingnan.usersys.usermgrsys.controller;

import java.util.Vector;

import com.lingnan.usersys.usermgrsys.business.service.UserService;
import com.lingnan.usersys.usermgrsys.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 用户控制类
 * @author Administrator
 *
 */
public class UserController {
	/**
	 * 通过UserServiceImpl的getInstance()方法获取usermgrService对象
	 */
	UserService usermgrService = UserServiceImpl.getInstance();
	/**
	 * 登录方法
	 * @param aid 用户id
	 * @param pass 用户密码
	 * @return  返回用户信息
	 */
	public UserVO dologin(String aid,String pass)
	{ 
		//定义一个用户实体，用于存放登录用户的信息
		UserVO user =null; 
		try{
			//调用UserServiceImpl的login（）方法
		    user = usermgrService.login(aid, pass);
	}catch(Exception e){
		//输出异常信息
		System.out.print("登录出现错误！！"+e.getMessage());
	}
		//返回用户信息
		return user;
	}
	/**
	 * 根据用户id好查找用户信息
	 * @param aid 用户id 
	 * @return 用户信息
	 */
	public UserVO dofindUserByid(String aid){
		UserVO user =null;
		try {
			usermgrService.findUserByid(aid);
		} catch (Exception e) {
			System.out.print("c根据用户id查找出错:"+e.getMessage());
		}
		return user;
	}
	
	/**
	 * 根据用户id好查找用户信息
	 * @param aid 用户id 
	 * @return 用户信息
	 */
	public Vector<UserVO> dofindAllUser(){
		Vector<UserVO>  v = null;
		try {
			v = usermgrService.findAllUser();
		} catch (Exception e) {
			System.out.print("c根据用户id查找出错:"+e.getMessage());
		}
		return v;
	}
	
	/**
	 * 添加用户/注册
	 * @param user
	 * @return
	 */
	public boolean doadduser(UserVO user){
		boolean result = false;
		try {
			result = usermgrService.addUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("c添加用户出错:"+e.getMessage());
		}
		return result;
	}
	/**
	 * 修改用户信息
	 * @param user 用户对象
	 * @return 返回true或者false
	 */
	public boolean doupdateuser(UserVO user){
		boolean result = false;
		try {
			result = usermgrService.updateUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("c修改用户出错:"+e.getMessage());
		}
		return result;
	}
	
	/**
	 * 删除用户信息
	 * @param aid 读者编号
	 * @return 返回true或者false
	 */
	public boolean dodeleteuser(String aid){
		boolean result = false;
		try {
			result = usermgrService.deleteUserByid(aid);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("c修改用户出错:"+e.getMessage());
		}
		return result;
	}
}
