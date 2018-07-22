package com.lingnan.usersys.usermgrsys.controller;

import java.util.Vector;
import com.lingnan.usersys.usermgrsys.business.service.ReaderService;
import com.lingnan.usersys.usermgrsys.business.service.ReaderServiceImpl;
import com.lingnan.usersys.usermgrsys.domian.ReaderVO;
/**
 * 控制层读者类
 * @author Administrator
 *
 */
public class ReaderController {
	ReaderService  readermgrService = ReaderServiceImpl.getInstance();
	/**
	 * 根据图书id好查找图书信息
	 * @param aid 图书id 
	 * @return 图书信息
	 */
	public ReaderVO dofindReaderByid(String rid){
		ReaderVO raeder =null;
		try {
		      
			raeder = readermgrService.findReaderByid(rid);
		} catch (Exception e) {
			System.out.print("c根据图书id查找出错:"+e.getMessage());
		}
		return raeder;
	}
	/**
	 * 查找图书信息
	 * @return Vector<BookVO> 
	 */
	public Vector<ReaderVO> dofindAllReader(){
		Vector<ReaderVO> v = new Vector<ReaderVO>(); 
		try {
		      
			v = readermgrService.findAllReader();
		} catch (Exception e) {
			System.out.print("c根据图书id查找出错:"+e.getMessage());
		}
		return v;
	}
}
