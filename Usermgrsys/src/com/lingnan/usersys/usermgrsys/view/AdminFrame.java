package com.lingnan.usersys.usermgrsys.view;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.lingnan.usersys.usermgrsys.controller.BookController;
import com.lingnan.usersys.usermgrsys.controller.ReaderController;
import com.lingnan.usersys.usermgrsys.controller.UserController;
import com.lingnan.usersys.usermgrsys.domian.BookVO;
import com.lingnan.usersys.usermgrsys.domian.ReaderVO;
import com.lingnan.usersys.usermgrsys.domian.UserVO;
/**
 * 管理员视图类
 * @author Administrator
 *
 */
public class AdminFrame extends NormalFrame{
	/**
	 * 带参数构造器，用于初始化user属性
	 * @param user 用户信息
	 */
	public AdminFrame(UserVO user){
		super(user);
	}
	/**
	 * 带参数构造器，用于初始化user属性
	 * @param user 用户信息
	 */
	public AdminFrame(BookVO book){
		super(book);
	}
	/**
	 * 管理员展示功能是方法
	 */
	public void show(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("            --欢迎进入管理员界面--             ");
			System.out.println("*-**************************************-*"); 
			System.out.println("*             1.个人信息管理                                                   *");       
			System.out.println("*             2.用户信息管理                                                    *");
			System.out.println("*             3.图书信息管理                                                    *");
			System.out.println("*             4.读者信息管理                                                    *");
			System.out.println("*             5.退出系统                                                            *");
			System.out.println("*-**************************************-*");
			int i =-1 ;
			System.out.println("请输入1~4的数字：");
			while(true){
				try {
					 i = input.nextInt();
					 break;
				} catch (Exception e) {
					System.out.println("只能输入1~5的数字");
					System.out.println("请重新输入...");
				}
			}
			switch (i) {
			case 1:{
			 while(true){
				System.out.println("           --欢迎进入管理员个人信息管理模块--      ");
				System.out.println("*-*************************************-*");
	    		System.out.println("*               1. 查看个人信息                                        *");    
	    		System.out.println("*               2. 修改个人信息                                        *"); 
	    		System.out.println("*               3. 返回                                                        *");
	    		System.out.println("*-*************************************-*");
	    		System.out.println("请输入1或者2或3");
	    		int b1=input.nextInt();	
	    		switch(b1)          
    	    	{                  
    	    	case 1:
    	    		this.searchshow(user);break;
    	    	case 2:
    	    		this.updateshow("管理员",user);break;
    	    	case 3:
    	    		this.show();break;
	    		} 
	    		}
    	    	}
			case 2:
				while(true){
					System.out.println("           --欢迎进入用户信息管理模块--          ");
					System.out.println("*-*************************************-*");
		    		System.out.println("*               1. 查看用户信息                                        *");    
		    		System.out.println("*               2. 修改用户信息                                        *");
		    		System.out.println("*               3. 添加用户信息                                        *");    
		    		System.out.println("*               4. 删除用户信息                                        *"); 
		    		System.out.println("*               5. 返回                                                        *");
		    		System.out.println("*-*************************************-*");
		    		System.out.println("请输入1~5");
		    		int b1=input.nextInt();	
		    		switch(b1)          
	    	    	{                  
	    	    	case 1:
	    	    		this.searchAllUsershow();break;
	    	    	case 2:
	    	    		this.updateUsershow();break;
	    	    	case 3:
	    	    		this.addshow("用户");break;
	    	    	case 4:
	    	    		this.deleteshow("用户");break;
	    	    	case 5:
	    	    		this.show();break;
		    		} 
	    	    	}
			case 3:
				while(true){
					System.out.println("           --欢迎进入图书信息管理模块--      ");
					System.out.println("*-**************************************-*");
		    		System.out.println("*               1. 查看图书信息                                         *");    
		    		System.out.println("*               2. 修改图书信息                                         *");
		    		System.out.println("*               3. 添加图书信息                                         *");    
		    		System.out.println("*               4. 删除图书信息                                         *"); 
		    		System.out.println("*               5. 返回                                                         *");
		    		System.out.println("*-**************************************-*");
		    		System.out.println("请输入1~5");
		    		int b1=input.nextInt();	
		    		switch(b1)          
	    	    	{                  
	    	    	case 1:
	    	    		while(true){
	    					System.out.println("             --欢迎进入图书信息查询模块--      ");
	    					System.out.println("*-***********************************-*"); 
	    		    		System.out.println("*               1. 查询所有图书信息                        *");    
	    		    		System.out.println("*               2. 按id查询图书信息                       *");
	    		    		System.out.println("*               3. 按图书名模糊查询图书信息         *");    
	    		    		System.out.println("*               4. 按分页查询图书信息                     *");
	    		    		System.out.println("*               5. 返回                                                 *");
	    		    		System.out.println("*-***********************************-*"); 
	    		    		System.out.println("请输入1~5");
	    		    		
	    		    		int b2=input.nextInt();	
	    		    		switch(b2)          
	    	    	    	{                  
	    	    	    	case 1:
	    	    	    		this.searchAllBookshow();break;
	    	    	    	case 2:
	    	    	    		this.searchBookshow();break; 
	    	    	    	case 3:
	    	    	    		this.searchBookBynameshow();break;
	    	    	    	case 4:
	    	    	    		this.searchBookBypage();break; 
	    					case 5:
	    			    		this.show();break;
	    	    	    	}
	    	    	    	}
	    	    	case 2:
	    	    		this.updatebookshow("图书");break;
	    	    	case 3:
	    	    		this.addshow("图书");break;
	    	    	case 4:
	    	    		this.deleteshow("图书");break;
	    	    	case 5:
	    	    		this.show();break;
		    		} 
	    	    	}
			case 4:
				while(true){
				System.out.println("             --欢迎进入读者信息查询模块--      ");
				System.out.println("*-**************************************-*"); 
	    		System.out.println("*              1. 查询所有读者信息                                     *");    
	    		System.out.println("*              2. 按id查询读者信息                                   *");
	    		System.out.println("*              3. 返回                                                             *");
	    		System.out.println("*-**************************************-*");
	    		System.out.println("请输入1~3");
	    		int b1=input.nextInt();	
	    		switch(b1)          
    	    	{                  
    	    	case 1:
    	    		this.searchAllRedadershow();break;
    	    	case 2:
    	    		this.searchReadershow();break;
    	    	case 3:
    	    		this.show();break;
    	    	}
				}
			case 5:
				System.out.println("已退出系统，谢谢您的使用！");
				System.exit(0);
			default:
				System.out.println("您输入的数据不当，请重新输入！");
			}
	}
}

/**
 * 根据id查找显示方法
 * @param user 用户对象
 */
public void searchshow(UserVO user) {
	// TODO Auto-generated method stub
	//Scanner input = new Scanner(System.in);
	try {
		String power1 ="管理员";
		System.out.println("        --欢迎进入管理员个人信息查询界面--");
		System.out.println("---------------------------------------");
		System.out.println("编号             昵称               密码                       权限");
		System.out.println(""+user.getAid()+"    "+user.getAname()+"          "+user.getApassword()+"     "+power1+"");
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("管理员个人信息查找失败！"+e.getMessage());
	}	
}
/**
 * 查找所有用户信息方法
 * @return Vector<UserVO> 
 */
public Vector<UserVO> searchAllUsershow() {
	// TODO Auto-generated method stub
	//Scanner input = new Scanner(System.in);
	Vector<UserVO> v = null;
	try {
		UserController uc = new UserController();
		v = uc.dofindAllUser();
		String power1 =null;
		System.out.println("         --欢迎进入用户信息查询界面--");
		System.out.println("---------------------------------------");
		System.out.println("编号             昵称               密码                       权限");
		for(UserVO sd:v)
		{
			int t = sd.getPower();
			if(t==1){
				power1 ="管理员";
			}else{
				power1 ="普通用户";
			}
			System.out.println(""+sd.getAid()+"    "+sd.getAname()+"          "+sd.getApassword()+"     "+power1+"");
			System.out.println("---------------------------------------");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("管理员用户信息查找失败！"+e.getMessage());
	}
	
	return v;
}
/**
 * 更新用户信息方法
 * @param type 类型
 * @param user 用户对象
 */
public void updateshow(String type, UserVO user) {
	Scanner input = new Scanner(System.in);
	if("用户".equals(type)){
		System.out.println("        --欢迎进入用户信息修该界面--");
		System.out.println("---------------------------------------");
	}else{
			System.out.println("    --欢迎进入管理员个人信息修改界--");
			System.out.println("---------------------------------------");
		}
		
		try {
			System.out.println("请输入您要修改的账号：");
			user.setAid(input.next());
			System.out.println("请输入您要修改的密码：");
			user.setApassword(input.next());
			System.out.println("请输入您要修改的昵称：");
			user.setAname(input.next());
			user.setPower(1);
			String power = "管理员";
			System.out.println("---------------------------------------");
			System.out.println("修改后的个人信息：");
			System.out.println("编号             昵称               密码                       权限");
			UserController uc = new UserController();
			System.out.println(""+user.getAid()+"    "+user.getAname()+"          "+user.getApassword()+"     "+power+"");
			boolean binsert = uc.doupdateuser(user);
			//System.out.println(binsert);
			if(binsert){
				if("用户".equals(type)){
					System.out.println("管理员个人修改成功！");
				}
				else{
					System.out.println("修改管理员个人成功！");
				}
			}else{
				if("用户".equals(type)){
					System.out.println("管理员个人修改失败！");
				}else{
					System.out.println("修改管理员个人失败！");
				}	
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("修改管理员个人失败！");
		}
	}
/**
 *  根据图书id号查找图书方法
 */
public void searchBookshow() {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	BookVO book = null;
	try {
		
		System.out.println("        --欢迎进入图书信息查询界面--");
		System.out.println("---------------------------------------");
		BookController bc = new BookController();
		System.out.println("请输入查找图书id号");
		int bid = input.nextInt();
		book = bc.dofindBookByid(bid);
		System.out.println("图书编号     图书名        作者      图书状态");
		System.out.println(""+book.getBid()+"      "+book.getBname()+"            "+book.getBauthor()+"       "+book.getBstate()+"");
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("图书信息查找失败！"+e.getMessage());
	}
	
	
}
/**
 * 添加展示方法
 */
public void addshow(String type) {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	if("用户".equals(type)){
		System.out.println("            --欢迎进入用户添加界面--          ");
		System.out.println("---------------------------------------");
		System.out.println("请输入用户的账号：");
		try {
			UserVO user = new UserVO();
			user.setAid(input.next());
			System.out.println("请输入用户的密码：");
			user.setApassword(input.next());
			System.out.println("请输入用户的昵称：");
			user.setAname(input.next());
			System.out.println("请输入用户的权限：");
			String power = input.next();
			if(power.equals("管理员")){
				user.setPower(1);
			}
			else{
				user.setPower(2);
			}
			UserController uc = new UserController();
			boolean binsert = uc.doadduser(user);
			if(binsert){
				if("用户".equals(type)){
					System.out.println("用户添加成功！");
				}
				else{
					
				}
			}else{
				if("用户".equals(type)){
					System.out.println("用户添加失败！");
				}else{
					System.out.println("添加用户失败！");
				}
				
			}	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("添加用户失败！");
		}
	}else{
		try{
		System.out.println("            --欢迎进入图书添加界面--          ");
		System.out.println("---------------------------------------");	
		BookVO book = new BookVO();
//		System.out.println("请输入图书编号：");
//		book.setBid(input.nextInt());
		System.out.println("请输入图书名称：");
		book.setBname(input.next());
		System.out.println("请输入图书作者：");
		book.setBauthor(input.next());
		System.out.println("请输入图书状态：");
		book.setBstate(input.next());
		BookController uc = new BookController();
		boolean binsert = uc.doaddbook(book);
		if(binsert){
			if("图书".equals(type)){
				System.out.println("图书添加成功！");
			}
			else{
				System.out.println("图书添加失败！");
			}
		}else{
			if("图书".equals(type)){
				System.out.println("图书添加失败！");
			}else{
				System.out.println("添加图书失败！");
			}
		}	
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("添加用户失败！");
	}
	}
	
}

/**
 * 删除显示方法
 */
public void deleteshow(String type) {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	if("用户".equals(type)){
		System.out.println("            --欢迎进入用户删除界面--          ");
		System.out.println("---------------------------------------");
		System.out.println("请输入要删除用户的账号：");
		try {
			UserVO user = new UserVO();
			String aid = input.next();
			UserController uc = new UserController();
			boolean binsert = uc.dodeleteuser(aid);
			if(binsert){
					System.out.println("用户删除成功！");
				}
				else{
					System.out.println("用户删除失败！");
				}
			}catch (Exception e) {
					// TODO: handle exception
					System.out.println("添加用户失败！");
				}
		}
	else{
		System.out.println("            --欢迎进入图书删除界面--          ");
		System.out.println("---------------------------------------");
		System.out.println("请输入要删除图书的账号：");
		try {
			BookVO book = new BookVO();
			int bid = input.nextInt();
			BookController uc = new BookController();
			boolean binsert = uc.dodeletebook(bid);
			if(binsert){
					System.out.println("图书删除成功！");
				}
				else{
					System.out.println("图书删除失败！");
				}
			}catch (Exception e) {
					// TODO: handle exception
					System.out.println("添加图书失败！");
				}
	}
}
//图书方法
/**
 * 查找所有图书息方法
 */
public Vector<BookVO> searchAllBookshow() {
	// TODO Auto-generated method stub
	//Scanner input = new Scanner(System.in);
	Vector<BookVO> v = null;
	try {
		BookController uc = new BookController();
		v = uc.dofindAllBook();
		System.out.println("          --欢迎进入图书息查询界面--");
		System.out.println("---------------------------------------");
		System.out.println("图书编号   图书名        作者      图书状态");
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

/**
 * 更新图书方法
 */
public void updatebookshow(String type) {
	Scanner input = new Scanner(System.in);
	if("图书".equals(type)){
		System.out.println("           --欢迎进入图书信息修该界面--");
		System.out.println("---------------------------------------");
	}else{
			
		}
		try {
			BookController uc = new BookController();
			System.out.println("请输入需要修改图书的编号：");
			int bid = input.nextInt();
			BookVO book = uc.dofindBookByid(bid);
			System.out.println("---------------------------------------");
			System.out.println("请输入修改图书编号：");
			book.setBid(input.nextInt());
			System.out.println("请输入修改图书名称：");
			book.setBname(input.next());
			System.out.println("请输入修改图书作者：");
			book.setBauthor(input.next());
			System.out.println("请输入修改图书状态：");
			book.setBstate(input.next());
			
			boolean binsert = uc.doupdatbook(book);
			if(binsert){
					System.out.println("图书信息修改成功！");
			}else{
				
					System.out.println("图书信息修改失败！");
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("图书信息修改失败！！");
		}
	}
/**
 * 用户更新方法
 */
public void updateUsershow() {
	Scanner input = new Scanner(System.in);
	System.out.println("        --欢迎进入用户信息修改界面--");
	System.out.println("---------------------------------------");
		try {
			UserController uc = new UserController();
//			System.out.println("请输入需要修改信息的编号：");
//			String bid = input.next();
//			UserVO user = uc.dofindUserByid(bid);
//			System.out.println("------------------------------------------");
			System.out.println("请输入您要修改的账号：");
			user.setAid(input.next());
			System.out.println("请输入您要修改的密码：");
			user.setApassword(input.next());
			System.out.println("请输入您要修改的昵称：");
			user.setAname(input.next());
			System.out.println("请输入您要修改的权限：");
			String power = input.next();
			if(power.equals("管理员"))
			{
				user.setPower(1);
			}else{
				user.setPower(2);
			}
			
			System.out.println("---------------------------------------");
			System.out.println("修改后的个人信息：");
			System.out.println("编号             昵称               密码                       权限");
			System.out.println(""+user.getAid()+"    "+user.getAname()+"          "+user.getApassword()+"     "+power+"");
			boolean binsert = uc.doupdateuser(user);
			//System.out.println(binsert);
			if(binsert){
				System.out.println("用户信息修改成功！");
			}else{
				System.out.println("用户信息修改失败！");	
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("用户信息修改失败！");	
		}
	}
/**
 *  根据图书名称模糊查找图书方法
 * 
 */
public void searchBookBynameshow() {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	Vector<BookVO>  v = new Vector<BookVO>();
	try {
		
		System.out.println("        --欢迎进入图书信息查询界面--");
		System.out.println("---------------------------------------");
		BookController bc = new BookController();
		System.out.println("请输入查找图书名称");
		String name = input.next();
		v = bc.dofindBookByName(name);
		System.out.println("图书编号     图书名        作者      图书状态");
		for(BookVO book:v)
		{
		  System.out.println(""+book.getBid()+"      "+book.getBname()+"            "+book.getBauthor()+"       "+book.getBstate()+"");
		  System.out.println("---------------------------------------");
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("按图书名查找图书信息失败！"+e.getMessage());
	}	
}
 /**
  * 分页查询图书信息
  */
    public void  searchBookBypage(){
	// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Vector<BookVO> v = new Vector<BookVO>();
		try {
			
			System.out.println("        --欢迎进入图书信息查询界面--");
			System.out.println("---------------------------------------");
			BookController bc = new BookController();
			System.out.println("请输入查找页号：");
			int pageNo = input.nextInt();
			System.out.println("请输入查找页大小：");
			int pagesize = input.nextInt();
			v = bc.dofindBookBypage(pageNo,pagesize);
			System.out.println("图书编号    图书名        作者      图书状态");
			for(BookVO book:v)
			{
			  System.out.println(""+book.getBid()+"      "+book.getBname()+"            "+book.getBauthor()+"       "+book.getBstate()+"");
			  System.out.println("---------------------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("分页查找图书信息失败！"+e.getMessage());
		}	
	}
 
    /**
     *  根据读者id号查找读者方法
     *
     */
  public void searchReadershow() {
    	// TODO Auto-generated method stub
    	Scanner input = new Scanner(System.in);
    	ReaderVO reader = null;
    	try {
    		
    		System.out.println("        --欢迎进入 读者信息查询界面--");
    		System.out.println("---------------------------------------");
    		ReaderController bc = new ReaderController(); 
    		System.out.println("请输入查找读者id号");
    		String bid = input.next();
    		reader = bc.dofindReaderByid(bid);
    		System.out.println("读者编号            名称       年龄             性别              班级                  院系                          邮箱 ");
    		System.out.println(""+reader.getSid()+"      "+reader.getSname()+"       "+reader.getSage()+"     "+reader.getSsex()+"              "+reader.getSclassid()+"    "+reader.getSdepartment()+"           "+reader.getSemail()+"");    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("图书信息查找失败！"+e.getMessage());
    	}	
    }
  /**
   *  查找所有读者信息
   * 
   */
public void searchAllRedadershow() {
  	// TODO Auto-generated method stub
  	Scanner input = new Scanner(System.in);
  	Vector<ReaderVO> v = new Vector<ReaderVO>();
  	try {
  		
  		System.out.println("        --欢迎进入 读者信息查询界面--");
  		System.out.println("---------------------------------------");
  		ReaderController bc = new ReaderController(); 
  		v = bc.dofindAllReader();
  		System.out.println("读者编号            名称       年龄             性别              班级                  院系                          邮箱 ");
  		for(ReaderVO reader:v){
  		System.out.println(""+reader.getSid()+"      "+reader.getSname()+"       "+reader.getSage()+"     "+reader.getSsex()+"              "+reader.getSclassid()+"    "+reader.getSdepartment()+"           "+reader.getSemail()+"");
  		System.out.println("---------------------------------------");
  		}
  	} catch (Exception e) {
  		// TODO: handle exception
  		System.out.println("图书信息查找失败！"+e.getMessage());
  	}	
  }
}
