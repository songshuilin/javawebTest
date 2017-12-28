package com.snowfish.uitls;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUitls {

	private static Properties p;

	static {
		try {
			InputStream is=  JDBCUitls.class.getClassLoader().
					getResourceAsStream("db.properties");
			p=new Properties();
			p.load(is);
			Class.forName(p.getProperty("name"));
		} catch (ClassNotFoundException e) {
			new RuntimeException(e);
		} catch (IOException e) {
			new RuntimeException(e);
		}

	}


	public static Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(p.getProperty("url"),
					p.getProperty("username"), p.getProperty("password"));
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
