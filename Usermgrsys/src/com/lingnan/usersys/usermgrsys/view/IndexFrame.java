package com.lingnan.usersys.usermgrsys.view;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import com.lingnan.usersys.usermgrsys.controller.UserController;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 用于用户登录、注册视图
 * @author Administrator
 *
 */
public class IndexFrame implements BaseFrame{
     
	/**
	 * 显示首页面
	 */
	public void show() {
		//输入流
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("            --欢迎来到岭师图书管理系统--          "); 
			System.out.println("*-**************************************-*"); 
			System.out.println("*             1.登录                                                                   *");       
			System.out.println("*             2.注册                                                                   *");
			System.out.println("*             3.退出系统                                                           *");
			System.out.println("*-**************************************-*");
			int i =-1 ;
			System.out.println("请输入1~3的数字：");
			while(true){
				try {
					 i = input.nextInt();
					 break;
				} catch (Exception e) {
					System.out.println("只能输入1~3的数字");
					System.out.println("请重新输入...");
				}
			}
			switch (i) {
			case 1:
				this.loginshow();
				break;
			case 2:
				this.addshow("注册");
				break;
			case 3:
				System.out.println("已退出系统，谢谢您的使用！");
				System.exit(0);
			default:
				System.out.println("你输入的数据不当，请重新输入！");
			}
		}	
	}
	/**
	 * 登录视图
	 */
    public void loginshow(){
    	Scanner input = new Scanner(System.in);
    	System.out.println("*----------------欢迎进入登录页面-------------*");       
		System.out.println("*----------------------------------------*");
		System.out.println("请输入登录账号：                                                                               ");
		try {
			String id = input.next();
			System.out.println("请输入登录密码：                                                                               ");
			String pass = input.next();
			UserController c = new UserController();
			UserVO user = c.dologin(id,pass);
//			String aid = user.getAid();
//			System.out.println("控制层"+aid);
		    if(user!=null){
		    	int power = user.getPower();
		    	System.out.println(power);
		    	String power1=null;
		    	if(power==1){
		    		 power1="管理员";
		    		 System.out.println("登录成功！                                                                                        "); 
		    		 //System.out.println("&--------------欢迎进入管理员界面--------&");
					 System.out.println("*----------------------------------------*");
					 System.out.println("你好："+user.getAname()+"                        "+"                您的权限是："+power1);
					 AdminFrame admin = new AdminFrame(user);
					 admin.show();
		    	}
		    	if(power==2){
		    		power1="普通用户";
		    		System.out.println("登录成功..... ");
		    		//System.out.println("&-------------欢迎进入普通用户界面---------&");
					System.out.println("*----------------------------------------*");
					System.out.println("您好："+user.getAname()+"                        "+"                您的权限是："+power1);
					NormalFrame normal = new NormalFrame(user);
					normal.show();
		    	}	
				System.exit(0);
			}else {
				System.out.println("登录 失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("登录 失败！"+e.getMessage());
		}
		
    }
	/**
	 * 查找显示方法
	 */
	public void searchshow() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 添加显示方法
	 */
	public void addshow(String type) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		if("注册".equals(type)){
			System.out.println("               --欢迎进入用户注册界面--");
			System.out.println("*----------------------------------------*");
		}else{
			
		}
		System.out.println("请输入您的账号：");
		try {
			UserVO user = new UserVO();
			user.setAid(input.next());
			System.out.println("请输入您的密码：");
			user.setApassword(input.next());
			System.out.println("请输入您的昵称：");
			user.setAname(input.next());
			UserController uc = new UserController();
			boolean binsert = uc.doadduser(user);
			if(binsert){
				if("注册".equals(type)){
					System.out.println("用户注册成功！");
				}
				else{
					System.out.println("添加用户成功！");
				}
			}else{
				if("注册".equals(type)){
					System.out.println("用户注册失败！");
				}else{
					System.out.println("添加用户失败！");
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("添加用户失败！");
		}
	}

	/**
	 * 更新显示方式
	 */
	public void updateshow(String type, UserVO user) {
		// TODO Auto-generated method stub
		
	}
   	

}
