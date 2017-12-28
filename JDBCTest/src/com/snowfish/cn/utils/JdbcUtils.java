package com.snowfish.cn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	private static Properties p;

	static {
		try {
			InputStream is=  JdbcUtils.class.getClassLoader().
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


	public static Connection getConnection() throws SQLException{
		Connection conn=	DriverManager.getConnection(p.getProperty("url"),
				p.getProperty("username"), p.getProperty("password"));

		return conn;
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Connection c= getConnection() ;
		System.out.println(c);
	}
}
