package com.snowfish.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.snowfish.domain.Manager;
import com.snowfish.uitls.JDBCUitls;

public class ManagerDao {
	Connection conn=JDBCUitls.getConnection();

	public void add(Manager manager) {
		String sql="insert into m_manager (m_username,m_password) values (?,?)";
		PreparedStatement state=null;
		try {
			state=conn.prepareStatement(sql);
			state.setString(1, manager.getUseranme());
			state.setString(2, manager.getPassword());
			state.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			throw new RuntimeException(e);
		}finally {
//			if (state!=null) {
//				try {
//					state.close();
//					state=null;
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//					conn=null;
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
	public boolean find(Manager manager) {
		String sql="select * from m_manager where m_username=? and m_password=?";
		PreparedStatement state = null;
		try {
			state = conn.prepareStatement(sql);
			state.setString(1, manager.getUseranme());
			state.setString(2, manager.getPassword());
			ResultSet result=state.executeQuery();
			if (result.next()) {
				System.out.println("false"+result);
				return true;
			}
			System.out.println("true"+result);
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
//			if (state!=null) {
//				try {
//					state.close();
//					state=null;
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//					conn=null;
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
}
