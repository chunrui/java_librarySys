package com.lingnan.usersys.usermgrsys.domian;
/**
 * 用户实体类
 * @author Administrator
 *
 */
public class UserVO {
		public String aid; //主键
		public String aname; //用户姓名
		public String apassword; //用户密码
		public int aflag; //用户标志位
		public int power; //用户权限
		/**
		 * 获取用户id方法
		 * @return 返回用户id号
		 */
		public String getAid() {
			return aid;
		}
		/**
		 * 设置用户id号
		 * @param aid 用户id号
		 */
		public void setAid(String aid) {
			this.aid = aid;
		}
		/**
		 * 获取用户名
		 * @return 返回用户名
		 */
		public String getAname() {
			return aname;
		}
		/**
		 * 存用户名
		 * @param aname 用户名称参数
		 */
		public void setAname(String aname) {
			this.aname = aname;
		}
		/**
		 * 获取密码
		 * @return 返回用户密码
		 */
		public String getApassword() {
			return apassword;
		}
		/**
		 * 存密码
		 * @param apassword 用户密码参数
		 */
		public void setApassword(String apassword) {
			this.apassword = apassword;
		}
		/**
		 * 获取标志位
		 * @return 返回用户标志位
		 */
		public int getAflag() {
			return aflag;
		}
		/**
		 * 存标志位
		 * @param aflag 用户标志位
		 */
		public void setAflag(int aflag) {
			this.aflag = aflag;
		}
		/**
		 * 获取权限
		 * @return 返回用户权限
		 */
		public int getPower() {
			return power;
		}
		/**
		 * 存权限
		 * @param power  用户权限
		 */
		public void setPower(int power) {
			this.power = power;
		}
		
	}
