package com.lingnan.usersys.usermgrsys.view;

import com.lingnan.usersys.usermgrsys.domian.UserVO;

/**
 * 视图的接口
 * @author Administrator
 *
 */
public interface BaseFrame {
	/**
	 * 显示页面
	 */
	public void show();
	/**
	 * 查找页面
	 */
	public void searchshow();
	/**
	 * 添加用户显示
	 * @param type 类型 
	 */
	public void addshow(String type);
	/**
	 * 更新信息
	 * @param type 类型
	 * @param user 用户对象
	 */
	public void updateshow(String type,UserVO user);
}
