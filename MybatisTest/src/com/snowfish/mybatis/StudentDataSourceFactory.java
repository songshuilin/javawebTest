package com.snowfish.mybatis;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class StudentDataSourceFactory {

	public static DataSource getStudentDataSource(){
		DataSource ds=new DataSource() {

			public <T> T unwrap(Class<T> iface) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean isWrapperFor(Class<?> iface) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public void setLoginTimeout(int seconds) throws SQLException {
				// TODO Auto-generated method stub

			}

			public void setLogWriter(PrintWriter out) throws SQLException {
				// TODO Auto-generated method stub

			}

			public Logger getParentLogger() throws SQLFeatureNotSupportedException {
				// TODO Auto-generated method stub
				return null;
			}

			public int getLoginTimeout() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public PrintWriter getLogWriter() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public Connection getConnection(String username, String password) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public Connection getConnection() throws SQLException {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/song";
					System.out.println(url);
					String user="root";
					String password="123";
					Connection connection = DriverManager.getConnection(url, user, password);
					return connection;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return null;
			}
		};
		return ds;
	}

}
