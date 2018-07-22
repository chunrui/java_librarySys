package com.lingnan.usersys.usermgrsys.view;

import java.awt.print.Book;
import java.util.Scanner;
import java.util.Vector;

import com.lingnan.usersys.usermgrsys.controller.BookController;
import com.lingnan.usersys.usermgrsys.controller.UserController;
import com.lingnan.usersys.usermgrsys.domian.BookVO;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 普通用户视图
 * @author Administrator
 *
 */
public class NormalFrame extends IndexFrame{
	//用户对象
	UserVO user = null;
	BookVO book=null;
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user 用户信息
	 */
	public  NormalFrame(UserVO user){
		this.user=user;
		//System.out.println(user);
		
	}
	/**
	 * 带参数的构造器，用于初始化book属性
	 * @param book 图书信息
	 */
	public  NormalFrame(BookVO book){
		this.book=book;
		//System.out.println(user);
		
	}
	 /**
	  * 普通用户展示的方式
	  */
	public void show(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("             --欢迎进入普通用户界面--           ");
			System.out.println("*-***************************************-*"); 
			System.out.println("*             1.修改个人信息                                                      *");       
			System.out.println("*             2.查看个人信息                                                      *");
			System.out.println("*             3.查看图书信息                                                      *");
			System.out.println("*             4.退出系统                                                              *");
			System.out.println("*-***************************************-*");
			int i =-1 ;
			System.out.println("请输入1~4的数字：");
			while(true){
				try {
					 i = input.nextInt();
					 break;
				} catch (Exception e) {
					System.out.println("只能输入1~4的数字");
					System.out.println("请重新输入...");
				}
			}
			switch (i) {
			case 1:
				this.updateshow("修改", user);;
				break;
			case 2:
				this.searchshow(user);
				break;
			case 3:
			{
				while(true){ 
				System.out.println("             --欢迎进入图书信息查询模块--         ");
				System.out.println("*-**************************************-*"); 
	    		System.out.println("*               1. 无条件查询图书信息                              *");    
	    		System.out.println("*               2. 按id查询图书信息                                *"); 
	    		System.out.println("*               3. 返回                                                          *");
	    		System.out.println("*-**************************************-*"); 
	    		System.out.println("请输入1或者2或者3");
	    		int b1=input.nextInt();	
	    		switch(b1)          
    	    	{                  
    	    	case 1:
    	    		this.searchAllBookshow();break;
    	    	case 2:
    	    		this.searchBookshow();break; 
				case 3:
		    		this.show();break;
    	    	}
    	    	}
			
			}
			case 4:
				System.out.println("已退出系统，谢谢您的使用！");
				System.exit(0);
			default:
				System.out.println("您输入的数据不当，请重新输入！");
			}
		}
	}
	/**
	 * 查找显示方法
	 * @param user 用户对象信息
	 */
	public void searchshow(UserVO user) {
		// TODO Auto-generated method stub
		//Scanner input = new Scanner(System.in);
		try {
			String power1 ="普通用户";
			System.out.println("           --欢迎进入个人信息查询界面--");
			System.out.println("-------------------------------------------");
			System.out.println("编号             昵称               密码                       权限");
			System.out.println(""+user.getAid()+"    "+user.getAname()+"          "+user.getApassword()+"     "+power1+"");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("个人信息查找失败！"+e.getMessage());
		}
		
		
	}
	/**
	 * 更新显示方法 
	 * @param type 更新类型
	 * @param user 用户对象信息
	 */
	public void updateshow(String type, UserVO user) {
		Scanner input = new Scanner(System.in);
		if("修改".equals(type)){
			System.out.println("               --欢迎进入个人信息修该界面--");
			System.out.println("-------------------------------------------");
		}else{
				System.out.println("           --欢迎进入用户信息修改界面--");
				System.out.println("-------------------------------------------");
			}
			System.out.println("请输入您要修改的账号：");
			try {
				user.setAid(input.next());
				System.out.println("请输入您要修改的密码：");
				user.setApassword(input.next());
				System.out.println("请输入您要修改的昵称：");
				user.setAname(input.next());
				UserController uc = new UserController();
				user.setPower(2);
				String power = "普通用户";
				System.out.println(""+user.getAid()+"    "+user.getAname()+"          "+user.getApassword()+"     "+power+"");
				boolean binsert = uc.doupdateuser(user);
				//System.out.println(binsert);
				if(binsert){
					if("修改".equals(type)){
						System.out.println("个人修改成功！");
					}
					else{
						System.out.println("修改用户成功！");
					}
				}else{
					if("修改".equals(type)){
						System.out.println("个人修改失败！");
					}else{
						System.out.println("修改用户失败！");
					}	
				}			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("修改用户失败！");
			}
		}
	/**
	 * 根据图书id号查找图书方法
	 * 
	 */
	public void searchBookshow() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		BookVO book = null;
		try {
			
			System.out.println("          --欢迎进入图书信息ID查询界面--");
			System.out.println("-------------------------------------------");
			BookController bc = new BookController();
			System.out.println("请输入查找图书id号");
			int bid = input.nextInt();
			book = bc.dofindBookByid(bid);
			System.out.println("图书编号             图书名        作者      图书状态");
			System.out.println(""+book.getBid()+"      "+book.getBname()+"            "+book.getBauthor()+"       "+book.getBstate()+"");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("图书信息查找失败！"+e.getMessage());
		}
	}
	
	/**
	 * 查找所有图书息方法
	 * @return 返回Vector<BookVO>
	 */
	public Vector<BookVO> searchAllBookshow() {
		// TODO Auto-generated method stub
		//Scanner input = new Scanner(System.in);
		Vector<BookVO> v = null;
		try {
			BookController uc = new BookController();
			v = uc.dofindAllBook();
			System.out.println("         --欢迎进入查询所有图书界面--");
			System.out.println("-------------------------------------------");
			System.out.println("图书编号             图书名        作者      图书状态");
			for(BookVO book:v)
			{
				
				System.out.println(""+book.getBid()+"      "+book.getBname()+"            "+book.getBauthor()+"       "+book.getBstate()+"");		
			    System.out.println("---------------------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("管理员用户信息查找失败！"+e.getMessage());
		}	
		return v;
	}
}
