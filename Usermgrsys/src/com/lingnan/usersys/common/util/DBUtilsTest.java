package com.lingnan.usersys.common.util;
import java.sql.Connection;
import org.junit.Test;
/**
 * 连接测试类
 * @author Administrator
 *
 */
public class DBUtilsTest {

	/**
	 * 数据库连接测试方法
	 */
	public void testGetConnection() {
		Connection connection =DBUtils.getConnection();
		System.out.print(connection);
	}

}
