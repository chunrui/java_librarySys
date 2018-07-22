package com.lingnan.usersys.usermgrsys.domian;
/**
 * 图书实体类
 * @author Administrator
 *
 */
public class BookVO {
	
	public int Bid; //主键
	public String Bname; //图书名
	public String Bauthor;//图书作者
	public String Bstate; //图书状态
	public int Bflag; //图书标志位
	/**
	 * 获取图书编号
	 * @return 返回图书编号
	 */
	public int getBid() {
		return Bid;
	}
	/**
	 * 存图书编号
	 * @param bid 图书编号参数
	 */
	public void setBid(int bid) {
		Bid = bid;
	}
	/**
	 * 获取图书名
	 * @return 返回图书名
	 */
	public String getBname() {
		return Bname;
	}
	/**
	 * 存取图书名
	 * @param bname 图书名参数
	 */
	public void setBname(String bname) {
		Bname = bname;
	}
	/**
	 * 获取作者名
	 * @return 返回读者
	 */
	public String getBauthor() {
		return Bauthor;
	}
	/**
	 * 存图书作者名
	 * @param bauthor 读者参数
	 */
	public void setBauthor(String bauthor) {
		Bauthor = bauthor;
	}
	/**
	 * 获取图书状态
	 * @return 返回状态位
	 */
	public String getBstate() {
		return Bstate;
	}
	/**
	 * 存图书状态
	 * @param bstate 图书状态
	 */
	public void setBstate(String bstate) {
		Bstate = bstate;
	}
	/**
	 * 获取图书标志位
	 * @return 返回标志位
	 */
	public int getBflag() {
		return Bflag;
	}
	/**
	 * 存图书标志位
	 * @param bflag 参数标志位
	 */
	public void setBflag(int bflag) {
		Bflag = bflag;
	}
	 

}
