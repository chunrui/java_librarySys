package com.lingnan.usersys.usermgrsys.business.dao;

import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 用户dao接口
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao{
	/**
	 *用户注册/添加用户
	 * @param user 用户信息
	 * @return 返回值为true或者false
	 */
	public boolean addUser(UserVO user);
	/**
	 * 用户登录
	 * @param aid 用户编号
	 * @param pass 用户密码
	 * @return  返回用户对象
	 */
	public UserVO login(String aid,String pass);
	/**
	 * 用户更新
	 * @param user 用户信息
	 * @return 返回true或者false
	 */
	public boolean updateUser(UserVO user);
	/**
	 * 根据id号查找用户
	 * @param aid 用户编号
	 * @return  返回用户对象
	 */
	public UserVO findUserByid(String aid);
	
	/**
	 * 查找所有用户
	 *@return  返回用户对象
	 */
	public Vector<UserVO> findAllUser();
	/**
	 * 根据aid号删除用户
	 * @param aid 用户编号
	 * @return  true或者false
	 */
	public boolean deleteUserByid(String aid);

}
