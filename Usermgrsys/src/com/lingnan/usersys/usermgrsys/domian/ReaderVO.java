package com.lingnan.usersys.usermgrsys.domian;
/**
 * 读者实体类
 * @author Administrator
 *
 */
public class ReaderVO {
	public String Sid;   //主键
	public String Sname;  //读者编号
	public String Ssex;  //读者编号
	public String Sclassid;  //读者编号
	public String Sdepartment;  //读者院系
	public int Sage;  //读者年龄
	public String Semail; //读者邮箱
	public int Sflag;  //读者标志位
	/**
	 * 获取读者编号
	 * @return
	 */
	public String getSid() {
		return Sid;
	}
	/**
	 * 存读者编号
	 * @param sid
	 */
	public void setSid(String sid) {
		Sid = sid;
	}
	/**
	 * 获取读者名称
	 * @return
	 */
	public String getSname() {
		return Sname;
	}
	/**
	 * 存读者姓名
	 * @param sname
	 */
	public void setSname(String sname) {
		Sname = sname;
	}
	/**
	 * 获取读者性别
	 * @return
	 */
	public String getSsex() {
		return Ssex;
	}
	/**
	 * 存读者性别
	 * @param ssex
	 */
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	/**
	 * 获取读者班级
	 * @return
	 */
	public String getSclassid() {
		return Sclassid;
	}
	/**
	 * 存读者班级
	 * @param sclassid
	 */
	public void setSclassid(String sclassid) {
		Sclassid = sclassid;
	}
	/**
	 * 获取读者院系
	 * @return
	 */
	public String getSdepartment() {
		return Sdepartment;
	}
	/**
	 * 存读者院系
	 * @param sdepartment
	 */
	public void setSdepartment(String sdepartment) {
		Sdepartment = sdepartment;
	}
	/**
	 * 获取读者邮箱
	 * @return
	 */
	public String getSemail() {
		return Semail;
	}
	/**
	 * 存读者邮箱
	 * @param semail
	 */
	public void setSemail(String semail) {
		Semail = semail;
	}
	
	
	
	/**
	 * 获取读者年龄
	 * @return
	 */
	public int getSage() {
		return Sage;
	}
	/**
	 * 存读者年龄
	 * @param sage
	 */
	public void setSage(int sage) {
		Sage = sage;
	}
	/**
	 * 获取读者标志位
	 * @return
	 */
	public int getSflag() {
		return Sflag;
	}
	/**
	 * 存读者标志位
	 * @param sflag
	 */
	public void setSflag(int sflag) {
		this.Sflag = sflag;
	}
}

