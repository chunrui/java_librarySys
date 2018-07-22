package com.lingnan.usersys.common.exception;
/**
 * Date异常类
 * @author Administrator
 *
 */
public class DateException extends RuntimeException{
		/**
		 * 默认的构造方法
		 */
        public DateException(){
			
		}
		/**
		 * 构造方法
		 * 描述异常的详细信息
		 * @param arg0   出错参数
		 */
		public DateException(String arg0){
			super(arg0);
		}
		/**
		 * 构造方法
		 * 描述产生异常的原因
		 * @param arg1    出错参数
		 */
		public DateException(Throwable arg1){
			super(arg1);
		}
		
		/**
		 * 构造方法
		 * 描述产生异常的详细信息、原因
		 * @param arg0    出错参数
		 * @param arg1    出错参数
		 */
		public DateException(String arg0,Throwable arg1){
			super(arg0,arg1);
		}

}
