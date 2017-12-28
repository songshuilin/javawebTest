package com.snowfish.cn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.snowfish.cn.utils.JdbcUtils;


public class JDBCTest {
	@Test
	public  void Test() throws ClassNotFoundException {
		String url="jdbc:mysql://localhost/song";
		String username="root";
		String password="123";
		String name = "com.mysql.jdbc.Driver"; 
		try {
			Class.forName(name);  
			Connection conn = DriverManager.getConnection(url, username, password);//获取连接  
			System.out.println(conn);
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//指定连接类型  
	}
	@Test
	public void test1() throws ClassNotFoundException, IOException, SQLException {
		Connection c=JdbcUtils.getConnection();
		System.out.println(c);
	}
}
