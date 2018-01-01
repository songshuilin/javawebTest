package com.snowfish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.snowfish.domain.PageBean;
import com.snowfish.domain.Student;
import com.snowfish.uitls.JDBCUitls;


public class StudentDao {
	Connection conn=JDBCUitls.getConnection();
	public List<Student> findAll() {
		String sql="select * from t_student";
		List<Student> list_student=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet result=preparedStatement.executeQuery();
			while(result.next()) {
				Student student=new Student();
				student.setT_desc(result.getString("t_desc"));
				student.setT_hobby(result.getString("t_hobby"));
				student.setT_major(result.getString("t_major"));
				student.setT_name(result.getString("t_name"));
				student.setT_number(result.getString("t_number"));
				student.setT_sex(result.getString("t_sex"));
				student.setT_phone(result.getString("t_phone"));
				list_student.add(student);   	
			}

			return list_student;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void addStudent(Student student) {
		String sql="insert into t_student (t_desc,t_hobby,"
				+ "t_major,t_name,t_number,t_sex,t_phone) "
				+ "values(?,?,?,?,?,?,?)";
		System.out.println(sql);
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, student.getT_desc());
			preparedStatement.setString(2, student.getT_hobby());
			preparedStatement.setString(3, student.getT_major());
			preparedStatement.setString(4, student.getT_name());
			preparedStatement.setString(5, student.getT_number());
			preparedStatement.setString(6, student.getT_sex());
			preparedStatement.setString(7, student.getT_phone());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public Student find(String number) {
		try {

			String sql="select * from t_student where t_number=?";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, number);
			ResultSet result=preparedStatement.executeQuery();
			Student student=null;
			while(result.next()) {
				student=new Student();
				student.setT_desc(result.getString("t_desc"));
				student.setT_hobby(result.getString("t_hobby"));
				student.setT_major(result.getString("t_major"));
				student.setT_name(result.getString("t_name"));
				student.setT_number(result.getString("t_number"));
				student.setT_sex(result.getString("t_sex"));
				student.setT_phone(result.getString("t_phone"));
			}
			return student;	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public void update(Student student) {
		System.out.println(student.toString());
		String sql="update t_student set t_desc =? "
				+ ", t_hobby=? , t_major=? , t_name=? , "
				+ "t_sex=? , t_phone=? "
				+ "where t_number = ?";

		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, student.getT_desc());
			preparedStatement.setString(2, student.getT_hobby());
			preparedStatement.setString(3, student.getT_major());
			preparedStatement.setString(4, student.getT_name());
			preparedStatement.setString(5, student.getT_sex());
			preparedStatement.setString(6, student.getT_phone());
			preparedStatement.setString(7, student.getT_number());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void delete(String number) {
		String sql="delete from t_student where t_number=?";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, number);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public PageBean<Student> findAll(int currentPage, int recoderForPage) {
		List<Student> list=new ArrayList<>();
		PageBean<Student> bean=new PageBean<>();
		bean.setRecoderForPage(recoderForPage);
		bean.setCurrentPage(currentPage);
		String sql="select count(*)  totleRecoder from t_student ";

		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			ResultSet set= preparedStatement.executeQuery();
			while (set.next()) {

				bean.setTotleRecoder(set.getInt("totleRecoder"));
				System.out.println(set.getInt("totleRecoder"));
			}

			sql="select *  from t_student limit ?,?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, (currentPage-1)*recoderForPage);
			preparedStatement.setInt(2, recoderForPage);
			set=preparedStatement.executeQuery();
			while(set.next()) {
				Student student=new Student();
				student.setT_desc(set.getString("t_desc"));
				student.setT_hobby(set.getString("t_hobby"));
				student.setT_major(set.getString("t_major"));
				student.setT_name(set.getString("t_name"));
				student.setT_number(set.getString("t_number"));
				student.setT_sex(set.getString("t_sex"));
				student.setT_phone(set.getString("t_phone"));
				list.add(student);		
			}
			System.out.println(list);
			bean.setList(list);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}

	}	
}

