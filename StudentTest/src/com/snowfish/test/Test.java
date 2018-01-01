package com.snowfish.test;

import java.sql.SQLException;

import com.snowfish.dao.StudentDao;
import com.snowfish.domain.Student;


public class Test {
	public static void main(String[] args) {
		StudentDao dao=new StudentDao();

		for (int i = 100; i < 300; i++) {
			Student student=new Student();
			student.setT_desc("我是学生"+i);
			student.setT_hobby("encode "+i+" year");
			student.setT_major(i/2==0?"计算机专业":"英文专业");
			student.setT_name("我的名字是"+i);
			student.setT_phone(i/2==0?"1234"+i:"9876"+i);
			student.setT_sex(i/2==0?"男":"女");
			student.setT_number("100"+i);
			dao.addStudent(student);
		}
	}
}
