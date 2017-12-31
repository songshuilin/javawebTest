package com.snowfish.test;

import java.sql.SQLException;

import com.snowfish.dao.StudentDao;
import com.snowfish.domain.Student;


public class Test {
	public static void main(String[] args) {
		StudentDao dao=new StudentDao();

		for (int i = 100; i < 300; i++) {
			Student student=new Student();
			student.setDesc("我是学生"+i);
			student.setHobby("encode "+i+" year");
			student.setMajor(i/2==0?"计算机专业":"英文专业");
			student.setName("我的名字是"+i);
			student.setPhone(i/2==0?"1234"+i:"9876"+i);
			student.setSex(i/2==0?"男":"女");
			student.setNumber("100"+i);
			dao.addStudent(student);
		}
	}
}
